package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Sickle extends Item {


    public Sickle(Properties properties) {
        super(properties);
    }



    @Override
    public boolean mineBlock(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {

        if(stack.getItem() instanceof Sickle && !RegisterItems.superSickle.equals(stack.getItem())){
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            if (world.getBlockState(pos).getMaterial() == Material.PLANT || world.getBlockState(pos).getMaterial() == Material.WATER_PLANT || world.getBlockState(pos).getMaterial() == Material.REPLACEABLE_WATER_PLANT || world.getBlockState(pos).getMaterial() == Material.REPLACEABLE_PLANT){
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {

                        BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                        if (world.getBlockState(newBlockPos).getMaterial() == Material.PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.WATER_PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.REPLACEABLE_WATER_PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.REPLACEABLE_PLANT) {
                            world.destroyBlock(newBlockPos, true);
                        }

                    }
                }
                stack.setDamageValue(stack.getDamageValue() + 1);
                if(stack.getDamageValue() >= stack.getMaxDamage()){
                    stack.shrink(1);
                }
            }

        }else if(RegisterItems.superSickle.equals(stack.getItem())){
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            if (world.getBlockState(pos).getMaterial() == Material.PLANT || world.getBlockState(pos).getMaterial() == Material.WATER_PLANT || world.getBlockState(pos).getMaterial() == Material.REPLACEABLE_WATER_PLANT || world.getBlockState(pos).getMaterial() == Material.REPLACEABLE_PLANT){
                for (int x = -4; x < 5; x++) {
                    for (int z = -4; z < 5; z++) {

                        BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                        if (world.getBlockState(newBlockPos).getMaterial() == Material.PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.WATER_PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.REPLACEABLE_WATER_PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.REPLACEABLE_PLANT) {
                            world.destroyBlock(newBlockPos, true);
                        }

                    }
                }
                stack.setDamageValue(stack.getDamageValue() + 1);
                if(stack.getDamageValue() >= stack.getMaxDamage()){
                    stack.shrink(1);
                }
            }
        }
        return super.mineBlock(stack, world, state, pos, entityLiving);
    }



    @Override
    public ActionResultType useOn(ItemUseContext context) {
        ItemStack stack = context.getItemInHand();
        World world = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (RegisterItems.superSickle.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

                for (int x = -4; x < 5; x++) {
                    for (int z = -4; z < 5; z++) {

                        BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                        if (world.getBlockState(newBlockPos).getMaterial() == Material.PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.WATER_PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.REPLACEABLE_WATER_PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.REPLACEABLE_PLANT) {
                            world.destroyBlock(newBlockPos, true);

                            if(!context.getPlayer().isCreative()){
                                stack.setDamageValue(stack.getDamageValue() + 1);
                                if(stack.getDamageValue() >= stack.getMaxDamage()){
                                    stack.shrink(1);
                                }
                            }

                        }

                    }
                }

        }

        return super.useOn(context);
    }

}
