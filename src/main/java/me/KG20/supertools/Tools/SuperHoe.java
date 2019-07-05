package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.INBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class SuperHoe extends HoeItem {

    public SuperHoe(IItemTier material, float speed, Properties properties) {
        super(material, speed, properties);
    }


    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();

        if (RegisterItems.superHoe.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            ArrayList<INBT> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";

            enchantments.add(INBT.create((byte) 0));

            for(INBT enchantment : stack.getEnchantmentTagList()){
                enchantments.add(enchantment);
            }

            for(int i=0;i<enchantments.size(); i++){
                if(enchantments.get(i).toString().contains("minecraft:unbreaking")){
                    unbreakingEnchantment = enchantments.get(i).toString();
                }
            }



            if(world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK){
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        if(world.getBlockState(new BlockPos(bx + x,by + 1,bz + z)).getBlock() == Blocks.AIR){
                            if (world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.DIRT || world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.GRASS_BLOCK) {
                                world.setBlockState(new BlockPos(bx + x, by, bz + z), Blocks.FARMLAND.getDefaultState());
                                if(!context.getPlayer().isCreative()){
                                    if(unbreakingEnchantment.length() != 0){
                                        if(unbreakingEnchantment.contains("lvl:1")){
                                            if(random.nextInt(100) + 1 <= 50){
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:2")){
                                            if(random.nextInt(100) + 1 <= 33){
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:3")){
                                            if(random.nextInt(100) + 1 <= 25){
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }
                                    }else{
                                        stack.setDamage(stack.getDamage() + 1);
                                    }
                                }

                            }else if(world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.COARSE_DIRT){
                                world.setBlockState(new BlockPos(bx + x, by, bz + z), Blocks.DIRT.getDefaultState());
                                if(!context.getPlayer().isCreative()){
                                    if(unbreakingEnchantment.length() != 0){
                                        if(unbreakingEnchantment.contains("lvl:1")){
                                            if(random.nextInt(100) + 1 <= 50){
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:2")){
                                            if(random.nextInt(100) + 1 <= 33){
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:3")){
                                            if(random.nextInt(100) + 1 <= 25){
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }
                                    }else{
                                        stack.setDamage(stack.getDamage() + 1);
                                    }
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
