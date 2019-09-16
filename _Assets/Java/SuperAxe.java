package me.KG20.supertools.Tools;

import me.KG20.supertools.Config.Config;
import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import java.util.ArrayList;
import java.util.Random;

public class SuperAxe extends AxeItem {

    public SuperAxe(IItemTier material, float speed) {
        super(material, 6, speed, new Properties().group(CreativeTabs.tools).addToolType(ToolType.AXE, material.getHarvestLevel()));
    }

    public SuperAxe(IItemTier material, float speed, Properties properties) {
        super(material, 6, speed, properties.addToolType(ToolType.AXE, material.getHarvestLevel()));
    }


    //@Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        Block startLog = state.getBlock();
        BlockPos currentPos = pos;
        ArrayList<BlockPos> brokenBlocks = new ArrayList<>();
        ArrayList<BlockPos> nextPos = new ArrayList<>();
        int blocksHarvested = 0;

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




        if(RegisterItems.superAxe.equals(stack.getItem()) && startLog.getTags().toString().contains("logs") || RegisterItems.superAxe.equals(stack.getItem()) && startLog.getTags().toString().contains("log")){
            brokenBlocks.add(pos);
            while(stack.getDamage() != stack.getMaxDamage() && blocksHarvested <= Config.max_wood_logs.get()){
                ArrayList<BlockPos> logNeighbours = getWoodNeighbours(world,currentPos,startLog, stack);
                logNeighbours.removeAll(brokenBlocks);
                if(logNeighbours.size() > 0){
                    for(BlockPos blockPos : logNeighbours){
                        brokenBlocks.add(blockPos);
                        nextPos.add(blockPos);
                        world.destroyBlock(blockPos, true);
                        blocksHarvested += 1;
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
                if(nextPos.size() > 0){
                    currentPos = nextPos.get(0);
                    nextPos.remove(currentPos);
                }else
                    break;
            }



        }else{
            //stack.setDamage(stack.getDamage() + 1);
        }

        return super.onBlockDestroyed(stack, world, state, pos, entityLiving);
    }

    private ArrayList<BlockPos> getWoodNeighbours(World world, BlockPos blockPos, Block block, ItemStack stack) {
        ArrayList<BlockPos> list = new ArrayList<>();
        for(int x=-1; x<=1; x++){
            if(stack.getDamage() >= stack.getMaxDamage() - 1){
                stack.shrink(1);
                break;
            }
            for(int y=-1; y<=1; y++){
                if(stack.getDamage() >= stack.getMaxDamage() - 1){
                    stack.shrink(1);
                    break;
                }
                for(int z=-1; z<=1; z++) {
                    if(stack.getDamage() >= stack.getMaxDamage() - 1){
                        stack.shrink(1);
                        break;
                    }

                    if(world.getBlockState(blockPos.add(x,y,z)).getBlock().equals(block)) {
                        list.add(blockPos.add(x,y,z));
                    }
                }
            }
        }

        return list;
    }

}
