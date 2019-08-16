package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.ExperienceOrbRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.INBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

public class SuperPickaxe extends PickaxeItem {

    public SuperPickaxe(IItemTier material, float speed, Properties properties) {
        super(material, 1, speed, properties.addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        Material blockMaterial = world.getBlockState(pos).getMaterial();
        if(RegisterItems.superPickaxe.equals(stack.getItem())){
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            Direction headRot = entityLiving.getHorizontalFacing();
            ArrayList<INBT> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";
            String silktouchEnchantment = "";
            String fortuneEnchantment = "";

            enchantments.add(INBT.create((byte) 0));

            for(INBT enchantment : stack.getEnchantmentTagList()){
                enchantments.add(enchantment);
            }

            for(int i=0;i<enchantments.size(); i++){
                if(enchantments.get(i).toString().contains("minecraft:unbreaking")){
                    unbreakingEnchantment = enchantments.get(i).toString();
                }else if(enchantments.get(i).toString().contains("minecraft:silk_touch")){
                    silktouchEnchantment = enchantments.get(i).toString();
                }else if(enchantments.get(i).toString().contains("minecraft:fortune")){
                    fortuneEnchantment = enchantments.get(i).toString();
                }
            }

            if(world.getBlockState(pos).getMaterial() == Material.ROCK || world.getBlockState(pos).getMaterial() == Material.IRON || world.getBlockState(pos).getMaterial() == Material.ANVIL || world.getBlockState(pos).getMaterial() == Material.GLASS || world.getBlockState(pos).getMaterial() == Material.ICE || world.getBlockState(pos).getMaterial() == Material.PACKED_ICE){
                if(entityLiving.getLookVec().y <= -0.52f || entityLiving.getLookVec().y >= 0.52f){
                    for(int x = -1; x < 2; x++){
                        for(int z = -1; z < 2; z++){
                            if(stack.getDamage() >= stack.getMaxDamage() - 1){
                                stack.shrink(1);
                                break;
                            }

                            int randomNumber = random.nextInt(100) + 1;
                            BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);


                            if(world.getBlockState(newBlockPos).getMaterial() == Material.ROCK || world.getBlockState(newBlockPos).getMaterial() == Material.IRON || world.getBlockState(newBlockPos).getMaterial() == Material.ANVIL || world.getBlockState(newBlockPos).getMaterial() == Material.GLASS || world.getBlockState(newBlockPos).getMaterial() == Material.ICE || world.getBlockState(newBlockPos).getMaterial() == Material.PACKED_ICE){
                                if(world.getBlockState(newBlockPos).getBlock() != Blocks.BEDROCK && world.getBlockState(newBlockPos).getBlock() != Blocks.END_PORTAL_FRAME){
                                    Block blockToDestroy = world.getBlockState(newBlockPos).getBlock();
                                    if(silktouchEnchantment.length() != 0){
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        world.destroyBlock(newBlockPos, false);
                                        Block.spawnAsEntity(world,newBlockPos, new ItemStack(destroyedBlock));
                                    }else if(fortuneEnchantment.length() != 0){
                                        if(blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.IRON_ORE && blockToDestroy != Blocks.GOLD_ORE){
                                            if(fortuneEnchantment.contains("lvl:1")){
                                                if(randomNumber <= 33){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 1, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else{
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, true);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }
                                            }else if(fortuneEnchantment.contains("lvl:2")){
                                                if(randomNumber <= 25){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 2, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else if(randomNumber <= 50 && randomNumber > 25){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 2, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else{
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, true);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }
                                            }else if(fortuneEnchantment.contains("lvl:3")){
                                                if(randomNumber <= 20){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else if(randomNumber <= 40 && randomNumber > 20){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else if(randomNumber <= 60 && randomNumber > 40){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else{
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, true);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }
                                            }
                                        }
                                        else{
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            world.destroyBlock(newBlockPos, true);
                                            BlockState blockState = world.getBlockState(newBlockPos);
                                            int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                            if(amount != 0){
                                                world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                            }
                                        }
                                    }else{
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        world.destroyBlock(newBlockPos, true);
                                        BlockState blockState = world.getBlockState(newBlockPos);
                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                        if(amount != 0){
                                            world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                        }
                                    }
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

                else if(headRot.equals(Direction.NORTH) || headRot.equals(Direction.SOUTH)){
                    for(int x = -1; x< 2; x++){
                        for(int y = -1; y<2; y++){
                            if(stack.getDamage() >= stack.getMaxDamage() - 1){
                                stack.shrink(1);
                                break;
                            }


                            int randomNumber = random.nextInt(100) + 1;
                            BlockPos newBlockPos = new BlockPos(bx + x,by + y, bz);

                            if(world.getBlockState(newBlockPos).getMaterial() == Material.ROCK || world.getBlockState(newBlockPos).getMaterial() == Material.IRON || world.getBlockState(newBlockPos).getMaterial() == Material.ANVIL || world.getBlockState(newBlockPos).getMaterial() == Material.GLASS || world.getBlockState(newBlockPos).getMaterial() == Material.ICE || world.getBlockState(newBlockPos).getMaterial() == Material.PACKED_ICE){
                                if(world.getBlockState(newBlockPos).getBlock() != Blocks.BEDROCK && world.getBlockState(newBlockPos).getBlock() != Blocks.END_PORTAL_FRAME){
                                    Block blockToDestroy = world.getBlockState(newBlockPos).getBlock();
                                    if(silktouchEnchantment.length() != 0){
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        world.destroyBlock(newBlockPos, false);
                                        Block.spawnAsEntity(world,newBlockPos, new ItemStack(destroyedBlock));
                                    }else if(fortuneEnchantment.length() != 0){
                                        if(blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.IRON_ORE && blockToDestroy != Blocks.GOLD_ORE){
                                            if(fortuneEnchantment.contains("lvl:1")){
                                                if(randomNumber <= 33){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 1, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else{
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, true);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }
                                            }else if(fortuneEnchantment.contains("lvl:2")){
                                                if(randomNumber <= 25){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 2, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else if(randomNumber <= 50 && randomNumber > 25){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 2, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else{
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, true);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }
                                            }else if(fortuneEnchantment.contains("lvl:3")){
                                                if(randomNumber <= 20){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else if(randomNumber <= 40 && randomNumber > 20){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else if(randomNumber <= 60 && randomNumber > 40){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else{
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, true);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }
                                            }
                                        }
                                        else{
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            world.destroyBlock(newBlockPos, true);
                                            BlockState blockState = world.getBlockState(newBlockPos);
                                            int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                            if(amount != 0){
                                                world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                            }
                                        }
                                    }else{
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        world.destroyBlock(newBlockPos, true);
                                        BlockState blockState = world.getBlockState(newBlockPos);
                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                        if(amount != 0){
                                            world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                        }
                                    }
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
                }else if(headRot.equals(Direction.WEST) || headRot.equals(Direction.EAST)){
                    for(int z = -1; z< 2; z++){
                        for(int y = -1; y<2; y++){
                            if(stack.getDamage() >= stack.getMaxDamage() - 1){
                                stack.shrink(1);
                                break;
                            }



                            int randomNumber = random.nextInt(100) + 1;
                            BlockPos newBlockPos = new BlockPos(bx ,by + y, bz + z);

                            if(world.getBlockState(newBlockPos).getMaterial() == Material.ROCK || world.getBlockState(newBlockPos).getMaterial() == Material.IRON || world.getBlockState(newBlockPos).getMaterial() == Material.ANVIL || world.getBlockState(newBlockPos).getMaterial() == Material.GLASS || world.getBlockState(newBlockPos).getMaterial() == Material.ICE || world.getBlockState(newBlockPos).getMaterial() == Material.PACKED_ICE){
                                if(world.getBlockState(newBlockPos).getBlock() != Blocks.BEDROCK && world.getBlockState(newBlockPos).getBlock() != Blocks.END_PORTAL_FRAME){
                                    Block blockToDestroy = world.getBlockState(newBlockPos).getBlock();
                                    if(silktouchEnchantment.length() != 0){
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        world.destroyBlock(newBlockPos, false);
                                        Block.spawnAsEntity(world,newBlockPos, new ItemStack(destroyedBlock));
                                    }else if(fortuneEnchantment.length() != 0){
                                        if(blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.IRON_ORE && blockToDestroy != Blocks.GOLD_ORE){
                                            if(fortuneEnchantment.contains("lvl:1")){
                                                if(randomNumber <= 33){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 1, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else{
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, true);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }
                                            }else if(fortuneEnchantment.contains("lvl:2")){
                                                if(randomNumber <= 25){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 2, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else if(randomNumber <= 50 && randomNumber > 25){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 2, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else{
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, true);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }
                                            }else if(fortuneEnchantment.contains("lvl:3")){
                                                if(randomNumber <= 20){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else if(randomNumber <= 40 && randomNumber > 20){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else if(randomNumber <= 60 && randomNumber > 40){
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, false);
                                                    TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    Block.spawnDrops(state, world, newBlockPos, tileentity);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }else{
                                                    Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                    world.destroyBlock(newBlockPos, true);
                                                    BlockState blockState = world.getBlockState(newBlockPos);
                                                    int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                    if(amount != 0){
                                                        world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                                    }
                                                }
                                            }
                                        }
                                        else{
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            world.destroyBlock(newBlockPos, true);
                                            BlockState blockState = world.getBlockState(newBlockPos);
                                            int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                            if(amount != 0){
                                                world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                            }
                                        }
                                    }else{
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        world.destroyBlock(newBlockPos, true);
                                        BlockState blockState = world.getBlockState(newBlockPos);
                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                        if(amount != 0){
                                            world.addEntity(new ExperienceOrbEntity(world, (double)newBlockPos.getX() + 0.5D, (double)newBlockPos.getY() + 0.5D, (double)newBlockPos.getZ() + 0.5D, amount));
                                        }
                                    }
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

            }else{
                stack.setDamage(stack.getDamage() + 1);
            }

        }


        return false;
    }
}
