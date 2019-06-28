package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Hoe extends HoeItem {

    public Hoe(IItemTier material, float speed) {
        super(material, speed, new Properties().group(CreativeTabs.tools));
    }

    public Hoe(IItemTier material, float speed, Properties properties) {
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


            if(world.getBlockState(pos).getBlock() != Blocks.FARMLAND){
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        if(world.getBlockState(new BlockPos(bx + x,by + 1,bz + z)).getBlock() == Blocks.AIR){
                            if (world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.DIRT || world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.GRASS_BLOCK) {
                                world.setBlockState(new BlockPos(bx + x, by, bz + z), Blocks.FARMLAND.getDefaultState());
                                if(!context.getPlayer().isCreative()){
                                    stack.setDamage(stack.getDamage() + 1);
                                }

                            }else if(world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.COARSE_DIRT){
                                world.setBlockState(new BlockPos(bx + x, by, bz + z), Blocks.DIRT.getDefaultState());
                                if(!context.getPlayer().isCreative()){
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
