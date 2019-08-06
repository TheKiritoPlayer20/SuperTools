package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.nbt.INBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.Random;

public class SuperShovel extends ShovelItem {

    public SuperShovel(IItemTier material, float speed) {
        super(material, 1.5F, speed, new Properties().group(CreativeTabs.tools).addToolType(ToolType.SHOVEL, material.getHarvestLevel()));
    }

    public SuperShovel(IItemTier material, float speed, Properties properties) {
        super(material, 1.5F, speed, properties.addToolType(ToolType.SHOVEL, material.getHarvestLevel()));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if(RegisterItems.superShovel.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            Direction headRot = entityLiving.getHorizontalFacing();
            World world = entityLiving.getEntityWorld();

            ArrayList<INBT> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";
            String silktouchEnchantment = "";

            enchantments.add(INBT.create((byte) 0));

            for (INBT enchantment : stack.getEnchantmentTagList()) {
                enchantments.add(enchantment);
            }

            for (int i = 0; i < enchantments.size(); i++) {
                if (enchantments.get(i).toString().contains("minecraft:unbreaking")) {
                    unbreakingEnchantment = enchantments.get(i).toString();
                }else if(enchantments.get(i).toString().contains("minecraft:silk_touch")) {
                    silktouchEnchantment = enchantments.get(i).toString();
                }
            }

            if(world.getBlockState(pos).getMaterial() == Material.EARTH || world.getBlockState(pos).getMaterial() == Material.SAND || world.getBlockState(pos).getMaterial() == Material.ORGANIC || world.getBlockState(pos).getMaterial() == Material.SNOW || world.getBlockState(pos).getMaterial() == Material.SNOW_BLOCK){
                if (entityLiving.getLookVec().y <= -0.50f || entityLiving.getLookVec().y >= 0.50f) {
                    for (int x = -1; x < 2; x++) {
                        for (int z = -1; z < 2; z++) {

                            BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.EARTH || world.getBlockState(newBlockPos).getMaterial() == Material.SAND || world.getBlockState(newBlockPos).getMaterial() == Material.ORGANIC || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW_BLOCK) {
                                if(silktouchEnchantment.length() != 0) {
                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                    world.destroyBlock(newBlockPos, false);
                                    Block.spawnAsEntity(world, newBlockPos, new ItemStack(destroyedBlock));
                                }else{
                                    world.destroyBlock(newBlockPos, true);
                                }
                                if (unbreakingEnchantment.length() != 0) {
                                    if (unbreakingEnchantment.contains("lvl:1")) {
                                        if (random.nextInt(100) + 1 <= 50) {
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    } else if (unbreakingEnchantment.contains("lvl:2")) {
                                        if (random.nextInt(100) + 1 <= 33) {
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    } else if (unbreakingEnchantment.contains("lvl:3")) {
                                        if (random.nextInt(100) + 1 <= 25) {
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    }
                                } else {
                                    stack.setDamage(stack.getDamage() + 1);
                                }
                            }

                        }
                    }
                } else if (headRot.equals(Direction.NORTH) || headRot.equals(Direction.SOUTH)) {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {

                            BlockPos newBlockPos = new BlockPos(bx + x, by + y, bz);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.EARTH || world.getBlockState(newBlockPos).getMaterial() == Material.SAND || world.getBlockState(newBlockPos).getMaterial() == Material.ORGANIC || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW_BLOCK) {
                                if(silktouchEnchantment.length() != 0) {
                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                    world.destroyBlock(newBlockPos, false);
                                    Block.spawnAsEntity(world, newBlockPos, new ItemStack(destroyedBlock));
                                }else{
                                    world.destroyBlock(newBlockPos, true);
                                }
                                if (unbreakingEnchantment.length() != 0) {
                                    if (unbreakingEnchantment.contains("lvl:1")) {
                                        if (random.nextInt(100) + 1 <= 50) {
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    } else if (unbreakingEnchantment.contains("lvl:2")) {
                                        if (random.nextInt(100) + 1 <= 33) {
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    } else if (unbreakingEnchantment.contains("lvl:3")) {
                                        if (random.nextInt(100) + 1 <= 25) {
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    }
                                } else {
                                    stack.setDamage(stack.getDamage() + 1);
                                }
                            }

                        }
                    }
                } else if (headRot.equals(Direction.WEST) || headRot.equals(Direction.EAST)) {
                    for (int z = -1; z < 2; z++) {
                        for (int y = -1; y < 2; y++) {

                            BlockPos newBlockPos = new BlockPos(bx, by + y, bz + z);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.EARTH || world.getBlockState(newBlockPos).getMaterial() == Material.SAND || world.getBlockState(newBlockPos).getMaterial() == Material.ORGANIC || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW_BLOCK) {
                                if(silktouchEnchantment.length() != 0) {
                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                    world.destroyBlock(newBlockPos, false);
                                    Block.spawnAsEntity(world, newBlockPos, new ItemStack(destroyedBlock));
                                }else{
                                    world.destroyBlock(newBlockPos, true);
                                }
                                if (unbreakingEnchantment.length() != 0) {
                                    if (unbreakingEnchantment.contains("lvl:1")) {
                                        if (random.nextInt(100) + 1 <= 50) {
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    } else if (unbreakingEnchantment.contains("lvl:2")) {
                                        if (random.nextInt(100) + 1 <= 33) {
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    } else if (unbreakingEnchantment.contains("lvl:3")) {
                                        if (random.nextInt(100) + 1 <= 25) {
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    }
                                } else {
                                    stack.setDamage(stack.getDamage() + 1);
                                }
                            }

                        }
                    }
                }

            }else{
                stack.setDamage(stack.getDamage() + 1);
            }



        }

        return false;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        ItemStack stack = context.getItem();
        World world = context.getWorld();
        BlockPos pos = context.getPos();

        if (RegisterItems.superShovel.equals(stack.getItem())) {
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



            if(world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK) {
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        if (world.getBlockState(new BlockPos(bx + x, by + 1, bz + z)).getBlock() == Blocks.AIR) {
                            if (world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.GRASS_BLOCK) {
                                world.setBlockState(new BlockPos(bx + x, by, bz + z), Blocks.GRASS_PATH.getDefaultState());
                                if (!context.getPlayer().isCreative()) {
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
