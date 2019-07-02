package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.Random;

public class Pickaxe extends PickaxeItem {

    public Pickaxe(IItemTier material, float speed) {
        super(material, 1, speed, new Properties().group(CreativeTabs.tools).addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
    }

    public Pickaxe(IItemTier material, float speed, Properties properties) {
        super(material, 1, speed, properties.addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if(RegisterItems.superPickaxe.equals(stack.getItem())){
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            Direction headRot = entityLiving.getHorizontalFacing();
            World world = entityLiving.getEntityWorld();

            if(entityLiving.getLookVec().y <= -0.52f || entityLiving.getLookVec().y >= 0.52f){
                for(int x = -1; x< 2; x++){
                    for(int z = -1; z<2; z++){

                        if(world.getBlockState(new BlockPos(bx + x,by , bz + z)).getMaterial() == Material.ROCK || world.getBlockState(new BlockPos(bx + x,by , bz + z)).getMaterial() == Material.IRON || world.getBlockState(new BlockPos(bx + x,by, bz + z)).getMaterial() == Material.ANVIL){
                            if(world.getBlockState(new BlockPos(bx + x,by , bz + z)).getBlock() != Blocks.BEDROCK){
                                world.destroyBlock(new BlockPos(bx + x,by , bz + z),true);
                                stack.setDamage(stack.getDamage() + 1);
                            }

                        }

                    }
                }
            }

            else if(headRot.equals(Direction.NORTH) || headRot.equals(Direction.SOUTH)){
                for(int x = -1; x< 2; x++){
                    for(int y = -1; y<2; y++){

                        if(world.getBlockState(new BlockPos(bx + x,by + y, bz)).getMaterial() == Material.ROCK || world.getBlockState(new BlockPos(bx + x,by + y, bz)).getMaterial() == Material.IRON || world.getBlockState(new BlockPos(bx + x,by + y, bz)).getMaterial() == Material.ANVIL){
                            if(world.getBlockState(new BlockPos(bx + x,by + y, bz)).getBlock() != Blocks.BEDROCK){
                                world.destroyBlock(new BlockPos(bx + x,by + y, bz),true);
                                stack.setDamage(stack.getDamage() + 1);
                            }
                        }

                    }
                }
            }else if(headRot.equals(Direction.WEST) || headRot.equals(Direction.EAST)){
                for(int z = -1; z< 2; z++){
                    for(int y = -1; y<2; y++){

                        if(world.getBlockState(new BlockPos(bx ,by + y, bz + z)).getMaterial() == Material.ROCK || world.getBlockState(new BlockPos(bx ,by + y, bz + z)).getMaterial() == Material.IRON || world.getBlockState(new BlockPos(bx ,by + y, bz + z)).getMaterial() == Material.ANVIL){
                            if(world.getBlockState(new BlockPos(bx,by + y, bz + z)).getBlock() != Blocks.BEDROCK){
                                world.destroyBlock(new BlockPos(bx ,by + y, bz + z),true);
                                stack.setDamage(stack.getDamage() + 1);
                            }

                        }

                    }
                }
            }





        }


        return false;
    }
}
