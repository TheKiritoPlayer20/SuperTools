package me.KG20.supertools.Tools;

import me.KG20.supertools.Config.Config;
import me.KG20.supertools.Init.CreativeTabs;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class BonemealTool extends Item {
    public BonemealTool() {
        super(new Item.Properties().maxDamage(Config.durability_BoneMealTool.get()).group(CreativeTabs.supertools));
    }

    /**
     * Called when this item is used when targetting a Block
     */
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockPos blockpos1 = blockpos.offset(context.getFace());
        if (applyBonemeal(context.getItem(), world, blockpos, context.getPlayer())) {
            if (!world.isRemote) {
                world.playEvent(2005, blockpos, 0);
            }

            return ActionResultType.SUCCESS;
        } else {
            BlockState blockstate = world.getBlockState(blockpos);
            boolean flag = blockstate.func_224755_d(world, blockpos, context.getFace());
            if (flag && growSeagrass(context.getItem(), world, blockpos1, context.getFace(), context.getPlayer())) {
                if (!world.isRemote) {
                    world.playEvent(2005, blockpos1, 0);
                }

                return ActionResultType.SUCCESS;
            } else {
                return ActionResultType.PASS;
            }
        }
    }

    @Deprecated //Forge: Use Player/Hand version
    public static boolean applyBonemeal(ItemStack p_195966_0_, World p_195966_1_, BlockPos p_195966_2_) {
        if (p_195966_1_ instanceof net.minecraft.world.server.ServerWorld)
            return applyBonemeal(p_195966_0_, p_195966_1_, p_195966_2_, net.minecraftforge.common.util.FakePlayerFactory.getMinecraft((net.minecraft.world.server.ServerWorld)p_195966_1_));
        return false;
    }

    public static boolean applyBonemeal(ItemStack stack, World world, BlockPos blockPos, net.minecraft.entity.player.PlayerEntity player) {
        BlockState blockstate = world.getBlockState(blockPos);
        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, world, blockPos, blockstate, stack);
        if (hook != 0) return hook > 0;
        if (blockstate.getBlock() instanceof IGrowable) {
            IGrowable igrowable = (IGrowable)blockstate.getBlock();
            if (igrowable.canGrow(world, blockPos, blockstate, world.isRemote)) {
                if (!world.isRemote) {
                    if (igrowable.canUseBonemeal(world, world.rand, blockPos, blockstate)) {
                        igrowable.grow(world, world.rand, blockPos, blockstate);
                    }
                    if(!player.isCreative()) {
                        stack.setDamage(stack.getDamage() + 1);
                        if(stack.getDamage() >= stack.getMaxDamage()){
                            stack.shrink(1);
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }

    public static boolean growSeagrass(ItemStack stack, World world, BlockPos blockPos, @Nullable Direction direction, net.minecraft.entity.player.PlayerEntity player) {
        if (world.getBlockState(blockPos).getBlock() == Blocks.WATER && world.getFluidState(blockPos).getLevel() == 8) {
            if (!world.isRemote) {
                label79:
                for(int i = 0; i < 128; ++i) {
                    BlockPos blockpos = blockPos;
                    Biome biome = world.getBiome(blockPos);
                    BlockState blockstate = Blocks.SEAGRASS.getDefaultState();

                    for(int j = 0; j < i / 16; ++j) {
                        blockpos = blockpos.add(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                        biome = world.getBiome(blockpos);
                        if (Block.isOpaque(world.getBlockState(blockpos).getCollisionShape(world, blockpos))) {
                            continue label79;
                        }
                    }

                    if (biome == Biomes.WARM_OCEAN || biome == Biomes.DEEP_WARM_OCEAN) {
                        if (i == 0 && direction != null && direction.getAxis().isHorizontal()) {
                            blockstate = BlockTags.WALL_CORALS.getRandomElement(world.rand).getDefaultState().with(DeadCoralWallFanBlock.FACING, direction);
                        } else if (random.nextInt(4) == 0) {
                            blockstate = BlockTags.UNDERWATER_BONEMEALS.getRandomElement(random).getDefaultState();
                        }
                    }

                    if (blockstate.getBlock().isIn(BlockTags.WALL_CORALS)) {
                        for(int k = 0; !blockstate.isValidPosition(world, blockpos) && k < 4; ++k) {
                            blockstate = blockstate.with(DeadCoralWallFanBlock.FACING, Direction.Plane.HORIZONTAL.random(random));
                        }
                    }

                    if (blockstate.isValidPosition(world, blockpos)) {
                        BlockState blockstate1 = world.getBlockState(blockpos);
                        if (blockstate1.getBlock() == Blocks.WATER && world.getFluidState(blockpos).getLevel() == 8) {
                            world.setBlockState(blockpos, blockstate, 3);
                        } else if (blockstate1.getBlock() == Blocks.SEAGRASS && random.nextInt(10) == 0) {
                            ((IGrowable)Blocks.SEAGRASS).grow(world, random, blockpos, blockstate1);
                        }
                    }
                }
                    if(!player.isCreative()) {
                        stack.setDamage(stack.getDamage() + 1);
                        if(stack.getDamage() >= stack.getMaxDamage()){
                            stack.shrink(1);
                        }
                    }
            }

            return true;
        } else {
            return false;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void spawnBonemealParticles(IWorld worldIn, BlockPos posIn, int data) {
        if (data == 0) {
            data = 15;
        }

        BlockState blockstate = worldIn.getBlockState(posIn);
        if (!blockstate.isAir(worldIn, posIn)) {
            for(int i = 0; i < data; ++i) {
                double d0 = random.nextGaussian() * 0.02D;
                double d1 = random.nextGaussian() * 0.02D;
                double d2 = random.nextGaussian() * 0.02D;
                worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, (double)((float)posIn.getX() + random.nextFloat()), (double)posIn.getY() + (double)random.nextFloat() * blockstate.getShape(worldIn, posIn).getEnd(Direction.Axis.Y), (double)((float)posIn.getZ() + random.nextFloat()), d0, d1, d2);
            }

        }
    }
}

