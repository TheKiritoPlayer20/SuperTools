package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.NoteBlockEvent;

public class Sickle extends Item {


    public Sickle(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {

        if(stack.getItem() instanceof Sickle && !RegisterItems.superSickle.equals(stack.getItem())){
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            if (world.getBlockState(pos).getMaterial() == Material.PLANTS || world.getBlockState(pos).getMaterial() == Material.TALL_PLANTS || world.getBlockState(pos).getMaterial() == Material.OCEAN_PLANT || world.getBlockState(pos).getMaterial() == Material.SEA_GRASS){
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {

                        BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                        if (world.getBlockState(newBlockPos).getMaterial() == Material.PLANTS || world.getBlockState(newBlockPos).getMaterial() == Material.TALL_PLANTS || world.getBlockState(newBlockPos).getMaterial() == Material.OCEAN_PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.SEA_GRASS) {
                            world.destroyBlock(newBlockPos, true);
                        }

                    }
                }
                stack.setDamage(stack.getDamage() + 1);
                if(stack.getDamage() >= stack.getMaxDamage()){
                    stack.shrink(1);
                }
            }

        }else if(RegisterItems.superSickle.equals(stack.getItem())){
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            if (world.getBlockState(pos).getMaterial() == Material.PLANTS || world.getBlockState(pos).getMaterial() == Material.TALL_PLANTS || world.getBlockState(pos).getMaterial() == Material.OCEAN_PLANT || world.getBlockState(pos).getMaterial() == Material.SEA_GRASS){
                for (int x = -4; x < 5; x++) {
                    for (int z = -4; z < 5; z++) {

                        BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                        if (world.getBlockState(newBlockPos).getMaterial() == Material.PLANTS || world.getBlockState(newBlockPos).getMaterial() == Material.TALL_PLANTS || world.getBlockState(newBlockPos).getMaterial() == Material.OCEAN_PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.SEA_GRASS) {
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



    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        ItemStack stack = context.getItem();
        World world = context.getWorld();
        BlockPos pos = context.getPos();

        if (RegisterItems.superSickle.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

                for (int x = -4; x < 5; x++) {
                    for (int z = -4; z < 5; z++) {

                        BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                        if (world.getBlockState(newBlockPos).getMaterial() == Material.PLANTS || world.getBlockState(newBlockPos).getMaterial() == Material.TALL_PLANTS || world.getBlockState(newBlockPos).getMaterial() == Material.OCEAN_PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.SEA_GRASS) {
                            world.destroyBlock(newBlockPos, true);

                            if(!context.getPlayer().isCreative()){
                                stack.setDamage(stack.getDamage() + 1);
                                if(stack.getDamage() >= stack.getMaxDamage()){
                                    stack.shrink(1);
                                }
                            }

                        }

                    }
                }

        }

        return super.onItemUse(context);
    }

}
