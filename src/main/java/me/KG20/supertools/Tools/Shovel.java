package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.AxisRotation;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Shovel extends ShovelItem {

    public Shovel(IItemTier material, float speed) {
        super(material, 1.5F, speed, new Properties().group(CreativeTabs.tools).addToolType(ToolType.SHOVEL, material.getHarvestLevel()));
    }

    public Shovel(IItemTier material, float speed, Properties properties) {
        super(material, 1.5F, speed, properties.addToolType(ToolType.SHOVEL, material.getHarvestLevel()));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if(RegisterItems.superShovel.equals(stack.getItem())){
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            Direction headRot = entityLiving.getHorizontalFacing();
            World world = entityLiving.getEntityWorld();

            if(entityLiving.getLookVec().y <= -0.50f || entityLiving.getLookVec().y >= 0.50f){
                for(int x = -1; x< 2; x++){
                    for(int z = -1; z<2; z++){

                        if(world.getBlockState(new BlockPos(bx + x,by , bz + z)).getMaterial() == Material.EARTH || world.getBlockState(new BlockPos(bx + x,by , bz + z)).getMaterial() == Material.SAND || world.getBlockState(new BlockPos(bx + x,by, bz + z)).getMaterial() == Material.ORGANIC){
                            world.destroyBlock(new BlockPos(bx + x,by , bz + z),true);
                            stack.setDamage(stack.getDamage() + 1);
                        }

                    }
                }
            }
            else if(headRot.equals(Direction.NORTH) || headRot.equals(Direction.SOUTH)){
                for(int x = -1; x< 2; x++){
                    for(int y = -1; y<2; y++){

                        if(world.getBlockState(new BlockPos(bx + x,by + y, bz)).getMaterial() == Material.EARTH || world.getBlockState(new BlockPos(bx + x,by + y, bz)).getMaterial() == Material.SAND || world.getBlockState(new BlockPos(bx + x,by + y, bz)).getMaterial() == Material.ORGANIC){
                            world.destroyBlock(new BlockPos(bx + x,by + y, bz),true);
                            stack.setDamage(stack.getDamage() + 1);
                        }

                    }
                }
            }else if(headRot.equals(Direction.WEST) || headRot.equals(Direction.EAST)){
                for(int z = -1; z< 2; z++){
                    for(int y = -1; y<2; y++){

                        if(world.getBlockState(new BlockPos(bx ,by + y, bz + z)).getMaterial() == Material.EARTH || world.getBlockState(new BlockPos(bx ,by + y, bz + z)).getMaterial() == Material.SAND || world.getBlockState(new BlockPos(bx ,by + y, bz + z)).getMaterial() == Material.ORGANIC){
                            world.destroyBlock(new BlockPos(bx ,by + y, bz + z),true);
                            stack.setDamage(stack.getDamage() + 1);
                        }

                    }
                }
            }





        }


        return false;
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();

        if (RegisterItems.superShovel.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            if(world.getBlockState(pos).getBlock() == Blocks.GRASS) {
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        if (world.getBlockState(new BlockPos(bx + x, by + 1, bz + z)).getBlock() == Blocks.AIR) {
                            if (world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.GRASS_BLOCK) {
                                world.setBlockState(new BlockPos(bx + x, by, bz + z), Blocks.GRASS_PATH.getDefaultState());
                                if (!context.getPlayer().isCreative()) {
                                    stack.setDamage(stack.getDamage() + 1);
                                }

                            }
                        }
                    }
                }
            }
        }
        return null;
    }

}
