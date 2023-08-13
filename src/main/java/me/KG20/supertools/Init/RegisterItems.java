package me.KG20.supertools.Init;

import me.KG20.supertools.Armor.BasisArmorMaterial;
import me.KG20.supertools.Armor.ItemArmor;
import me.KG20.supertools.Config.Config;
import me.KG20.supertools.Main.Constants;
import me.KG20.supertools.Tools.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class RegisterItems {

    public static final Sickle woodenSickle = new Sickle(new Item.Properties().durability(59));
    public static final Sickle stoneSickle = new Sickle(new Item.Properties().durability(131));
    public static final Sickle ironSickle = new Sickle(new Item.Properties().durability(250));
    public static final Sickle goldenSickle = new Sickle(new Item.Properties().durability(32));
    public static final Sickle diamondSickle = new Sickle(new Item.Properties().durability(1561));
    public static final Sickle netheriteSickle = new Sickle(new Item.Properties().durability(2031).fireResistant());

    public static final Hoe quartzHoe = new Hoe(BasisToolMaterial.quartz, -3, -1F);
    public static final Axe quartzAxe = new Axe(BasisToolMaterial.quartz, -3.1F);
    public static final Pickaxe quartzPickaxe = new Pickaxe(BasisToolMaterial.quartz, -2.8F);
    public static final Shovel quartzShovel = new Shovel(BasisToolMaterial.quartz, -3F);
    public static final Sword quartzSword = new Sword(BasisToolMaterial.quartz, -2.4F);
    public static final Sickle quartzSickle = new Sickle(new Item.Properties().durability(Config.durability_Quartz.get()));

    public static final Hoe copperHoe = new Hoe(BasisToolMaterial.copper, -3, -1F);
    public static final Axe copperAxe = new Axe(BasisToolMaterial.copper, -3.1F);
    public static final Pickaxe copperPickaxe = new Pickaxe(BasisToolMaterial.copper, -2.8F);
    public static final Shovel copperShovel = new Shovel(BasisToolMaterial.copper, -3F);
    public static final Sword copperSword = new Sword(BasisToolMaterial.copper, -2.4F);
    public static final Sickle copperSickle = new Sickle(new Item.Properties().durability(Config.durability_Copper.get()));

    public static final Hoe emeraldHoe = new Hoe(BasisToolMaterial.emerald, -3, -1F);
    public static final Axe emeraldAxe = new Axe(BasisToolMaterial.emerald, -3.1F);
    public static final Pickaxe emeraldPickaxe = new Pickaxe(BasisToolMaterial.emerald, -2.8F);
    public static final Shovel emeraldShovel = new Shovel(BasisToolMaterial.emerald, -3F);
    public static final Sword emeraldSword = new Sword(BasisToolMaterial.emerald, -2.4F);
    public static final Sickle emeraldSickle = new Sickle(new Item.Properties().durability(Config.durability_Emerald.get()));

    public static final Hoe obsidianHoe = new Hoe(BasisToolMaterial.obsidian, -3, -1F);
    public static final Axe obsidianAxe = new Axe(BasisToolMaterial.obsidian, -3.1F);
    public static final Pickaxe obsidianPickaxe = new Pickaxe(BasisToolMaterial.obsidian, -2.8F);
    public static final Shovel obsidianShovel = new Shovel(BasisToolMaterial.obsidian, -3F);
    public static final Sword obsidianSword = new Sword(BasisToolMaterial.obsidian, -2.4F);
    public static final Sickle obsidianSickle = new Sickle(new Item.Properties().durability(Config.durability_Obsidian.get()));

    public static final Hoe lapisHoe = new Hoe(BasisToolMaterial.lapis, -3, -1F);
    public static final Axe lapisAxe = new Axe(BasisToolMaterial.lapis, -3.1F);
    public static final Pickaxe lapisPickaxe = new Pickaxe(BasisToolMaterial.lapis, -2.8F);
    public static final Shovel lapisShovel = new Shovel(BasisToolMaterial.lapis, -3F);
    public static final Sword lapisSword = new Sword(BasisToolMaterial.lapis, -2.4F);
    public static final Sickle lapisSickle = new Sickle(new Item.Properties().durability(Config.durability_Lapis.get()));

    public static final Hoe redstoneHoe = new Hoe(BasisToolMaterial.redstone, -3, -0.5F);
    public static final Axe redstoneAxe = new Axe(BasisToolMaterial.redstone, -2.6F);
    public static final Pickaxe redstonePickaxe = new Pickaxe(BasisToolMaterial.redstone, -2.3F);
    public static final Shovel redstoneShovel = new Shovel(BasisToolMaterial.redstone, -2.5F);
    public static final Sword redstoneSword = new Sword(BasisToolMaterial.redstone, -1.9F);
    public static final Sickle redstoneSickle = new Sickle(new Item.Properties().durability(Config.durability_Redstone.get()));

    public static final ItemArmor emeraldHelmet = new ItemArmor(BasisArmorMaterial.emerald, ArmorItem.Type.HELMET, new Item.Properties());
    public static final ItemArmor emeraldChestplate = new ItemArmor(BasisArmorMaterial.emerald, ArmorItem.Type.CHESTPLATE, new Item.Properties());
    public static final ItemArmor emeraldLeggings = new ItemArmor(BasisArmorMaterial.emerald, ArmorItem.Type.LEGGINGS, new Item.Properties());
    public static final ItemArmor emeraldBoots = new ItemArmor(BasisArmorMaterial.emerald, ArmorItem.Type.BOOTS, new Item.Properties());

    public static final ItemArmor obsidianHelmet = new ItemArmor(BasisArmorMaterial.obsidian, ArmorItem.Type.HELMET, new Item.Properties().fireResistant());
    public static final ItemArmor obsidianChestplate = new ItemArmor(BasisArmorMaterial.obsidian, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant());
    public static final ItemArmor obsidianLeggings = new ItemArmor(BasisArmorMaterial.obsidian, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant());
    public static final ItemArmor obsidianBoots = new ItemArmor(BasisArmorMaterial.obsidian, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant());

    public static final ItemArmor lapisHelmet = new ItemArmor(BasisArmorMaterial.lapis, ArmorItem.Type.HELMET, new Item.Properties());
    public static final ItemArmor lapisChestplate = new ItemArmor(BasisArmorMaterial.lapis, ArmorItem.Type.CHESTPLATE, new Item.Properties());
    public static final ItemArmor lapisLeggings = new ItemArmor(BasisArmorMaterial.lapis, ArmorItem.Type.LEGGINGS, new Item.Properties());
    public static final ItemArmor lapisBoots = new ItemArmor(BasisArmorMaterial.lapis, ArmorItem.Type.BOOTS, new Item.Properties());

    public static final ItemArmor quartzHelmet = new ItemArmor(BasisArmorMaterial.quartz, ArmorItem.Type.HELMET, new Item.Properties().fireResistant());
    public static final ItemArmor quartzChestplate = new ItemArmor(BasisArmorMaterial.quartz, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant());
    public static final ItemArmor quartzLeggings = new ItemArmor(BasisArmorMaterial.quartz, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant());
    public static final ItemArmor quartzBoots = new ItemArmor(BasisArmorMaterial.quartz, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant());

    public static final ItemArmor copperHelmet = new ItemArmor(BasisArmorMaterial.copper, ArmorItem.Type.HELMET, new Item.Properties());
    public static final ItemArmor copperChestplate = new ItemArmor(BasisArmorMaterial.copper, ArmorItem.Type.CHESTPLATE, new Item.Properties());
    public static final ItemArmor copperLeggings = new ItemArmor(BasisArmorMaterial.copper, ArmorItem.Type.LEGGINGS, new Item.Properties());
    public static final ItemArmor copperBoots = new ItemArmor(BasisArmorMaterial.copper, ArmorItem.Type.BOOTS, new Item.Properties());

    public static final BonemealTool boneMealTool = new BonemealTool();
    public static final Hoe superHoe = new Hoe(BasisToolMaterial.supertools, -3, -1F, new Item.Properties());
    public static final Axe superAxe = new Axe(BasisToolMaterial.supertools, -3.1F, new Item.Properties());
    public static final Pickaxe superPickaxe = new Pickaxe(BasisToolMaterial.supertools, -2.8F, new Item.Properties());
    public static final Shovel superShovel = new Shovel(BasisToolMaterial.supertools, -3F, new Item.Properties());
    public static final Sword superSword = new Sword(BasisToolMaterial.supertools, -2.4F, new Item.Properties());
    public static final Cups itemCup = new Cups(BasisToolMaterial.itemcup, -2.8F);
    public static final Cups specialCup = new Cups(BasisToolMaterial.specialcup, -2.8F);
    public static final Sickle superSickle = new Sickle(new Item.Properties().durability(Config.durability_SuperTools.get()));


    @SubscribeEvent
    public static void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS, helper ->{
            registerItem(woodenSickle, "woodensickle", helper);
            registerItem(stoneSickle, "stonesickle", helper);
            registerItem(ironSickle, "ironsickle", helper);
            registerItem(goldenSickle, "goldensickle", helper);
            registerItem(diamondSickle, "diamondsickle", helper);
            registerItem(netheriteSickle, "netheritesickle", helper);

            registerItem(quartzHoe, "quartzhoe", helper);
            registerItem(quartzAxe, "quartzaxe", helper);
            registerItem(quartzPickaxe, "quartzpickaxe", helper);
            registerItem(quartzShovel, "quartzshovel", helper);
            registerItem(quartzSword, "quartzsword", helper);
            registerItem(quartzSickle, "quartzsickle", helper);

            registerItem(copperHoe, "copperhoe", helper);
            registerItem(copperAxe, "copperaxe", helper);
            registerItem(copperPickaxe, "copperpickaxe", helper);
            registerItem(copperShovel, "coppershovel", helper);
            registerItem(copperSword, "coppersword", helper);
            registerItem(copperSickle, "coppersickle", helper);

            registerItem(emeraldHoe, "emeraldhoe", helper);
            registerItem(emeraldAxe, "emeraldaxe", helper);
            registerItem(emeraldPickaxe, "emeraldpickaxe", helper);
            registerItem(emeraldShovel, "emeraldshovel", helper);
            registerItem(emeraldSword, "emeraldsword", helper);
            registerItem(emeraldSickle, "emeraldsickle", helper);

            registerItem(obsidianHoe, "obsidianhoe", helper);
            registerItem(obsidianAxe, "obsidianaxe", helper);
            registerItem(obsidianPickaxe, "obsidianpickaxe", helper);
            registerItem(obsidianShovel, "obsidianshovel", helper);
            registerItem(obsidianSword, "obsidiansword", helper);
            registerItem(obsidianSickle, "obsidiansickle", helper);

            registerItem(lapisHoe, "lapishoe", helper);
            registerItem(lapisAxe, "lapisaxe", helper);
            registerItem(lapisPickaxe, "lapispickaxe", helper);
            registerItem(lapisShovel, "lapisshovel", helper);
            registerItem(lapisSword, "lapissword", helper);
            registerItem(lapisSickle, "lapissickle", helper);

            registerItem(redstoneHoe, "redstonehoe", helper);
            registerItem(redstoneAxe, "redstoneaxe", helper);
            registerItem(redstonePickaxe, "redstonepickaxe", helper);
            registerItem(redstoneShovel, "redstoneshovel", helper);
            registerItem(redstoneSword, "redstonesword", helper);
            registerItem(redstoneSickle, "redstonesickle", helper);

            registerArmorItem(emeraldHelmet, "emeraldhelmet", helper);
            registerArmorItem(emeraldChestplate, "emeraldchestplate", helper);
            registerArmorItem(emeraldLeggings, "emeraldleggings", helper);
            registerArmorItem(emeraldBoots, "emeraldboots", helper);

            registerArmorItem(obsidianHelmet, "obsidianhelmet", helper);
            registerArmorItem(obsidianChestplate, "obsidianchestplate", helper);
            registerArmorItem(obsidianLeggings, "obsidianleggings", helper);
            registerArmorItem(obsidianBoots, "obsidianboots", helper);

            registerArmorItem(lapisHelmet, "lapishelmet", helper);
            registerArmorItem(lapisChestplate, "lapischestplate", helper);
            registerArmorItem(lapisLeggings, "lapisleggings", helper);
            registerArmorItem(lapisBoots, "lapisboots", helper);

            registerArmorItem(quartzHelmet, "quartzhelmet", helper);
            registerArmorItem(quartzChestplate, "quartzchestplate", helper);
            registerArmorItem(quartzLeggings, "quartzleggings", helper);
            registerArmorItem(quartzBoots, "quartzboots", helper);

            registerArmorItem(copperHelmet, "copperhelmet", helper);
            registerArmorItem(copperChestplate, "copperchestplate", helper);
            registerArmorItem(copperLeggings, "copperleggings", helper);
            registerArmorItem(copperBoots, "copperboots", helper);

            if(Config.enable_SuperTools.get()){
                registerSuperTools(boneMealTool, "bonemealtool", helper);
                registerSuperTools(superHoe, "superhoe", helper);
                registerSuperTools(superAxe, "superaxe", helper);
                registerSuperTools(superPickaxe, "superpickaxe", helper);
                registerSuperTools(superShovel, "supershovel", helper);
                registerSuperTools(superSword, "supersword", helper);
                registerSuperTools(itemCup, "itemcup", helper);
                registerSuperTools(specialCup, "specialcup", helper);
                registerSuperTools(superSickle, "supersickle", helper);
            }

        });
    }

    private static void registerItem(Item itemToRegister, String itemName, RegisterEvent.RegisterHelper<Item> registry){
        CreativeTabsRegistry.TOOLS_ITEMS.add(itemToRegister);
        registry.register(new ResourceLocation(Constants.modid, itemName), itemToRegister);
    }
    private static void registerSuperTools(Item itemToRegister, String itemName, RegisterEvent.RegisterHelper<Item> registry){
        CreativeTabsRegistry.SUPER_TOOLS_ITEMS.add(itemToRegister);
        registry.register(new ResourceLocation(Constants.modid, itemName), itemToRegister);
    }
    private static void registerArmorItem(Item itemToRegister, String itemName, RegisterEvent.RegisterHelper<Item> registry){
        CreativeTabsRegistry.ARMOR_ITEMS.add(itemToRegister);
        registry.register(new ResourceLocation(Constants.modid, itemName), itemToRegister);
    }
}

