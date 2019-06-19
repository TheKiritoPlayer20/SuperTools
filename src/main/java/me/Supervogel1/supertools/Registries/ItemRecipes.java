/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.Registries;

import me.Supervogel1.supertools.main.RecipeHandler;
import net.minecraft.init.Blocks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ItemRecipes {

    public ItemRecipes(){
        initCraftingRecipes();
    }

    public void initCraftingRecipes() {


        //+--------------------------------------------------------+
        //|         Crafting Abkuerzungen                          |
        //+--------------------------------------------------------+
        ItemStack stickStack = new ItemStack(Items.STICK);
        ItemStack coalStack = new ItemStack(Items.COAL);
        ItemStack emeraldStack = new ItemStack(Items.EMERALD);
        ItemStack quartzStack = new ItemStack(Items.QUARTZ);
        ItemStack lapisStack = new ItemStack(Items.DYE, 1, 4);
        ItemStack redstoneStack = new ItemStack(Items.REDSTONE);
        ItemStack diamondStack = new ItemStack(Items.DIAMOND);
        ItemStack goldStack = new ItemStack(Items.GOLD_INGOT);
        ItemStack ItemCup = new ItemStack(ItemRegistry.ItemCup);
        ItemStack obsidianstack = new ItemStack(Blocks.OBSIDIAN);
        ItemStack placeholder = new ItemStack(Items.AIR);

        //-------------------------------------------------------------//
        //                            Coal Tools                       //
        //-------------------------------------------------------------//
        
        

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.CoalHoe, 1), "CC","S#","S#", Character.valueOf('C'), coalStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.CoalAxe, 1), "CC","SC","S#", Character.valueOf('C'), coalStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.CoalPickaxe, 1), "CCC","#S#","#S#", Character.valueOf('C'), coalStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.CoalSpade, 1), "C","S","S", Character.valueOf('C'), coalStack, Character.valueOf('S'), stickStack);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.CoalSword, 1), "C","C","S", Character.valueOf('C'), coalStack, Character.valueOf('S'), stickStack);

        //-------------------------------------------------------------//
        //                            Emerald Tools                    //
        //-------------------------------------------------------------//

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.EmeraldHoe, 1), "EE","S#","S#", Character.valueOf('E'), emeraldStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.EmeraldAxe, 1), "EE","SE","S#", Character.valueOf('E'), emeraldStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.EmeraldPickaxe, 1), "EEE","#S#","#S#", Character.valueOf('E'), emeraldStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.EmeraldSpade, 1), "E","S","S", Character.valueOf('E'), emeraldStack, Character.valueOf('S'), stickStack);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.EmeraldSword, 1), "E","E","S", Character.valueOf('E'), emeraldStack, Character.valueOf('S'), stickStack);


        //-------------------------------------------------------------//
        //                        Obsidian Tools                       //
        //-------------------------------------------------------------//

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ObsidianHoe, 1), "OO","S#","S#", Character.valueOf('O'), obsidianstack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ObsidianAxe, 1), "OO","SO","S#", Character.valueOf('O'), obsidianstack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ObsidianPickaxe, 1), "OOO","#S#","#S#", Character.valueOf('O'), obsidianstack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ObsidianSpade, 1), "O","S","S", Character.valueOf('O'), obsidianstack, Character.valueOf('S'), stickStack);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ObsidianSword, 1), "O","O","S", Character.valueOf('O'), obsidianstack, Character.valueOf('S'), stickStack);


        //-------------------------------------------------------------//
        //                            Lapis Tools                      //
        //-------------------------------------------------------------//

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.LapisHoe, 1), "LL","S#","S#", Character.valueOf('L'), lapisStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.LapisAxe, 1), "LL","SL","S#", Character.valueOf('L'), lapisStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.LapisPickaxe, 1), "LLL","#S#","#S#", Character.valueOf('L'), lapisStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.LapisSpade, 1), "L","S","S", Character.valueOf('L'), lapisStack,  Character.valueOf('S'), stickStack);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.LapisSword, 1), "L","L","S", Character.valueOf('L'), lapisStack,  Character.valueOf('S'), stickStack);

        //-------------------------------------------------------------//
        //                            Quartz Tools                     //
        //-------------------------------------------------------------//

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.QuartzHoe, 1), "QQ","S#","S#", Character.valueOf('Q'), quartzStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.QuartzAxe, 1), "QQ","SQ","S#", Character.valueOf('Q'), quartzStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.QuartzPickaxe, 1), "QQQ","#S#","#S#", Character.valueOf('Q'), quartzStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.QuartzSpade, 1), "Q","S","S", Character.valueOf('Q'), quartzStack, Character.valueOf('S'), stickStack);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.QuartzSword, 1), "Q","Q","S", Character.valueOf('Q'), quartzStack, Character.valueOf('S'), stickStack);


        //-------------------------------------------------------------//
        //                            Redstone Tools                   //
        //-------------------------------------------------------------//

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.RedstoneHoe, 1), "RR","S#","S#", Character.valueOf('R'), redstoneStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.RedstoneAxe, 1), "RR","SR","S#", Character.valueOf('R'), redstoneStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.RedstonePickaxe,1), "RRR","#S#","#S#", Character.valueOf('R'), redstoneStack, Character.valueOf('S'), stickStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.RedstoneSpade, 1), "R","S","S", Character.valueOf('R'), redstoneStack, Character.valueOf('S'), stickStack);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.RedstoneSword, 1), "R","R","S", Character.valueOf('R'), redstoneStack, Character.valueOf('S'), stickStack);

        //--------------------------------------------------------------//
        //                             Super Tools                      //
        //--------------------------------------------------------------//

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ItemCup, 1), "G#G", "GDG","DDD", Character.valueOf('D'), diamondStack, Character.valueOf('G'), goldStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.SuperHoe, 1), "DG", "S#","S#", Character.valueOf('G'), goldStack, Character.valueOf('S'), stickStack, Character.valueOf('D'), diamondStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.SuperSword, 1), "G", "G","D", Character.valueOf('D'), diamondStack, Character.valueOf('G'), goldStack);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.SpecialCup, 1), "G#G","GCG","GDG", Character.valueOf('G'), goldStack, Character.valueOf('D'), diamondStack, Character.valueOf('C'), ItemCup, Character.valueOf('#'), placeholder);

        //--------------------------------------------------------------//
        //                             Lapis Armor                      //
        //--------------------------------------------------------------//

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.LapisHelmet, 1), "LLL", "L#L", Character.valueOf('L'), lapisStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.LapisChestplate, 1), "L#L", "LLL", "LLL", Character.valueOf('L'), lapisStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.LapisLeggings, 1), "LLL", "L#L", "L#L", Character.valueOf('L'), lapisStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.LapisBoots, 1),  "L#L", "L#L", Character.valueOf('L'), lapisStack, Character.valueOf('#'), placeholder);


        //--------------------------------------------------------------//
        //                             Obsidian Armor                   //
        //--------------------------------------------------------------//

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ObsidianHelmet, 1), "OOO", "O#O", Character.valueOf('O'), obsidianstack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ObsidianChestplate, 1), "O#O", "OOO", "OOO", Character.valueOf('O'), obsidianstack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ObsidianLeggings, 1), "OOO", "O#O", "O#O", Character.valueOf('O'), obsidianstack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.ObsidianBoots, 1),  "O#O", "O#O", Character.valueOf('O'), obsidianstack, Character.valueOf('#'), placeholder);

        //--------------------------------------------------------------//
        //                             Emerald Armor                    //
        //--------------------------------------------------------------//

        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.EmeraldHelmet, 1), "EEE", "E#E", Character.valueOf('E'), emeraldStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.EmeraldChestplate, 1), "E#E", "EEE", "EEE", Character.valueOf('E'), emeraldStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.EmeraldLeggings, 1), "EEE", "E#E", "E#E", Character.valueOf('E'), emeraldStack, Character.valueOf('#'), placeholder);
        RecipeHandler.addShapedRecipe(new ItemStack(ItemRegistry.EmeraldBoots, 1),  "E#E", "E#E", Character.valueOf('E'), emeraldStack, Character.valueOf('#'), placeholder);

    }
}

