/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.Registries;

import me.Supervogel1.supertools.main.RecipeHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRecipes {

    public BlockRecipes(){
        initCraftingRecipes();
    }

    public void initCraftingRecipes() {
    	
    	
    	//+--------------------------------------------------------+
        //|         Crafting Abkuerzungen                          |
        //+--------------------------------------------------------+
        ItemStack stick = new ItemStack(Items.STICK);
        ItemStack coal = new ItemStack(Items.COAL);
        ItemStack emerald = new ItemStack(Items.EMERALD);
        ItemStack quartz = new ItemStack(Items.QUARTZ);
        ItemStack lapis = new ItemStack(Items.DYE, 1, 4);
        ItemStack redstone = new ItemStack(Items.REDSTONE);
        ItemStack diamond = new ItemStack(Items.DIAMOND);
        ItemStack gold = new ItemStack(Items.GOLD_INGOT);
        ItemStack ItemCup = new ItemStack(ItemRegistry.ItemCup);
        ItemStack cobble = new ItemStack(Blocks.COBBLESTONE);
        ItemStack Water = new ItemStack(Items.WATER_BUCKET);
        ItemStack concrete = new ItemStack(BlockRegistry.concreteblock);
        ItemStack cement = new ItemStack(BlockRegistry.cementblock);
        ItemStack gravel = new ItemStack(Blocks.GRAVEL);
        ItemStack sand = new ItemStack(Blocks.SAND);
      
        //+----------------------------------------------------------+
        //|                     ShapedCrafting                       |
        //+----------------------------------------------------------+
        
        RecipeHandler.addShapedRecipe(new ItemStack(BlockRegistry.cementblock, 1), "GSC", 'G',gravel , 'S',sand, 'C', cobble );
        //GameRegistry.addRecipe(new ItemStack(BlockRegistry.concretefurnace, 1), "CCC", "C#C", "CCC", Character.valueOf('C'), concrete);
        
        //+----------------------------------------------------------+
        //|                     ShapelessCrafting                    |
        //+----------------------------------------------------------+

        RecipeHandler.addShapelessRecipe(new ItemStack(BlockRegistry.wetconcreteblock), Water, cement);
        
        
        
        //+----------------------------------------------------------+
        //|                     Smelting Recipes                     |
        //+----------------------------------------------------------+
        
        RecipeHandler.addSmelting(new ItemStack(BlockRegistry.wetconcreteblock), new ItemStack(BlockRegistry.concreteblock), 0.5F);
        
        

    }



}
