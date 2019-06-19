/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.Registries;
import me.Supervogel1.supertools.armor.ItemEmeraldArmor;
import me.Supervogel1.supertools.armor.ItemLapisArmor;
import me.Supervogel1.supertools.armor.ItemObsidianArmor;
import me.Supervogel1.supertools.main.SuperTools;
import me.Supervogel1.supertools.main.Utils;
import me.Supervogel1.supertools.tools.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;

public class ItemRegistry {

    //Super Tools
    public static Item SuperSword;
    public static Item SpecialCup;
    public static Item ItemCup;
    public static Item SuperBoneMeal;
    public static Item SuperHoe;
    public static Item SuperWaterBucket;

    //Coal Tools
    public static Item CoalHoe;
    public static Item CoalAxe;
    public static Item CoalPickaxe;
    public static Item CoalSpade;
    public static Item CoalSword;

    //Emerald Tools
    public static Item EmeraldHoe;
    public static Item EmeraldAxe;
    public static Item EmeraldPickaxe;
    public static Item EmeraldSpade;
    public static Item EmeraldSword;

    //Obsidian Tools
    public static Item ObsidianHoe;
    public static Item ObsidianAxe;
    public static Item ObsidianPickaxe;
    public static Item ObsidianSpade;
    public static Item ObsidianSword;

    //Lapis Tools
    public static Item LapisHoe;
    public static Item LapisAxe;
    public static Item LapisPickaxe;
    public static Item LapisSpade;
    public static Item LapisSword;

    //Quartz Tools
    public static Item QuartzHoe;
    public static Item QuartzAxe;
    public static Item QuartzPickaxe;
    public static Item QuartzSpade;
    public static Item QuartzSword;

    //Redstone Tools
    public static Item RedstoneHoe;
    public static Item RedstoneAxe;
    public static Item RedstonePickaxe;
    public static Item RedstoneSpade;
    public static Item RedstoneSword;

    //Lapis Armor
    public static Item LapisHelmet;
    public static Item LapisChestplate;
    public static Item LapisLeggings;
    public static Item LapisBoots;

    //Obsidian Armor
    public static Item ObsidianHelmet;
    public static Item ObsidianChestplate;
    public static Item ObsidianLeggings;
    public static Item ObsidianBoots;

    //Emerald Armor
    public static Item EmeraldHelmet;
    public static Item EmeraldChestplate;
    public static Item EmeraldLeggings;
    public static Item EmeraldBoots;

    //Armor Materials
    public static ArmorMaterial LAPISMATERIAL;
    public static ArmorMaterial EMERALDMATERIAL;
    public static ArmorMaterial OBSIDIANMATERIAL;
    
    //Tool Materials
    public static ToolMaterial COAL;
    public static ToolMaterial OBSIDIAN;
    public static ToolMaterial EMERALD;
    public static ToolMaterial LAPIS;
    public static ToolMaterial QUARTZ;
    public static ToolMaterial REDSTONE;
    public static ToolMaterial ITEMCUP;
    public static ToolMaterial SPECIALCUP;
    public static ToolMaterial SUPERHOE;
    public static ToolMaterial SUPERSWORD;

    public ItemRegistry() {
        init();
        register();
        registerRenderers();
    }

