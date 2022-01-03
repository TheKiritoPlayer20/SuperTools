package me.KG20.supertools.Tools;

import me.KG20.supertools.Config.Config;
import me.KG20.supertools.Init.CreativeTabs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.BaseCoralWallFanBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class BonemealTool extends Item {
    public BonemealTool() {
        super(new Item.Properties().durability(Config.durability_BoneMealTool.get()).tab(CreativeTabs.supertools));
    }

    /**
     * Called when this item is used when targetting a Block
     */
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
        if (applyBonemeal(context.getItemInHand(), level, blockpos, context.getPlayer())) {
            if (!level.isClientSide) {
                level.levelEvent(1505, blockpos, 0);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            BlockState blockstate = level.getBlockState(blockpos);
            boolean flag = blockstate.isFaceSturdy(level, blockpos, context.getClickedFace());
            if (flag && growWaterPlant(context.getItemInHand(), level, blockpos1, context.getClickedFace())) {
                if (!level.isClientSide) {
                    level.levelEvent(1505, blockpos1, 0);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    @Deprecated //Forge: Use Player/Hand version
    public static boolean growCrop(ItemStack stack, Level level, BlockPos blockPos) {
        if (level instanceof net.minecraft.server.level.ServerLevel)
            return applyBonemeal(stack, level, blockPos, net.minecraftforge.common.util.FakePlayerFactory.getMinecraft((net.minecraft.server.level.ServerLevel)level));
        return false;
    }

    public static boolean applyBonemeal(ItemStack stack, Level level, BlockPos blockPos, net.minecraft.world.entity.player.Player player) {
        BlockState blockstate = level.getBlockState(blockPos);
        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, level, blockPos, blockstate, stack);
        if (hook != 0) return hook > 0;
        if (blockstate.getBlock() instanceof BonemealableBlock) {
            BonemealableBlock bonemealableblock = (BonemealableBlock)blockstate.getBlock();
            if (bonemealableblock.isValidBonemealTarget(level, blockPos, blockstate, level.isClientSide)) {
                if (level instanceof ServerLevel) {
                    if (bonemealableblock.isBonemealSuccess(level, level.random, blockPos, blockstate)) {
                        bonemealableblock.performBonemeal((ServerLevel)level, level.random, blockPos, blockstate);
                    }
                    if(!player.isCreative()) {
                        stack.setDamageValue(stack.getDamageValue() + 1);
                        if(stack.getDamageValue() >= stack.getMaxDamage()){
                            stack.shrink(1);
                        }
                    }

                }
                return true;
            }
        }

        return false;
    }

    public static boolean growWaterPlant(ItemStack stack, Level level, BlockPos blockPos, @Nullable Direction direction) {
        if (level.getBlockState(blockPos).is(Blocks.WATER) && level.getFluidState(blockPos).getAmount() == 8) {
            if (!(level instanceof ServerLevel)) {
                return true;
            } else {
                Random random = level.getRandom();

                label80:
                for(int i = 0; i < 128; ++i) {
                    BlockPos blockpos = blockPos;
                    BlockState blockstate = Blocks.SEAGRASS.defaultBlockState();

                    for(int j = 0; j < i / 16; ++j) {
                        blockpos = blockpos.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                        if (level.getBlockState(blockpos).isCollisionShapeFullBlock(level, blockpos)) {
                            continue label80;
                        }
                    }

                    Optional<ResourceKey<Biome>> optional = level.getBiomeName(blockpos);
                    if (Objects.equals(optional, Optional.of(Biomes.WARM_OCEAN))) {
                        if (i == 0 && direction != null && direction.getAxis().isHorizontal()) {
                            blockstate = BlockTags.WALL_CORALS.getRandomElement(level.random).defaultBlockState().setValue(BaseCoralWallFanBlock.FACING, direction);
                        } else if (random.nextInt(4) == 0) {
                            blockstate = BlockTags.UNDERWATER_BONEMEALS.getRandomElement(random).defaultBlockState();
                        }
                    }

                    if (blockstate.is(BlockTags.WALL_CORALS)) {
                        for(int k = 0; !blockstate.canSurvive(level, blockpos) && k < 4; ++k) {
                            blockstate = blockstate.setValue(BaseCoralWallFanBlock.FACING, Direction.Plane.HORIZONTAL.getRandomDirection(random));
                        }
                    }

                    if (blockstate.canSurvive(level, blockpos)) {
                        BlockState blockstate1 = level.getBlockState(blockpos);
                        if (blockstate1.is(Blocks.WATER) && level.getFluidState(blockpos).getAmount() == 8) {
                            level.setBlock(blockpos, blockstate, 3);
                        } else if (blockstate1.is(Blocks.SEAGRASS) && random.nextInt(10) == 0) {
                            ((BonemealableBlock)Blocks.SEAGRASS).performBonemeal((ServerLevel)level, random, blockpos, blockstate1);
                        }
                    }
                }
                stack.setDamageValue(stack.getDamageValue() + 1);
                if(stack.getDamageValue() >= stack.getMaxDamage()){
                        stack.shrink(1);
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public static void addGrowthParticles(LevelAccessor levelAccessor, BlockPos blockPos, int value) {
        if (value == 0) {
            value = 15;
        }

        BlockState blockstate = levelAccessor.getBlockState(blockPos);
        if (!blockstate.isAir()) {
            double d0 = 0.5D;
            double d1;
            if (blockstate.is(Blocks.WATER)) {
                value *= 3;
                d1 = 1.0D;
                d0 = 3.0D;
            } else if (blockstate.isSolidRender(levelAccessor, blockPos)) {
                blockPos = blockPos.above();
                value *= 3;
                d0 = 3.0D;
                d1 = 1.0D;
            } else {
                d1 = blockstate.getShape(levelAccessor, blockPos).max(Direction.Axis.Y);
            }

            levelAccessor.addParticle(ParticleTypes.HAPPY_VILLAGER, (double)blockPos.getX() + 0.5D, (double)blockPos.getY() + 0.5D, (double)blockPos.getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
            Random random = levelAccessor.getRandom();

            for(int i = 0; i < value; ++i) {
                double d2 = random.nextGaussian() * 0.02D;
                double d3 = random.nextGaussian() * 0.02D;
                double d4 = random.nextGaussian() * 0.02D;
                double d5 = 0.5D - d0;
                double d6 = (double)blockPos.getX() + d5 + random.nextDouble() * d0 * 2.0D;
                double d7 = (double)blockPos.getY() + random.nextDouble() * d1;
                double d8 = (double)blockPos.getZ() + d5 + random.nextDouble() * d0 * 2.0D;
                if (!levelAccessor.getBlockState((new BlockPos(d6, d7, d8)).below()).isAir()) {
                    levelAccessor.addParticle(ParticleTypes.HAPPY_VILLAGER, d6, d7, d8, d2, d3, d4);
                }
            }

        }
    }
}

