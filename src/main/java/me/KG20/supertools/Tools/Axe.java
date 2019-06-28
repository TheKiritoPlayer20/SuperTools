package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;

public class Axe extends AxeItem {

    public Axe(IItemTier material, float speed) {
        super(material, 6, speed, new Properties().group(CreativeTabs.tools).addToolType(ToolType.AXE, material.getHarvestLevel()));
    }

    public Axe(IItemTier material, float speed, Properties properties) {
        super(material, 6, speed, properties.addToolType(ToolType.AXE, material.getHarvestLevel()));
    }


    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        Block startLog = state.getBlock();
        BlockPos currentPos = pos;
        ArrayList<BlockPos> brokenBlocks = new ArrayList<BlockPos>();
        ArrayList<BlockPos> nextPos = new ArrayList<BlockPos>();

        if(RegisterItems.superAxe.equals(stack.getItem()) && startLog.getBlock() == Blocks.ACACIA_LOG || startLog.getBlock() == Blocks.BIRCH_LOG || startLog.getBlock() == Blocks.DARK_OAK_LOG
                || startLog.getBlock() == Blocks.JUNGLE_LOG || startLog.getBlock() == Blocks.OAK_LOG || startLog.getBlock() == Blocks.SPRUCE_LOG){

            brokenBlocks.add(pos);
            while(stack.getDamage() != stack.getMaxDamage()){
                ArrayList<BlockPos> logNeighbours = getWoodNeighbours(world,currentPos,startLog);
                logNeighbours.removeAll(brokenBlocks);
                if(logNeighbours.size() > 0){
                    for(BlockPos blockPos : logNeighbours){
                        brokenBlocks.add(blockPos);
                        nextPos.add(blockPos);
                        world.destroyBlock(blockPos, true);
                        stack.setDamage(stack.getDamage() + 1);
                    }
                }
                if(nextPos.size() > 0){
                    currentPos = nextPos.get(0);
                    nextPos.remove(currentPos);
                }else
                    break;
            }



        }

        return super.onBlockDestroyed(stack, world, state, pos, entityLiving);
    }

    private ArrayList<BlockPos> getWoodNeighbours(World world, BlockPos blockPos, Block block) {
        ArrayList<BlockPos> list = new ArrayList<BlockPos>();
        for(int x=-1; x<=1; x++){
            for(int y=-1; y<=1; y++){
                for(int z=-1; z<=1; z++) {
                    if(world.getBlockState(blockPos.add(x,y,z)).getBlock().equals(block)) {
                        list.add(blockPos.add(x,y,z));
                    }
                }
            }
        }

        return list;
    }

}
