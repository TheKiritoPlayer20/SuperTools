/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.proxys;

import me.Supervogel1.supertools.Registries.BlockRegistry;
import me.Supervogel1.supertools.Registries.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SuperToolsClientProxy extends SuperToolsProxy {

	@Override
	public void registerRenderers() {


		//Super Tools
		registerItemModel(ItemRegistry.SuperSword,0);
		registerItemModel(ItemRegistry.SpecialCup,0);
		registerItemModel(ItemRegistry.ItemCup,0);
		registerItemModel(ItemRegistry.SuperBoneMeal,0);
		registerItemModel(ItemRegistry.SuperHoe,0);
		registerItemModel(ItemRegistry.SuperWaterBucket,0);

		//Coal Tools
		registerItemModel(ItemRegistry.CoalHoe,0);
		registerItemModel(ItemRegistry.CoalAxe,0);
		registerItemModel(ItemRegistry.CoalPickaxe,0);
		registerItemModel(ItemRegistry.CoalSpade,0);
		registerItemModel(ItemRegistry.CoalSword,0);

		//Emerald Tools
		registerItemModel(ItemRegistry.EmeraldHoe,0);
		registerItemModel(ItemRegistry.EmeraldAxe,0);
		registerItemModel(ItemRegistry.EmeraldPickaxe,0);
		registerItemModel(ItemRegistry.EmeraldSpade,0);
		registerItemModel(ItemRegistry.EmeraldSword,0);

		//Emerald Tools
		registerItemModel(ItemRegistry.ObsidianHoe,0);
		registerItemModel(ItemRegistry.ObsidianAxe,0);
		registerItemModel(ItemRegistry.ObsidianPickaxe,0);
		registerItemModel(ItemRegistry.ObsidianSpade,0);
		registerItemModel(ItemRegistry.ObsidianSword,0);

		//Lapis Tools
		registerItemModel(ItemRegistry.LapisHoe,0);
		registerItemModel(ItemRegistry.LapisAxe,0);
		registerItemModel(ItemRegistry.LapisPickaxe,0);
		registerItemModel(ItemRegistry.LapisSpade,0);
		registerItemModel(ItemRegistry.LapisSword,0);

		//Quartz Tools
		registerItemModel(ItemRegistry.QuartzHoe,0);
		registerItemModel(ItemRegistry.QuartzAxe,0);
		registerItemModel(ItemRegistry.QuartzPickaxe,0);
		registerItemModel(ItemRegistry.QuartzSpade,0);
		registerItemModel(ItemRegistry.QuartzSword,0);

		//Redstone Tools
		registerItemModel(ItemRegistry.RedstoneHoe,0);
		registerItemModel(ItemRegistry.RedstoneAxe,0);
		registerItemModel(ItemRegistry.RedstonePickaxe,0);
		registerItemModel(ItemRegistry.RedstoneSpade,0);
		registerItemModel(ItemRegistry.RedstoneSword,0);
		
		//Lapis Armor
		registerItemModel(ItemRegistry.LapisHelmet, 0);
		registerItemModel(ItemRegistry.LapisChestplate, 0);
		registerItemModel(ItemRegistry.LapisLeggings, 0);
		registerItemModel(ItemRegistry.LapisBoots, 0);
		
		//Obsidian Armor
		registerItemModel(ItemRegistry.ObsidianHelmet, 0);
		registerItemModel(ItemRegistry.ObsidianChestplate, 0);
		registerItemModel(ItemRegistry.ObsidianLeggings, 0);
		registerItemModel(ItemRegistry.ObsidianBoots, 0);
		
		//Redstone Armor
		registerItemModel(ItemRegistry.EmeraldHelmet, 0);
		registerItemModel(ItemRegistry.EmeraldChestplate, 0);
		registerItemModel(ItemRegistry.EmeraldLeggings, 0);
		registerItemModel(ItemRegistry.EmeraldBoots, 0);
		
		
		//Bloecke
		registerItemModel(BlockRegistry.cementblock,0);
		registerItemModel(BlockRegistry.wetconcreteblock,0);
		registerItemModel(BlockRegistry.concreteblock, 0);
		//registerItemModel(BlockRegistry.concretefurnace, 0);
		//registerItemModel(BlockRegistry.litconcretefurnace,0);
	}
	


	private void registerItemModel(Object obj, int meta){


		Item item;
		if (obj instanceof  Item){
			item = (Item) obj;
		} else if (obj instanceof Block){
			item = Item.getItemFromBlock((Block) obj);
		} else {
			throw new IllegalArgumentException("Only item and block instances");
		}
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta ,new ModelResourceLocation( "supertools:" + item.getUnlocalizedName().substring(5), "inventory"));


	}


	
	
	
}



