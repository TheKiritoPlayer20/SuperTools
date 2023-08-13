package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class Sickle extends Item {


    public Sickle(Properties properties) {
        super(properties);
    }


    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if(stack.getItem() instanceof Sickle && !RegisterItems.superSickle.equals(stack.getItem())){
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            if (world.getBlockState(pos).getBlock() instanceof IPlantable){
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {

                        BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                        if (world.getBlockState(newBlockPos).getBlock() instanceof IPlantable) {
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

            if (world.getBlockState(pos).getBlock() instanceof IPlantable){
                for (int x = -4; x < 5; x++) {
                    for (int z = -4; z < 5; z++) {

                        BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                        if (world.getBlockState(pos).getBlock() instanceof IPlantable) {
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
    public InteractionResult useOn(UseOnContext context) {
        ItemStack stack = context.getItemInHand();
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (RegisterItems.superSickle.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            for (int x = -4; x < 5; x++) {
                for (int z = -4; z < 5; z++) {
                    BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);
                    if (world.getBlockState(pos).getBlock() instanceof IPlantable) {
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
