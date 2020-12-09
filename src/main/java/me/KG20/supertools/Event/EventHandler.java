package me.KG20.supertools.Event;

import me.KG20.supertools.Config.Config;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Random;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void SuperAxeDestroyedBlock(BlockEvent.BreakEvent event){
        World world = (World)event.getWorld();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);
        BlockState state = world.getBlockState(pos);

        Block startLog = state.getBlock();
        BlockPos currentPos = pos;
        ArrayList<BlockPos> brokenBlocks = new ArrayList<>();
        ArrayList<BlockPos> nextPos = new ArrayList<>();
        int blocksHarvested = 0;

        ArrayList<INBT> enchantments = new ArrayList<>();
        Random random = new Random();
        String unbreakingEnchantment = "";

        enchantments.add(IntNBT.valueOf(0));

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
                        if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                            world.destroyBlock(blockPos, true);
                        }else{
                            world.destroyBlock(blockPos, false);
                        }

                        blocksHarvested += 1;
                        if(!player.isCreative()){
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
                if(nextPos.size() > 0){
                    currentPos = nextPos.get(0);
                    nextPos.remove(currentPos);
                }else
                    break;
            }
        }
    }

    @SubscribeEvent
    public static void SuperPickaxeDestroyedBlock(BlockEvent.BreakEvent event) {
        World world = (World) event.getWorld();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);
        boolean firstUse = true;

        if (RegisterItems.superPickaxe.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            Direction headRot = player.getHorizontalFacing();
            ArrayList<INBT> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";
            String silktouchEnchantment = "";
            String fortuneEnchantment = "";

            enchantments.add(IntNBT.valueOf(0));

            for (INBT enchantment : stack.getEnchantmentTagList()) {
                enchantments.add(enchantment);
            }

            for (int i = 0; i < enchantments.size(); i++) {
                if (enchantments.get(i).toString().contains("minecraft:unbreaking")) {
                    unbreakingEnchantment = enchantments.get(i).toString();
                } else if (enchantments.get(i).toString().contains("minecraft:silk_touch")) {
                    silktouchEnchantment = enchantments.get(i).toString();
                } else if (enchantments.get(i).toString().contains("minecraft:fortune")) {
                    fortuneEnchantment = enchantments.get(i).toString();
                }
            }

            if (world.getBlockState(pos).getMaterial() == Material.ROCK || world.getBlockState(pos).getMaterial() == Material.IRON || world.getBlockState(pos).getMaterial() == Material.ANVIL || world.getBlockState(pos).getMaterial() == Material.GLASS || world.getBlockState(pos).getMaterial() == Material.ICE || world.getBlockState(pos).getMaterial() == Material.PACKED_ICE) {
                if (player.getLookVec().y <= -0.52f || player.getLookVec().y >= 0.52f) {
                    for (int x = -1; x < 2; x++) {
                        for (int z = -1; z < 2; z++) {
                            if (stack.getDamage() >= stack.getMaxDamage() - 1) {
                                stack.shrink(1);
                                break;
                            }

                            int randomNumber = random.nextInt(100) + 1;
                            BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);


                            if (world.getBlockState(newBlockPos).getMaterial() == Material.ROCK || world.getBlockState(newBlockPos).getMaterial() == Material.IRON || world.getBlockState(newBlockPos).getMaterial() == Material.ANVIL || world.getBlockState(newBlockPos).getMaterial() == Material.GLASS || world.getBlockState(newBlockPos).getMaterial() == Material.ICE || world.getBlockState(newBlockPos).getMaterial() == Material.PACKED_ICE) {
                                if (world.getBlockState(newBlockPos).getBlock() != Blocks.BEDROCK && world.getBlockState(newBlockPos).getBlock() != Blocks.END_PORTAL_FRAME) {
                                    Block blockToDestroy = world.getBlockState(newBlockPos).getBlock();
                                    if (silktouchEnchantment.length() != 0) {
                                        if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            world.destroyBlock(newBlockPos, false);
                                            Block.spawnAsEntity(world, newBlockPos, new ItemStack(destroyedBlock));
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                        }
                                    }else if (fortuneEnchantment.length() != 0) {
                                        if (blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.IRON_ORE && blockToDestroy != Blocks.GOLD_ORE) {
                                            if (fortuneEnchantment.contains("lvl:1")) {
                                                if (randomNumber <= 33) {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 1, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        world.destroyBlock(newBlockPos, true);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                }
                                            } else if (fortuneEnchantment.contains("lvl:2")) {
                                                if (randomNumber <= 25) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 50 && randomNumber > 25) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        world.destroyBlock(newBlockPos, true);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                }
                                            } else if (fortuneEnchantment.contains("lvl:3")) {
                                                if (randomNumber <= 20) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 40 && randomNumber > 20) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 60 && randomNumber > 40) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        world.destroyBlock(newBlockPos, true);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                }
                                            }
                                        } else {
                                            if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                BlockState blockState = world.getBlockState(newBlockPos);
                                                world.destroyBlock(newBlockPos, true);
                                                int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                if (amount != 0) {
                                                    world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                }
                                            }else{
                                                world.destroyBlock(newBlockPos, false);
                                            }
                                        }
                                    } else {
                                        if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            BlockState blockState = world.getBlockState(newBlockPos);
                                            world.destroyBlock(newBlockPos, true);
                                            int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                            if (amount != 0) {
                                                world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                            }
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                        }
                                    }
                                }
                                if (!player.isCreative()) {
                                    if (firstUse) {
                                        firstUse = false;
                                    } else {
                                        if (unbreakingEnchantment.length() != 0) {
                                            if (unbreakingEnchantment.contains("lvl:1")) {
                                                if (random.nextInt(100) + 1 <= 50) {
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:2")) {
                                                if (random.nextInt(100) + 1 <= 33) {
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:3")) {
                                                if (random.nextInt(100) + 1 <= 25) {
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }
                                        } else {
                                            stack.damageItem(1, player, PlayerEntity::tick);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else if (headRot.equals(Direction.NORTH) || headRot.equals(Direction.SOUTH)) {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            if (stack.getDamage() >= stack.getMaxDamage() - 1) {
                                stack.shrink(1);
                                break;
                            }


                            int randomNumber = random.nextInt(100) + 1;
                            BlockPos newBlockPos = new BlockPos(bx + x, by + y, bz);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.ROCK || world.getBlockState(newBlockPos).getMaterial() == Material.IRON || world.getBlockState(newBlockPos).getMaterial() == Material.ANVIL || world.getBlockState(newBlockPos).getMaterial() == Material.GLASS || world.getBlockState(newBlockPos).getMaterial() == Material.ICE || world.getBlockState(newBlockPos).getMaterial() == Material.PACKED_ICE) {
                                if (world.getBlockState(newBlockPos).getBlock() != Blocks.BEDROCK && world.getBlockState(newBlockPos).getBlock() != Blocks.END_PORTAL_FRAME) {
                                    Block blockToDestroy = world.getBlockState(newBlockPos).getBlock();
                                    if (silktouchEnchantment.length() != 0) {
                                        if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            world.destroyBlock(newBlockPos, false);
                                            Block.spawnAsEntity(world, newBlockPos, new ItemStack(destroyedBlock));
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                        }
                                    }else if (fortuneEnchantment.length() != 0) {
                                        if (blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.IRON_ORE && blockToDestroy != Blocks.GOLD_ORE) {
                                            if (fortuneEnchantment.contains("lvl:1")) {
                                                if (randomNumber <= 33) {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 1, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        world.destroyBlock(newBlockPos, true);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                }
                                            } else if (fortuneEnchantment.contains("lvl:2")) {
                                                if (randomNumber <= 25) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 50 && randomNumber > 25) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        world.destroyBlock(newBlockPos, true);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                }
                                            } else if (fortuneEnchantment.contains("lvl:3")) {
                                                if (randomNumber <= 20) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 40 && randomNumber > 20) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 60 && randomNumber > 40) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        world.destroyBlock(newBlockPos, true);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                }
                                            }
                                        } else {
                                            if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                BlockState blockState = world.getBlockState(newBlockPos);
                                                world.destroyBlock(newBlockPos, true);
                                                int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                if (amount != 0) {
                                                    world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                }
                                            }else{
                                                world.destroyBlock(newBlockPos, false);
                                            }
                                        }
                                    } else {
                                        if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            BlockState blockState = world.getBlockState(newBlockPos);
                                            world.destroyBlock(newBlockPos, true);
                                            int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                            if (amount != 0) {
                                                world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                            }
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                        }
                                    }
                                }
                                if (!player.isCreative()) {
                                    if (firstUse) {
                                        firstUse = false;
                                    } else {
                                        if (unbreakingEnchantment.length() != 0) {
                                            if (unbreakingEnchantment.contains("lvl:1")) {
                                                if (random.nextInt(100) + 1 <= 50) {
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:2")) {
                                                if (random.nextInt(100) + 1 <= 33) {
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:3")) {
                                                if (random.nextInt(100) + 1 <= 25) {
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }
                                        } else {
                                            stack.damageItem(1, player, PlayerEntity::tick);
                                        }
                                    }
                                }
                            }
                        }
                    }

                }else if (headRot.equals(Direction.WEST) || headRot.equals(Direction.EAST)) {
                    for (int z = -1; z < 2; z++) {
                        for (int y = -1; y < 2; y++) {
                            if (stack.getDamage() >= stack.getMaxDamage() - 1) {
                                stack.shrink(1);
                                break;
                            }

                            int randomNumber = random.nextInt(100) + 1;
                            BlockPos newBlockPos = new BlockPos(bx, by + y, bz + z);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.ROCK || world.getBlockState(newBlockPos).getMaterial() == Material.IRON || world.getBlockState(newBlockPos).getMaterial() == Material.ANVIL || world.getBlockState(newBlockPos).getMaterial() == Material.GLASS || world.getBlockState(newBlockPos).getMaterial() == Material.ICE || world.getBlockState(newBlockPos).getMaterial() == Material.PACKED_ICE) {
                                if (world.getBlockState(newBlockPos).getBlock() != Blocks.BEDROCK && world.getBlockState(newBlockPos).getBlock() != Blocks.END_PORTAL_FRAME) {
                                    Block blockToDestroy = world.getBlockState(newBlockPos).getBlock();
                                    if (silktouchEnchantment.length() != 0) {
                                        if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            world.destroyBlock(newBlockPos, false);
                                            Block.spawnAsEntity(world, newBlockPos, new ItemStack(destroyedBlock));
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                        }
                                    }else if (fortuneEnchantment.length() != 0) {
                                        if (blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.IRON_ORE && blockToDestroy != Blocks.GOLD_ORE) {
                                            if (fortuneEnchantment.contains("lvl:1")) {
                                                if (randomNumber <= 33) {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 1, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        world.destroyBlock(newBlockPos, true);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                }
                                            } else if (fortuneEnchantment.contains("lvl:2")) {
                                                if (randomNumber <= 25) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 50 && randomNumber > 25) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        world.destroyBlock(newBlockPos, true);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                }
                                            } else if (fortuneEnchantment.contains("lvl:3")) {
                                                if (randomNumber <= 20) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 40 && randomNumber > 20) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 60 && randomNumber > 40) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        TileEntity tileentity = blockState.hasTileEntity() ? world.getTileEntity(newBlockPos) : null;
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        Block.spawnDrops(blockState, world, newBlockPos, tileentity);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        world.destroyBlock(newBlockPos, true);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                        if (amount != 0) {
                                                            world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                }
                                            }
                                        } else {
                                            if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                BlockState blockState = world.getBlockState(newBlockPos);
                                                world.destroyBlock(newBlockPos, true);
                                                int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                                if (amount != 0) {
                                                    world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                }
                                            }else{
                                                world.destroyBlock(newBlockPos, false);
                                            }
                                        }
                                    } else {
                                        if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            BlockState blockState = world.getBlockState(newBlockPos);
                                            world.destroyBlock(newBlockPos, true);
                                            int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 0, 0);
                                            if (amount != 0) {
                                                world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                            }
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                        }
                                    }
                                }
                                if (!player.isCreative()) {
                                    if (firstUse) {
                                        firstUse = false;
                                    } else {
                                        if (unbreakingEnchantment.length() != 0) {
                                            if (unbreakingEnchantment.contains("lvl:1")) {
                                                if (random.nextInt(100) + 1 <= 50) {
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:2")) {
                                                if (random.nextInt(100) + 1 <= 33) {
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:3")) {
                                                if (random.nextInt(100) + 1 <= 25) {
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }
                                        } else {
                                            stack.damageItem(1, player, PlayerEntity::tick);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void SuperShovelDestroyedBlock(BlockEvent.BreakEvent event){
        World world = (World)event.getWorld();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);
        Direction headRot = player.getHorizontalFacing();
        boolean firstUse = true;

        if(RegisterItems.superShovel.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            ArrayList<INBT> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";
            String silktouchEnchantment = "";

            enchantments.add(IntNBT.valueOf(0));

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

            if(world.getBlockState(pos).getMaterial() == Material.EARTH || world.getBlockState(pos).getMaterial() == Material.SAND || world.getBlockState(pos).getMaterial() == Material.ORGANIC || world.getBlockState(pos).getMaterial() == Material.SNOW || world.getBlockState(pos).getMaterial() == Material.SNOW_BLOCK || world.getBlockState(pos).getMaterial() == Material.CLAY){
                if (player.getLookVec().y <= -0.50f || player.getLookVec().y >= 0.50f) {
                    for (int x = -1; x < 2; x++) {
                        for (int z = -1; z < 2; z++) {
                            if(stack.getDamage() >= stack.getMaxDamage() - 1){
                                stack.shrink(1);
                                break;
                            }
                            BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.EARTH || world.getBlockState(newBlockPos).getMaterial() == Material.SAND || world.getBlockState(newBlockPos).getMaterial() == Material.ORGANIC || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW_BLOCK || world.getBlockState(newBlockPos).getMaterial() == Material.CLAY) {
                                if(silktouchEnchantment.length() != 0) {
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        world.destroyBlock(newBlockPos, false);
                                        Block.spawnAsEntity(world, newBlockPos, new ItemStack(destroyedBlock));
                                    }else{
                                        world.destroyBlock(newBlockPos, false);
                                    }
                                }else{
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        world.destroyBlock(newBlockPos, true);
                                    }else{
                                        world.destroyBlock(newBlockPos, false);
                                    }

                                }
                                if(!player.isCreative()){
                                    if(firstUse){
                                        firstUse = false;
                                    }else{
                                        if(unbreakingEnchantment.length() != 0){
                                            if(unbreakingEnchantment.contains("lvl:1")){
                                                if(random.nextInt(100) + 1 <= 50){
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:2")){
                                                if(random.nextInt(100) + 1 <= 33){
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:3")){
                                                if(random.nextInt(100) + 1 <= 25){
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }
                                        }else{
                                            stack.damageItem(1, player, PlayerEntity::tick);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (headRot.equals(Direction.NORTH) || headRot.equals(Direction.SOUTH)) {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            if(stack.getDamage() >= stack.getMaxDamage() - 1){
                                stack.shrink(1);
                                break;
                            }
                            BlockPos newBlockPos = new BlockPos(bx + x, by + y, bz);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.EARTH || world.getBlockState(newBlockPos).getMaterial() == Material.SAND || world.getBlockState(newBlockPos).getMaterial() == Material.ORGANIC || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW_BLOCK || world.getBlockState(newBlockPos).getMaterial() == Material.CLAY) {
                                if(silktouchEnchantment.length() != 0) {
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        world.destroyBlock(newBlockPos, false);
                                        Block.spawnAsEntity(world, newBlockPos, new ItemStack(destroyedBlock));
                                    }else{
                                        world.destroyBlock(newBlockPos, false);
                                    }
                                }else{
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        world.destroyBlock(newBlockPos, true);
                                    }else{
                                        world.destroyBlock(newBlockPos, false);
                                    }

                                }
                                if(!player.isCreative()){
                                    if(firstUse){
                                        firstUse = false;
                                    }else{
                                        if(unbreakingEnchantment.length() != 0){
                                            if(unbreakingEnchantment.contains("lvl:1")){
                                                if(random.nextInt(100) + 1 <= 50){
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:2")){
                                                if(random.nextInt(100) + 1 <= 33){
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:3")){
                                                if(random.nextInt(100) + 1 <= 25){
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }
                                        }else{
                                            stack.damageItem(1, player, PlayerEntity::tick);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (headRot.equals(Direction.WEST) || headRot.equals(Direction.EAST)) {
                    for (int z = -1; z < 2; z++) {
                        for (int y = -1; y < 2; y++) {
                            if(stack.getDamage() >= stack.getMaxDamage() - 1){
                                stack.shrink(1);
                                break;
                            }
                            BlockPos newBlockPos = new BlockPos(bx, by + y, bz + z);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.EARTH || world.getBlockState(newBlockPos).getMaterial() == Material.SAND || world.getBlockState(newBlockPos).getMaterial() == Material.ORGANIC || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW_BLOCK || world.getBlockState(newBlockPos).getMaterial() == Material.CLAY) {
                                if(silktouchEnchantment.length() != 0) {
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        world.destroyBlock(newBlockPos, false);
                                        Block.spawnAsEntity(world, newBlockPos, new ItemStack(destroyedBlock));
                                    }else{
                                        world.destroyBlock(newBlockPos, false);
                                    }
                                }else{
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        world.destroyBlock(newBlockPos, true);
                                    }else{
                                        world.destroyBlock(newBlockPos, false);
                                    }

                                }
                                if(!player.isCreative()){
                                    if(firstUse){
                                        firstUse = false;
                                    }else{
                                        if(unbreakingEnchantment.length() != 0){
                                            if(unbreakingEnchantment.contains("lvl:1")){
                                                if(random.nextInt(100) + 1 <= 50){
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:2")){
                                                if(random.nextInt(100) + 1 <= 33){
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:3")){
                                                if(random.nextInt(100) + 1 <= 25){
                                                    stack.damageItem(1, player, PlayerEntity::tick);
                                                }
                                            }
                                        }else{
                                            stack.damageItem(1, player, PlayerEntity::tick);
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void SuperShovelRightClickBlock(PlayerInteractEvent.RightClickBlock event){
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);

        if (RegisterItems.superShovel.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            ArrayList<INBT> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";

            enchantments.add(IntNBT.valueOf(0));

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
                        if(stack.getDamage() >= stack.getMaxDamage() - 1){
                            stack.shrink(1);
                            break;
                        }

                        if (world.getBlockState(new BlockPos(bx + x, by + 1, bz + z)).getBlock() == Blocks.AIR) {
                            if (world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.GRASS_BLOCK) {
                                world.setBlockState(new BlockPos(bx + x, by, bz + z), Blocks.GRASS_PATH.getDefaultState());
                                if (!player.isCreative()) {
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
    }

    @SubscribeEvent
    public static void SuperHoeRightClickBlock(PlayerInteractEvent.RightClickBlock event){
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);

        if (RegisterItems.superHoe.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            ArrayList<INBT> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";

            enchantments.add(IntNBT.valueOf(0));

            for(INBT enchantment : stack.getEnchantmentTagList()){
                enchantments.add(enchantment);
            }

            for(int i=0;i<enchantments.size(); i++){
                if(enchantments.get(i).toString().contains("minecraft:unbreaking")){
                    unbreakingEnchantment = enchantments.get(i).toString();
                }
            }



            if(world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(pos).getBlock() == Blocks.GRASS_PATH){
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        if(stack.getDamage() >= stack.getMaxDamage()){
                            stack.shrink(1);
                            break;
                        }
                        if(world.getBlockState(new BlockPos(bx + x,by + 1,bz + z)).getBlock() == Blocks.AIR){
                            if (world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.DIRT || world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.GRASS_PATH ) {
                                world.setBlockState(new BlockPos(bx + x, by, bz + z), Blocks.FARMLAND.getDefaultState());
                                if(!player.isCreative()){
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
                                if(!player.isCreative()){
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
    }

    @SubscribeEvent
    public static void SuperSwordHitEntity(LivingHurtEvent event){
        if(event.getSource().getTrueSource() instanceof PlayerEntity){
            LivingEntity target = event.getEntityLiving();
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);

            if(RegisterItems.superSword.equals(stack.getItem())){
                target.addPotionEffect(new EffectInstance(Effect.get(18), 60, 1));
                target.addPotionEffect(new EffectInstance(Effect.get(19), 60, 1));
                target.addPotionEffect(new EffectInstance(Effect.get(24), 60, 1));
            }
        }
    }

    @SubscribeEvent
    public static void ItemCupHitEntity(LivingHurtEvent event){
        if(event.getSource().getTrueSource() instanceof PlayerEntity){
            LivingEntity target = event.getEntityLiving();
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);

            if(RegisterItems.itemCup.equals(stack.getItem())){
                if(target instanceof PlayerEntity){
                    PlayerEntity playerTarget = (PlayerEntity)event.getEntityLiving();
                    if(!playerTarget.getActivePotionEffects().toString().contains("effect.minecraft.fire_resistance")){
                        if(!playerTarget.isCreative()){
                            playerTarget.setFire(3);
                        }
                    }
                }else{
                    target.setFire(3);
                }
            }
        }
    }

    @SubscribeEvent
    public static void SpecialCupHitEntity(LivingHurtEvent event){
        if(event.getSource().getTrueSource() instanceof PlayerEntity){
            LivingEntity target = event.getEntityLiving();
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);

            if(RegisterItems.specialCup.equals(stack.getItem())){
                target.addPotionEffect(new EffectInstance(Effect.get(20), 100, 5));
                target.addPotionEffect(new EffectInstance(Effect.get(24), 100, 1));
            }
        }


    }


    private static ArrayList<BlockPos> getWoodNeighbours(World world, BlockPos blockPos, Block block, ItemStack stack) {
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