    private void init(){


    	LAPISMATERIAL= EnumHelper.addArmorMaterial("LapisArmor","", 10, new int[]{2, 3, 4, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    	EMERALDMATERIAL = EnumHelper.addArmorMaterial("EmeraldArmor","", 33, new int[]{4, 5, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
    	OBSIDIANMATERIAL = EnumHelper.addArmorMaterial("ObsidianArmor","", 33, new int[]{2, 6, 10, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);

    	COAL = EnumHelper.addToolMaterial("Coal", 1, 150, 4.5F, 1.0F, 5);
    	OBSIDIAN = EnumHelper.addToolMaterial("Obsidian", 3, 1800, 8.7F, 3.5F, 10);
    	EMERALD  = EnumHelper.addToolMaterial("Emerald", 3, 1561, 9.5F, 3.5F, 10);
    	LAPIS = EnumHelper.addToolMaterial("Lapis", 1, 150, 6.0F, 2.0F, 5);
    	QUARTZ = EnumHelper.addToolMaterial("Quartz", 3, 2000, 10.0F, 4.0F, 10);
    	REDSTONE = EnumHelper.addToolMaterial("Redstone", 2, 150, 15.0F, 3.0F, 14);
    	ITEMCUP = EnumHelper.addToolMaterial("ItemCup", 3, 1700, 10.6F, 0.0F, 15);
    	SPECIALCUP = EnumHelper.addToolMaterial("SpecialCup", 4, 2000, 15.0F, 0.0F, 17);
    	SUPERHOE = EnumHelper.addToolMaterial("SuperHoe", 2, 1800, 10.6F, 0.0F, 16);
    	SUPERSWORD = EnumHelper.addToolMaterial("SuperSword", 3, 1700, 10.6F, 4.5F, 16);

    	
        //--------------------------------------------------------------//
        //                             Super Tools                      //
        //--------------------------------------------------------------//

        SuperSword = new Swords(SUPERSWORD).setUnlocalizedName("SuperSword").setCreativeTab(SuperTools.supertools);
        Utils.setNames(SuperSword, "SuperSword");
        SpecialCup = new SpecialCup(EnumToolMaterialBasis.SpecialCup).setUnlocalizedName("SpecialCup").setCreativeTab(SuperTools.supertools);
        Utils.setNames(SpecialCup, "SpecialCup");
        ItemCup = new Itemcup(EnumToolMaterialBasis.ItemCup).setUnlocalizedName("ItemCup").setCreativeTab(SuperTools.supertools);
        Utils.setNames(ItemCup, "ItemCup");
        SuperBoneMeal = new SuperBoneMeal(EnumToolMaterialBasis.SuperSword).setUnlocalizedName("SuperBoneMeal").setCreativeTab(SuperTools.supertools);
        Utils.setNames(SuperBoneMeal, "SuperBoneMeal");
        SuperHoe = new SuperHoe(EnumToolMaterialBasis.SuperHoe).setUnlocalizedName("SuperHoe").setCreativeTab(SuperTools.supertools);
        Utils.setNames(SuperHoe, "SuperHoe");
        SuperWaterBucket = new SuperWaterBucket(EnumToolMaterialBasis.SuperSword).setUnlocalizedName("SuperWaterBucket").setCreativeTab(SuperTools.supertools);
        Utils.setNames(SuperWaterBucket, "SuperWaterBucket");

         //-------------------------------------------------------------//
         //                            Coal Tools                       //
         //-------------------------------------------------------------//

         CoalHoe = new Hoes(COAL).setUnlocalizedName("ItemCoalHoe").setCreativeTab(SuperTools.tools);
         Utils.setNames(CoalHoe,"ItemCoalHoe");
         CoalAxe= new Axes(COAL, 0, 0).setUnlocalizedName("ItemCoalAxe").setCreativeTab(SuperTools.tools);
         Utils.setNames(CoalAxe,"ItemCoalAxe");
         CoalPickaxe= new Pickaxes(COAL).setUnlocalizedName("ItemCoalPickaxe").setCreativeTab(SuperTools.tools);
         Utils.setNames(CoalPickaxe,"ItemCoalPickaxe");
         CoalSpade= new Spades(COAL).setUnlocalizedName("ItemCoalSpade").setCreativeTab(SuperTools.tools);
         Utils.setNames(CoalSpade,"ItemCoalSpade");
         CoalSword= new Swords(COAL).setUnlocalizedName("ItemCoalSword").setCreativeTab(SuperTools.tools);
         Utils.setNames(CoalSword,"ItemCoalSword");

         //-------------------------------------------------------------//
         //                            Emerald Tools                    //
         //-------------------------------------------------------------//

         EmeraldHoe = new Hoes(EMERALD).setUnlocalizedName("ItemEmeraldHoe").setCreativeTab(SuperTools.tools);
         Utils.setNames(EmeraldHoe, "ItemEmeraldHoe");
         EmeraldAxe= new Axes(EMERALD, 0, 0).setUnlocalizedName("ItemEmeraldAxe").setCreativeTab(SuperTools.tools);
         Utils.setNames(EmeraldAxe,"ItemEmeraldAxe");
         EmeraldPickaxe= new Pickaxes(EMERALD).setUnlocalizedName("ItemEmeraldPickaxe").setCreativeTab(SuperTools.tools);
         Utils.setNames(EmeraldPickaxe,"ItemEmeraldPickaxe");
         EmeraldSpade= new Spades(EMERALD).setUnlocalizedName("ItemEmeraldSpade").setCreativeTab(SuperTools.tools);
         Utils.setNames(EmeraldSpade,"ItemEmeraldSpade");
         EmeraldSword= new Swords(EMERALD).setUnlocalizedName("ItemEmeraldSword").setCreativeTab(SuperTools.tools);
         Utils.setNames(EmeraldSword,"ItemEmeraldSword");

        //-------------------------------------------------------------//
        //                            Emerald Tools                    //
        //-------------------------------------------------------------//

        ObsidianHoe = new Hoes(OBSIDIAN).setUnlocalizedName("ItemObsidianHoe").setCreativeTab(SuperTools.tools);
        Utils.setNames(ObsidianHoe, "ItemObsidianHoe");
        ObsidianAxe= new Axes(OBSIDIAN, 0, 0).setUnlocalizedName("ItemObsidianAxe").setCreativeTab(SuperTools.tools);
        Utils.setNames(ObsidianAxe,"ItemObsidianAxe");
        ObsidianPickaxe= new Pickaxes(OBSIDIAN).setUnlocalizedName("ItemObsidianPickaxe").setCreativeTab(SuperTools.tools);
        Utils.setNames(ObsidianPickaxe,"ItemObsidianPickaxe");
        ObsidianSpade= new Spades(OBSIDIAN).setUnlocalizedName("ItemObsidianSpade").setCreativeTab(SuperTools.tools);
        Utils.setNames(ObsidianSpade,"ItemObsidianSpade");
        ObsidianSword= new Swords(OBSIDIAN).setUnlocalizedName("ItemObsidianSword").setCreativeTab(SuperTools.tools);
        Utils.setNames(ObsidianSword,"ItemObsidianSword");

        //-------------------------------------------------------------//
        //                            Lapis Tools                      //
        //-------------------------------------------------------------//

        LapisHoe = new Hoes(LAPIS).setUnlocalizedName("ItemLapisHoe").setCreativeTab(SuperTools.tools);
        Utils.setNames(LapisHoe, "ItemLapisHoe");
        LapisAxe= new Axes(LAPIS, 0, 0).setUnlocalizedName("ItemLapisAxe").setCreativeTab(SuperTools.tools);
        Utils.setNames(LapisAxe,"ItemLapisAxe");
        LapisPickaxe= new Pickaxes(LAPIS).setUnlocalizedName("ItemLapisPickaxe").setCreativeTab(SuperTools.tools);
        Utils.setNames(LapisPickaxe,"ItemLapisPickaxe");
        LapisSpade= new Spades(LAPIS).setUnlocalizedName("ItemLapisSpade").setCreativeTab(SuperTools.tools);
        Utils.setNames(LapisSpade,"ItemLapisSpade");
        LapisSword= new Swords(LAPIS).setUnlocalizedName("ItemLapisSword").setCreativeTab(SuperTools.tools);
        Utils.setNames(LapisSword,"ItemLapisSword");

        //-------------------------------------------------------------//
        //                            Quartz Tools                     //
        //-------------------------------------------------------------//

        QuartzHoe = new Hoes(QUARTZ).setUnlocalizedName("ItemQuartzHoe").setCreativeTab(SuperTools.tools);
        Utils.setNames(QuartzHoe, "ItemQuartzHoe");
        QuartzAxe= new Axes(QUARTZ, 0, 0).setUnlocalizedName("ItemQuartzAxe").setCreativeTab(SuperTools.tools);
        Utils.setNames(QuartzAxe,"ItemQuartzAxe");
        QuartzPickaxe= new Pickaxes(QUARTZ).setUnlocalizedName("ItemQuartzPickaxe").setCreativeTab(SuperTools.tools);
        Utils.setNames(QuartzPickaxe,"ItemQuartzPickaxe");
        QuartzSpade= new Spades(QUARTZ).setUnlocalizedName("ItemQuartzSpade").setCreativeTab(SuperTools.tools);
        Utils.setNames(QuartzSpade,"ItemQuartzSpade");
        QuartzSword= new Swords(QUARTZ).setUnlocalizedName("ItemQuartzSword").setCreativeTab(SuperTools.tools);
        Utils.setNames(QuartzSword,"ItemQuartzSword");

        //-------------------------------------------------------------//
        //                            Redstone Tools                   //
        //-------------------------------------------------------------//

        RedstoneHoe = new Hoes(REDSTONE).setUnlocalizedName("ItemRedstoneHoe").setCreativeTab(SuperTools.tools);
        Utils.setNames(RedstoneHoe, "ItemRedstoneHoe");
        RedstoneAxe= new Axes(REDSTONE, 0, 0).setUnlocalizedName("ItemRedstoneAxe").setCreativeTab(SuperTools.tools);
        Utils.setNames(RedstoneAxe,"ItemRedstoneAxe");
        RedstonePickaxe= new Pickaxes(REDSTONE).setUnlocalizedName("ItemRedstonePickaxe").setCreativeTab(SuperTools.tools);
        Utils.setNames(RedstonePickaxe,"ItemRedstonePickaxe");
        RedstoneSpade= new Spades(REDSTONE).setUnlocalizedName("ItemRedstoneSpade").setCreativeTab(SuperTools.tools);
        Utils.setNames(RedstoneSpade,"ItemRedstoneSpade");
        RedstoneSword= new Swords(REDSTONE).setUnlocalizedName("ItemRedstoneSword").setCreativeTab(SuperTools.tools);
        Utils.setNames(RedstoneSword,"ItemRedstoneSword");

        //-------------------------------------------------------------//
        //                            Lapis Armor                      //
        //-------------------------------------------------------------//

        LapisHelmet = new ItemLapisArmor(LAPISMATERIAL, EntityEquipmentSlot.HEAD).setCreativeTab(SuperTools.Armor);
        Utils.setNames(LapisHelmet, "LapisHelmet");
        LapisChestplate = new ItemLapisArmor(LAPISMATERIAL, EntityEquipmentSlot.CHEST).setCreativeTab(SuperTools.Armor);
        Utils.setNames(LapisChestplate,"LapisChestplate");
        LapisLeggings = new ItemLapisArmor(LAPISMATERIAL, EntityEquipmentSlot.LEGS).setCreativeTab(SuperTools.Armor);
        Utils.setNames(LapisLeggings,"LapisLeggings");
        LapisBoots = new ItemLapisArmor(LAPISMATERIAL, EntityEquipmentSlot.FEET).setCreativeTab(SuperTools.Armor);
        Utils.setNames(LapisBoots, "LapisBoots");


        //-------------------------------------------------------------//
        //                            Obsidian Armor                   //
        //-------------------------------------------------------------//

        ObsidianHelmet = new ItemObsidianArmor(OBSIDIANMATERIAL, EntityEquipmentSlot.HEAD).setCreativeTab(SuperTools.Armor);
        Utils.setNames(ObsidianHelmet, "ObsidianHelmet");
        ObsidianChestplate = new ItemObsidianArmor(OBSIDIANMATERIAL, EntityEquipmentSlot.CHEST).setCreativeTab(SuperTools.Armor);
        Utils.setNames(ObsidianChestplate,"ObsidianChestplate");
        ObsidianLeggings = new ItemObsidianArmor(OBSIDIANMATERIAL, EntityEquipmentSlot.LEGS).setCreativeTab(SuperTools.Armor);
        Utils.setNames(ObsidianLeggings,"ObsidianLeggings");
        ObsidianBoots = new ItemObsidianArmor(OBSIDIANMATERIAL, EntityEquipmentSlot.FEET).setCreativeTab(SuperTools.Armor);
        Utils.setNames(ObsidianBoots, "ObsidianBoots");

        //-------------------------------------------------------------//
        //                            Emerald Armor                    //
        //-------------------------------------------------------------//

        EmeraldHelmet = new ItemEmeraldArmor(EMERALDMATERIAL, EntityEquipmentSlot.HEAD).setCreativeTab(SuperTools.Armor);
        Utils.setNames(EmeraldHelmet, "EmeraldHelmet");
        EmeraldChestplate = new ItemEmeraldArmor(EMERALDMATERIAL, EntityEquipmentSlot.CHEST).setCreativeTab(SuperTools.Armor);
        Utils.setNames(EmeraldChestplate,"EmeraldChestplate");
        EmeraldLeggings = new ItemEmeraldArmor(EMERALDMATERIAL, EntityEquipmentSlot.LEGS).setCreativeTab(SuperTools.Armor);
        Utils.setNames(EmeraldLeggings,"EmeraldLeggings");
        EmeraldBoots = new ItemEmeraldArmor(EMERALDMATERIAL, EntityEquipmentSlot.FEET).setCreativeTab(SuperTools.Armor);
        Utils.setNames(EmeraldBoots, "EmeraldBoots");



    }

    private void register(){
    	

        //--------------------------------------------------------------//
        //                             Super Tools                      //
        //--------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(SuperSword);
        ForgeRegistries.ITEMS.register(SpecialCup);
        ForgeRegistries.ITEMS.register(ItemCup);
        ForgeRegistries.ITEMS.register(SuperBoneMeal);
        ForgeRegistries.ITEMS.register(SuperHoe);
        ForgeRegistries.ITEMS.register(SuperWaterBucket);

        //-------------------------------------------------------------//
        //                            Coal Tools                       //
        //-------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(CoalHoe);
        ForgeRegistries.ITEMS.register(CoalAxe);
        ForgeRegistries.ITEMS.register(CoalPickaxe);
        ForgeRegistries.ITEMS.register(CoalSpade);
        ForgeRegistries.ITEMS.register(CoalSword);

        //-------------------------------------------------------------//
        //                            Emerald Tools                    //
        //-------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(EmeraldHoe);
        ForgeRegistries.ITEMS.register(EmeraldAxe);
        ForgeRegistries.ITEMS.register(EmeraldPickaxe);
        ForgeRegistries.ITEMS.register(EmeraldSpade);
        ForgeRegistries.ITEMS.register(EmeraldSword);

        //-------------------------------------------------------------//
        //                            Emerald Tools                    //
        //-------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(ObsidianHoe);
        ForgeRegistries.ITEMS.register(ObsidianAxe);
        ForgeRegistries.ITEMS.register(ObsidianPickaxe);
        ForgeRegistries.ITEMS.register(ObsidianSpade);
        ForgeRegistries.ITEMS.register(ObsidianSword);

        //-------------------------------------------------------------//
        //                            Lapis Tools                      //
        //-------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(LapisHoe);
        ForgeRegistries.ITEMS.register(LapisAxe);
        ForgeRegistries.ITEMS.register(LapisPickaxe);
        ForgeRegistries.ITEMS.register(LapisSpade);
        ForgeRegistries.ITEMS.register(LapisSword);
        //-------------------------------------------------------------//
        //                            Quartz Tools                     //
        //-------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(QuartzHoe);
        ForgeRegistries.ITEMS.register(QuartzAxe);
        ForgeRegistries.ITEMS.register(QuartzPickaxe);
        ForgeRegistries.ITEMS.register(QuartzSpade);
        ForgeRegistries.ITEMS.register(QuartzSword);

        //-------------------------------------------------------------//
        //                            Redstone Tools                   //
        //-------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(RedstoneHoe);
        ForgeRegistries.ITEMS.register(RedstoneAxe);
        ForgeRegistries.ITEMS.register(RedstonePickaxe);
        ForgeRegistries.ITEMS.register(RedstoneSpade);
        ForgeRegistries.ITEMS.register(RedstoneSword);

        //-------------------------------------------------------------//
        //                            Lapis Armor                      //
        //-------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(LapisHelmet);
        ForgeRegistries.ITEMS.register(LapisChestplate);
        ForgeRegistries.ITEMS.register(LapisLeggings);
        ForgeRegistries.ITEMS.register(LapisBoots);

        //-------------------------------------------------------------//
        //                            Obsidian Armor                   //
        //-------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(ObsidianHelmet);
        ForgeRegistries.ITEMS.register(ObsidianChestplate);
        ForgeRegistries.ITEMS.register(ObsidianLeggings);
        ForgeRegistries.ITEMS.register(ObsidianBoots);

        //-------------------------------------------------------------//
        //                            Redstone Armor                   //
        //-------------------------------------------------------------//

        ForgeRegistries.ITEMS.register(EmeraldHelmet);
        ForgeRegistries.ITEMS.register(EmeraldChestplate);
        ForgeRegistries.ITEMS.register(EmeraldLeggings);
        ForgeRegistries.ITEMS.register(EmeraldBoots);

        
        
    }

    public void registerRenderers() {


		//Super Tools
		registerItemModel(SuperSword,0);
		registerItemModel(SpecialCup,0);
		registerItemModel(ItemCup,0);
		registerItemModel(SuperBoneMeal,0);
		registerItemModel(SuperHoe,0);
		registerItemModel(SuperWaterBucket,0);

		//Coal Tools
		registerItemModel(CoalHoe,0);
		registerItemModel(CoalAxe,0);
		registerItemModel(CoalPickaxe,0);
		registerItemModel(CoalSpade,0);
		registerItemModel(CoalSword,0);

		//Emerald Tools
		registerItemModel(EmeraldHoe,0);
		registerItemModel(EmeraldAxe,0);
		registerItemModel(EmeraldPickaxe,0);
		registerItemModel(EmeraldSpade,0);
		registerItemModel(EmeraldSword,0);

		//Emerald Tools
		registerItemModel(ObsidianHoe,0);
		registerItemModel(ObsidianAxe,0);
		registerItemModel(ObsidianPickaxe,0);
		registerItemModel(ObsidianSpade,0);
		registerItemModel(ObsidianSword,0);

		//Lapis Tools
		registerItemModel(LapisHoe,0);
		registerItemModel(LapisAxe,0);
		registerItemModel(LapisPickaxe,0);
		registerItemModel(LapisSpade,0);
		registerItemModel(LapisSword,0);

		//Quartz Tools
		registerItemModel(QuartzHoe,0);
		registerItemModel(QuartzAxe,0);
		registerItemModel(QuartzPickaxe,0);
		registerItemModel(QuartzSpade,0);
		registerItemModel(QuartzSword,0);

		//Redstone Tools
		registerItemModel(RedstoneHoe,0);
		registerItemModel(RedstoneAxe,0);
		registerItemModel(RedstonePickaxe,0);
		registerItemModel(RedstoneSpade,0);
		registerItemModel(RedstoneSword,0);
		
		//Lapis Armor
		registerItemModel(LapisHelmet, 0);
		registerItemModel(LapisChestplate, 0);
		registerItemModel(LapisLeggings, 0);
		registerItemModel(LapisBoots, 0);
		
		//Obsidian Armor
		registerItemModel(ObsidianHelmet, 0);
		registerItemModel(ObsidianChestplate, 0);
		registerItemModel(ObsidianLeggings, 0);
		registerItemModel(ObsidianBoots, 0);
		
		//Redstone Armor
		registerItemModel(EmeraldHelmet, 0);
		registerItemModel(EmeraldChestplate, 0);
		registerItemModel(EmeraldLeggings, 0);
		registerItemModel(EmeraldBoots, 0);
		
		
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
