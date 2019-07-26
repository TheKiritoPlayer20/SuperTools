package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Sickle extends Item {


    public Sickle(Properties properties) {
        super(properties.group(CreativeTabs.tools));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {

        if(stack.getItem() instanceof Sickle){
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            if (world.getBlockState(pos).getMaterial() == Material.PLANTS || world.getBlockState(pos).getMaterial() == Material.TALL_PLANTS || world.getBlockState(pos).getMaterial() == Material.OCEAN_PLANT){
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {

                        BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                        if (world.getBlockState(newBlockPos).getMaterial() == Material.PLANTS || world.getBlockState(newBlockPos).getMaterial() == Material.TALL_PLANTS || world.getBlockState(newBlockPos).getMaterial() == Material.OCEAN_PLANT) {
                            world.destroyBlock(newBlockPos, true);
                        }

                    }
                }
                stack.setDamage(stack.getDamage() + 1);
                if(stack.getDamage() >= stack.getMaxDamage()){
                    stack.shrink(1);
                }
            }

        }

        return super.onBlockDestroyed(stack, world, state, pos, entityLiving);
    }
}
