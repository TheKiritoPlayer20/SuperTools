package me.KG20.supertools.Event;

import me.KG20.supertools.Config.Config;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
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
        Level world = event.getPlayer().level;
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getMainHandItem();
        BlockState state = world.getBlockState(pos);

        Block startLog = state.getBlock();
        BlockPos currentPos = pos;
        ArrayList<BlockPos> brokenBlocks = new ArrayList<>();
        ArrayList<BlockPos> nextPos = new ArrayList<>();
        int blocksHarvested = 0;
        Random random = new Random();


        ArrayList<Tag> enchantments = new ArrayList<>();
        String unbreakingEnchantment = "";

        //enchantments.add(Tag.);

        for(Tag enchantment : stack.getEnchantmentTags()){
            enchantments.add(enchantment);
        }
        if(enchantments.size() != 0){
            for(int i=0;i<enchantments.size(); i++){
                if(enchantments.get(i).toString().contains("minecraft:unbreaking")){
                    unbreakingEnchantment = enchantments.get(i).toString();
                }
            }
        }

        if(RegisterItems.superAxe.equals(stack.getItem()) && startLog.getTags().toString().contains("logs") || RegisterItems.superAxe.equals(stack.getItem()) && startLog.getTags().toString().contains("log")){
            brokenBlocks.add(pos);
            while(stack.getDamageValue() != stack.getMaxDamage() && blocksHarvested <= Config.max_wood_logs.get()){
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
                                        stack.setDamageValue(stack.getDamageValue() + 1);
                                    }
                                }else if(unbreakingEnchantment.contains("lvl:2")){
                                    if(random.nextInt(100) + 1 <= 33){
                                        stack.setDamageValue(stack.getDamageValue() + 1);
                                    }
                                }else if(unbreakingEnchantment.contains("lvl:3")){
                                    if(random.nextInt(100) + 1 <= 25){
                                        stack.setDamageValue(stack.getDamageValue() + 1);
                                    }
                                }
                            }else{
                                stack.setDamageValue(stack.getDamageValue() + 1);
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
        Level world = event.getPlayer().level;
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getMainHandItem();
        boolean firstUse = true;

        if (RegisterItems.superPickaxe.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            //Direction headRot = player.getHorizontalFacing();
            Direction headRot = player.getMotionDirection();
            ArrayList<Tag> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";
            String silktouchEnchantment = "";
            String fortuneEnchantment = "";


            for (Tag enchantment : stack.getEnchantmentTags()) {
                enchantments.add(enchantment);
            }
            if(enchantments.size() != 0){
                for (int i = 0; i < enchantments.size(); i++) {
                    if (enchantments.get(i).toString().contains("minecraft:unbreaking")) {
                        unbreakingEnchantment = enchantments.get(i).toString();
                    } else if (enchantments.get(i).toString().contains("minecraft:silk_touch")) {
                        silktouchEnchantment = enchantments.get(i).toString();
                    } else if (enchantments.get(i).toString().contains("minecraft:fortune")) {
                        fortuneEnchantment = enchantments.get(i).toString();
                    }
                }
            }

            if (world.getBlockState(pos).getMaterial() == Material.STONE || world.getBlockState(pos).getMaterial() == Material.METAL || world.getBlockState(pos).getMaterial() == Material.HEAVY_METAL || world.getBlockState(pos).getMaterial() == Material.GLASS || world.getBlockState(pos).getMaterial() == Material.ICE || world.getBlockState(pos).getMaterial() == Material.ICE_SOLID) {
                if (player.getLookAngle().y <= -0.52f || player.getLookAngle().y >= 0.52f) {
                    for (int x = -1; x < 2; x++) {
                        for (int z = -1; z < 2; z++) {
                            if (stack.getDamageValue() >= stack.getMaxDamage() - 1) {
                                stack.shrink(1);
                                break;
                            }

                            int randomNumber = random.nextInt(100) + 1;
                            BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);


                            if (world.getBlockState(newBlockPos).getMaterial() == Material.STONE || world.getBlockState(newBlockPos).getMaterial() == Material.METAL || world.getBlockState(newBlockPos).getMaterial() == Material.HEAVY_METAL || world.getBlockState(newBlockPos).getMaterial() == Material.GLASS || world.getBlockState(newBlockPos).getMaterial() == Material.ICE || world.getBlockState(newBlockPos).getMaterial() == Material.ICE_SOLID) {
                                if (world.getBlockState(newBlockPos).getBlock() != Blocks.BEDROCK && world.getBlockState(newBlockPos).getBlock() != Blocks.END_PORTAL_FRAME) {
                                    Block blockToDestroy = world.getBlockState(newBlockPos).getBlock();
                                    if (silktouchEnchantment.length() != 0) {
                                        if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            world.destroyBlock(newBlockPos, false);
                                            Block.popResource(world, newBlockPos, new ItemStack(destroyedBlock.asItem()));
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                        }
                                    }else if (fortuneEnchantment.length() != 0) {
                                        //if (blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.IRON_ORE && blockToDestroy != Blocks.GOLD_ORE) {
                                        if (blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.ANCIENT_DEBRIS) {
                                            if (fortuneEnchantment.contains("lvl:1")) {
                                                if (randomNumber <= 33) {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(world.getBlockState(newBlockPos), world, newBlockPos);
                                                        Block.dropResources(world.getBlockState(newBlockPos), world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 1, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);

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
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 50 && randomNumber > 25) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 40 && randomNumber > 20) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 60 && randomNumber > 40) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                    //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                    ServerLevel sWorld = (ServerLevel)world;
                                                    destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                ServerLevel sWorld = (ServerLevel)world;
                                                destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:2")) {
                                                if (random.nextInt(100) + 1 <= 33) {
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:3")) {
                                                if (random.nextInt(100) + 1 <= 25) {
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }
                                        } else {
                                            stack.setDamageValue(stack.getDamageValue() + 1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else if (headRot.equals(Direction.NORTH) || headRot.equals(Direction.SOUTH)) {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            if (stack.getDamageValue() >= stack.getMaxDamage() - 1) {
                                stack.shrink(1);
                                break;
                            }


                            int randomNumber = random.nextInt(100) + 1;
                            BlockPos newBlockPos = new BlockPos(bx + x, by + y, bz);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.STONE || world.getBlockState(newBlockPos).getMaterial() == Material.METAL || world.getBlockState(newBlockPos).getMaterial() == Material.HEAVY_METAL || world.getBlockState(newBlockPos).getMaterial() == Material.GLASS || world.getBlockState(newBlockPos).getMaterial() == Material.ICE || world.getBlockState(newBlockPos).getMaterial() == Material.ICE_SOLID) {
                                if (world.getBlockState(newBlockPos).getBlock() != Blocks.BEDROCK && world.getBlockState(newBlockPos).getBlock() != Blocks.END_PORTAL_FRAME) {
                                    Block blockToDestroy = world.getBlockState(newBlockPos).getBlock();
                                    if (silktouchEnchantment.length() != 0) {
                                        if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            world.destroyBlock(newBlockPos, false);
                                            Block.popResource(world, newBlockPos, new ItemStack(destroyedBlock.asItem()));
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                        }
                                    }else if (fortuneEnchantment.length() != 0) {
                                        //if (blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.IRON_ORE && blockToDestroy != Blocks.GOLD_ORE) {
                                        if (blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.ANCIENT_DEBRIS) {
                                            if (fortuneEnchantment.contains("lvl:1")) {
                                                if (randomNumber <= 33) {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(world.getBlockState(newBlockPos), world, newBlockPos);
                                                        Block.dropResources(world.getBlockState(newBlockPos), world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 1, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);

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
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 50 && randomNumber > 25) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 40 && randomNumber > 20) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 60 && randomNumber > 40) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                    //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                    ServerLevel sWorld = (ServerLevel)world;
                                                    destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                ServerLevel sWorld = (ServerLevel)world;
                                                destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:2")) {
                                                if (random.nextInt(100) + 1 <= 33) {
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:3")) {
                                                if (random.nextInt(100) + 1 <= 25) {
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }
                                        } else {
                                            stack.setDamageValue(stack.getDamageValue() + 1);
                                        }
                                    }
                                }
                            }
                        }
                    }

                }else if (headRot.equals(Direction.WEST) || headRot.equals(Direction.EAST)) {
                    for (int z = -1; z < 2; z++) {
                        for (int y = -1; y < 2; y++) {
                            if (stack.getDamageValue() >= stack.getMaxDamage() - 1) {
                                stack.shrink(1);
                                break;
                            }

                            int randomNumber = random.nextInt(100) + 1;
                            BlockPos newBlockPos = new BlockPos(bx, by + y, bz + z);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.STONE || world.getBlockState(newBlockPos).getMaterial() == Material.METAL || world.getBlockState(newBlockPos).getMaterial() == Material.HEAVY_METAL || world.getBlockState(newBlockPos).getMaterial() == Material.GLASS || world.getBlockState(newBlockPos).getMaterial() == Material.ICE || world.getBlockState(newBlockPos).getMaterial() == Material.ICE_SOLID) {
                                if (world.getBlockState(newBlockPos).getBlock() != Blocks.BEDROCK && world.getBlockState(newBlockPos).getBlock() != Blocks.END_PORTAL_FRAME) {
                                    Block blockToDestroy = world.getBlockState(newBlockPos).getBlock();
                                    if (silktouchEnchantment.length() != 0) {
                                        if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                            Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                            world.destroyBlock(newBlockPos, false);
                                            Block.popResource(world, newBlockPos, new ItemStack(destroyedBlock.asItem()));
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                        }
                                    }else if (fortuneEnchantment.length() != 0) {
                                        //if (blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.IRON_ORE && blockToDestroy != Blocks.GOLD_ORE) {
                                        if (blockToDestroy.getTags().toString().contains("forge:ores/") && blockToDestroy != Blocks.ANCIENT_DEBRIS) {
                                            if (fortuneEnchantment.contains("lvl:1")) {
                                                if (randomNumber <= 33) {
                                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(world.getBlockState(newBlockPos), world, newBlockPos);
                                                        Block.dropResources(world.getBlockState(newBlockPos), world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 1, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);

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
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 50 && randomNumber > 25) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 40 && randomNumber > 20) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
                                                        }
                                                    }else{
                                                        world.destroyBlock(newBlockPos, false);
                                                    }
                                                } else if (randomNumber <= 60 && randomNumber > 40) {
                                                    if(Config.enable_BlockDropsInCreative.get() ||!player.isCreative()){
                                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                                        BlockState blockState = world.getBlockState(newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        Block.dropResources(blockState, world, newBlockPos);
                                                        world.destroyBlock(newBlockPos, false);
                                                        int amount = destroyedBlock.getExpDrop(blockState, world, newBlockPos, 3, 0);
                                                        if (amount != 0) {
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                            //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                            ServerLevel sWorld = (ServerLevel)world;
                                                            destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                    //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                    ServerLevel sWorld = (ServerLevel)world;
                                                    destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                //world.addEntity(new ExperienceOrbEntity(world, (double) newBlockPos.getX() + 0.5D, (double) newBlockPos.getY() + 0.5D, (double) newBlockPos.getZ() + 0.5D, amount));
                                                ServerLevel sWorld = (ServerLevel)world;
                                                destroyedBlock.popExperience(sWorld, newBlockPos, amount);
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
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:2")) {
                                                if (random.nextInt(100) + 1 <= 33) {
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            } else if (unbreakingEnchantment.contains("lvl:3")) {
                                                if (random.nextInt(100) + 1 <= 25) {
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }
                                        } else {
                                            stack.setDamageValue(stack.getDamageValue() + 1);
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
        Level world = (Level)event.getWorld();
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getMainHandItem();
        Direction headRot = player.getMotionDirection();
        boolean firstUse = true;

        if(RegisterItems.superShovel.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            ArrayList<Tag> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";
            String silktouchEnchantment = "";


            //enchantments.add(IntNBT.valueOf(0));

            for (Tag enchantment : stack.getEnchantmentTags()) {
                enchantments.add(enchantment);
            }
            if(enchantments.size() != 0){
                for (int i = 0; i < enchantments.size(); i++) {
                    if (enchantments.get(i).toString().contains("minecraft:unbreaking")) {
                        unbreakingEnchantment = enchantments.get(i).toString();
                    } else if (enchantments.get(i).toString().contains("minecraft:silk_touch")) {
                        silktouchEnchantment = enchantments.get(i).toString();
                    }
                }
            }

            if(world.getBlockState(pos).getMaterial() == Material.DIRT || world.getBlockState(pos).getMaterial() == Material.SAND || world.getBlockState(pos).getMaterial() == Material.PLANT || world.getBlockState(pos).getMaterial() == Material.GRASS || world.getBlockState(pos).getMaterial() == Material.SNOW || world.getBlockState(pos).getMaterial() == Material.CLAY || world.getBlockState(pos).getMaterial() == Material.TOP_SNOW){
                if (player.getLookAngle().y <= -0.50f || player.getLookAngle().y >= 0.50f) {
                    for (int x = -1; x < 2; x++) {
                        for (int z = -1; z < 2; z++) {
                            if(stack.getDamageValue() >= stack.getMaxDamage() - 1){
                                stack.shrink(1);
                                break;
                            }
                            BlockPos newBlockPos = new BlockPos(bx + x, by, bz + z);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.DIRT || world.getBlockState(newBlockPos).getMaterial() == Material.SAND || world.getBlockState(newBlockPos).getMaterial() == Material.PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.GRASS || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW || world.getBlockState(newBlockPos).getMaterial() == Material.CLAY || world.getBlockState(newBlockPos).getMaterial() == Material.TOP_SNOW) {
                                if (silktouchEnchantment.length() != 0) {
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        if(destroyedBlock == Blocks.DIRT_PATH){
                                            world.destroyBlock(newBlockPos, false);
                                            Block.popResource(world, newBlockPos, new ItemStack(Blocks.DIRT));
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                            Block.popResource(world, newBlockPos, new ItemStack(destroyedBlock.asItem()));
                                        }
                                    }else{
                                        world.destroyBlock(newBlockPos, false);
                                    }
                                }else{
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        if(world.getBlockState(newBlockPos).getBlock() == Blocks.SNOW){
                                            Block.popResource(world, newBlockPos, new ItemStack(Items.SNOWBALL));
                                        }
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
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:2")){
                                                if(random.nextInt(100) + 1 <= 33){
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:3")){
                                                if(random.nextInt(100) + 1 <= 25){
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }
                                        }else{
                                            stack.setDamageValue(stack.getDamageValue() + 1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (headRot.equals(Direction.NORTH) || headRot.equals(Direction.SOUTH)) {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            if(stack.getDamageValue() >= stack.getMaxDamage() - 1){
                                stack.shrink(1);
                                break;
                            }
                            BlockPos newBlockPos = new BlockPos(bx + x, by + y, bz);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.DIRT || world.getBlockState(newBlockPos).getMaterial() == Material.SAND || world.getBlockState(newBlockPos).getMaterial() == Material.PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.GRASS || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW || world.getBlockState(newBlockPos).getMaterial() == Material.CLAY || world.getBlockState(newBlockPos).getMaterial() == Material.TOP_SNOW) {
                                if (silktouchEnchantment.length() != 0) {
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        if(destroyedBlock == Blocks.DIRT_PATH){
                                            world.destroyBlock(newBlockPos, false);
                                            Block.popResource(world, newBlockPos, new ItemStack(Blocks.DIRT));
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                            Block.popResource(world, newBlockPos, new ItemStack(destroyedBlock.asItem()));
                                        }
                                    }else{
                                        world.destroyBlock(newBlockPos, false);
                                    }
                                }else{
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        if(world.getBlockState(newBlockPos).getBlock() == Blocks.SNOW){
                                            Block.popResource(world, newBlockPos, new ItemStack(Items.SNOWBALL));
                                        }
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
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:2")){
                                                if(random.nextInt(100) + 1 <= 33){
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:3")){
                                                if(random.nextInt(100) + 1 <= 25){
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }
                                        }else{
                                            stack.setDamageValue(stack.getDamageValue() + 1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (headRot.equals(Direction.WEST) || headRot.equals(Direction.EAST)) {
                    for (int z = -1; z < 2; z++) {
                        for (int y = -1; y < 2; y++) {
                            if(stack.getDamageValue() >= stack.getMaxDamage() - 1){
                                stack.shrink(1);
                                break;
                            }
                            BlockPos newBlockPos = new BlockPos(bx, by + y, bz + z);

                            if (world.getBlockState(newBlockPos).getMaterial() == Material.DIRT || world.getBlockState(newBlockPos).getMaterial() == Material.SAND || world.getBlockState(newBlockPos).getMaterial() == Material.PLANT || world.getBlockState(newBlockPos).getMaterial() == Material.GRASS || world.getBlockState(newBlockPos).getMaterial() == Material.SNOW || world.getBlockState(newBlockPos).getMaterial() == Material.CLAY || world.getBlockState(newBlockPos).getMaterial() == Material.TOP_SNOW) {
                                if (silktouchEnchantment.length() != 0) {
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        Block destroyedBlock = world.getBlockState(newBlockPos).getBlock();
                                        if(destroyedBlock == Blocks.DIRT_PATH){
                                            world.destroyBlock(newBlockPos, false);
                                            Block.popResource(world, newBlockPos, new ItemStack(Blocks.DIRT));
                                        }else{
                                            world.destroyBlock(newBlockPos, false);
                                            Block.popResource(world, newBlockPos, new ItemStack(destroyedBlock.asItem()));
                                        }
                                    }else{
                                        world.destroyBlock(newBlockPos, false);
                                    }
                                }else{
                                    if(Config.enable_BlockDropsInCreative.get() || !player.isCreative()){
                                        if(world.getBlockState(newBlockPos).getBlock() == Blocks.SNOW){
                                            Block.popResource(world, newBlockPos, new ItemStack(Items.SNOWBALL));
                                        }
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
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:2")){
                                                if(random.nextInt(100) + 1 <= 33){
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }else if(unbreakingEnchantment.contains("lvl:3")){
                                                if(random.nextInt(100) + 1 <= 25){
                                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                                }
                                            }
                                        }else{
                                            stack.setDamageValue(stack.getDamageValue() + 1);
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
        Level world = event.getPlayer().level;
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getMainHandItem();

        if (RegisterItems.superShovel.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            ArrayList<Tag> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";

            //enchantments.add(IntNBT.valueOf(0));

            for(Tag enchantment : stack.getEnchantmentTags()){
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
                        if(stack.getDamageValue() >= stack.getMaxDamage() - 1){
                            stack.shrink(1);
                            break;
                        }

                        if (world.getBlockState(new BlockPos(bx + x, by + 1, bz + z)).getBlock() == Blocks.AIR) {
                            if (world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.GRASS_BLOCK) {
                                world.setBlockAndUpdate(new BlockPos(bx + x, by, bz + z), Blocks.DIRT_PATH.defaultBlockState());
                                if (!player.isCreative()) {
                                    if(unbreakingEnchantment.length() != 0){
                                        if(unbreakingEnchantment.contains("lvl:1")){
                                            if(random.nextInt(100) + 1 <= 50){
                                                stack.setDamageValue(stack.getDamageValue() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:2")){
                                            if(random.nextInt(100) + 1 <= 33){
                                                stack.setDamageValue(stack.getDamageValue() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:3")){
                                            if(random.nextInt(100) + 1 <= 25){
                                                stack.setDamageValue(stack.getDamageValue() + 1);
                                            }
                                        }
                                    }else{
                                        stack.setDamageValue(stack.getDamageValue() + 1);
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
        Level world = event.getWorld();
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getMainHandItem();

        if (RegisterItems.superHoe.equals(stack.getItem())) {
            int bx = pos.getX();
            int by = pos.getY();
            int bz = pos.getZ();

            ArrayList<Tag> enchantments = new ArrayList<>();
            Random random = new Random();
            String unbreakingEnchantment = "";

            //enchantments.add(IntNBT.valueOf(0));

            for(Tag enchantment : stack.getEnchantmentTags()){
                enchantments.add(enchantment);
            }

            for(int i=0;i<enchantments.size(); i++){
                if(enchantments.get(i).toString().contains("minecraft:unbreaking")){
                    unbreakingEnchantment = enchantments.get(i).toString();
                }
            }



            if(world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(pos).getBlock() == Blocks.DIRT_PATH){
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        if(stack.getDamageValue() >= stack.getMaxDamage()){
                            stack.shrink(1);
                            break;
                        }
                        if(world.getBlockState(new BlockPos(bx + x,by + 1,bz + z)).getBlock() == Blocks.AIR){
                            if (world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.DIRT || world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.DIRT_PATH ) {
                                world.setBlockAndUpdate(new BlockPos(bx + x, by, bz + z), Blocks.FARMLAND.defaultBlockState());
                                if(!player.isCreative()){
                                    if(unbreakingEnchantment.length() != 0){
                                        if(unbreakingEnchantment.contains("lvl:1")){
                                            if(random.nextInt(100) + 1 <= 50){
                                                stack.setDamageValue(stack.getDamageValue() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:2")){
                                            if(random.nextInt(100) + 1 <= 33){
                                                stack.setDamageValue(stack.getDamageValue() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:3")){
                                            if(random.nextInt(100) + 1 <= 25){
                                                stack.setDamageValue(stack.getDamageValue() + 1);
                                            }
                                        }
                                    }else{
                                        stack.setDamageValue(stack.getDamageValue() + 1);
                                    }
                                }

                            }else if(world.getBlockState(new BlockPos(bx + x, by, bz + z)).getBlock() == Blocks.COARSE_DIRT){
                                //world.setBlockState(new BlockPos(bx + x, by, bz + z), Blocks.DIRT.getDefaultState());
                                if(!player.isCreative()){
                                    if(unbreakingEnchantment.length() != 0){
                                        if(unbreakingEnchantment.contains("lvl:1")){
                                            if(random.nextInt(100) + 1 <= 50){
                                                stack.setDamageValue(stack.getDamageValue() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:2")){
                                            if(random.nextInt(100) + 1 <= 33){
                                                stack.setDamageValue(stack.getDamageValue() + 1);
                                            }
                                        }else if(unbreakingEnchantment.contains("lvl:3")){
                                            if(random.nextInt(100) + 1 <= 25){
                                                stack.setDamageValue(stack.getDamageValue() + 1);
                                            }
                                        }
                                    }else{
                                        stack.setDamageValue(stack.getDamageValue() + 1);
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
        if(event.getSource().getDirectEntity() instanceof Player){
            LivingEntity target = event.getEntityLiving();
            Player player = (Player) event.getSource().getDirectEntity();
            ItemStack stack = player.getMainHandItem();

            if(RegisterItems.superSword.equals(stack.getItem())){
                target.addEffect(new MobEffectInstance(MobEffect.byId(18), 60, 1));
                target.addEffect(new MobEffectInstance(MobEffect.byId(19), 60, 1));
                target.addEffect(new MobEffectInstance(MobEffect.byId(24), 60, 1));
            }
        }
    }

    @SubscribeEvent
    public static void ItemCupHitEntity(LivingHurtEvent event){
        if(event.getSource().getDirectEntity() instanceof Player){
            LivingEntity target = event.getEntityLiving();
            Player player = (Player) event.getSource().getDirectEntity();
            ItemStack stack = player.getMainHandItem();

            if(RegisterItems.itemCup.equals(stack.getItem())){
                if(target instanceof Player){
                    Player playerTarget = (Player)event.getEntityLiving();
                    if(!playerTarget.getActiveEffects().toString().contains("effect.minecraft.fire_resistance")){
                        if(!playerTarget.isCreative()){
                            playerTarget.setSecondsOnFire(3);
                        }
                    }
                }else{
                    target.setSecondsOnFire(3);
                }
            }
        }
    }

    @SubscribeEvent
    public static void SpecialCupHitEntity(LivingHurtEvent event){
        if(event.getSource().getDirectEntity() instanceof Player){
            LivingEntity target = event.getEntityLiving();
            Player player = (Player) event.getSource().getDirectEntity();
            ItemStack stack = player.getMainHandItem();

            if(RegisterItems.specialCup.equals(stack.getItem())){
                target.addEffect(new MobEffectInstance(MobEffect.byId(20), 100, 5));
                target.addEffect(new MobEffectInstance(MobEffect.byId(24), 100, 1));
            }
        }


    }


    private static ArrayList<BlockPos> getWoodNeighbours(Level world, BlockPos blockPos, Block block, ItemStack stack) {
        ArrayList<BlockPos> list = new ArrayList<>();
        for(int x=-1; x<=1; x++){
            if(stack.getDamageValue() >= stack.getMaxDamage() - 1){
                stack.shrink(1);
                break;
            }
            for(int y=-1; y<=1; y++){
                if(stack.getDamageValue() >= stack.getMaxDamage() - 1){
                    stack.shrink(1);
                    break;
                }
                for(int z=-1; z<=1; z++) {
                    if(stack.getDamageValue() >= stack.getMaxDamage() - 1){
                        stack.shrink(1);
                        break;
                    }
                    BlockPos newBlockPos = new BlockPos(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ() + z);
                    if(world.getBlockState(newBlockPos).getBlock().equals(block)) {
                        list.add(newBlockPos);
                    }
                }
            }
        }

        return list;
    }


}
