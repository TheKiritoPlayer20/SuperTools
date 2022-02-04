package me.KG20.supertools.Init;

import me.KG20.supertools.Armor.BasisArmorMaterial;
import me.KG20.supertools.Armor.ItemArmor;
import me.KG20.supertools.Config.Config;
import me.KG20.supertools.Main.Constants;
import me.KG20.supertools.Tools.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterItems {

    public static final Sickle woodenSickle = new Sickle(new Item.Properties().durability(59).tab(CreativeTabs.tools));
    public static final Sickle stoneSickle = new Sickle(new Item.Properties().durability(131).tab(CreativeTabs.tools));
    public static final Sickle ironSickle = new Sickle(new Item.Properties().durability(250).tab(CreativeTabs.tools));
    public static final Sickle goldenSickle = new Sickle(new Item.Properties().durability(32).tab(CreativeTabs.tools));
    public static final Sickle diamondSickle = new Sickle(new Item.Properties().durability(1561).tab(CreativeTabs.tools));
    public static final Sickle netheriteSickle = new Sickle(new Item.Properties().durability(2031).tab(CreativeTabs.tools).fireResistant());

    public static final Hoe quartzHoe = new Hoe(BasisToolMaterial.quartz, -3, -1F);
    public static final Axe quartzAxe = new Axe(BasisToolMaterial.quartz, -3.1F);
    public static final Pickaxe quartzPickaxe = new Pickaxe(BasisToolMaterial.quartz, -2.8F);
    public static final Shovel quartzShovel = new Shovel(BasisToolMaterial.quartz, -3F);
    public static final Sword quartzSword = new Sword(BasisToolMaterial.quartz, -2.4F);
    public static final Sickle quartzSickle = new Sickle(new Item.Properties().durability(Config.durability_Quartz.get()).tab(CreativeTabs.tools));

    public static final Hoe copperHoe = new Hoe(BasisToolMaterial.copper, -3, -1F);
    public static final Axe copperAxe = new Axe(BasisToolMaterial.copper, -3.1F);
    public static final Pickaxe copperPickaxe = new Pickaxe(BasisToolMaterial.copper, -2.8F);
    public static final Shovel copperShovel = new Shovel(BasisToolMaterial.copper, -3F);
    public static final Sword copperSword = new Sword(BasisToolMaterial.copper, -2.4F);
    public static final Sickle copperSickle = new Sickle(new Item.Properties().durability(Config.durability_Copper.get()).tab(CreativeTabs.tools));

    public static final Hoe emeraldHoe = new Hoe(BasisToolMaterial.emerald, -3, -1F);
    public static final Axe emeraldAxe = new Axe(BasisToolMaterial.emerald, -3.1F);
    public static final Pickaxe emeraldPickaxe = new Pickaxe(BasisToolMaterial.emerald, -2.8F);
    public static final Shovel emeraldShovel = new Shovel(BasisToolMaterial.emerald, -3F);
    public static final Sword emeraldSword = new Sword(BasisToolMaterial.emerald, -2.4F);
    public static final Sickle emeraldSickle = new Sickle(new Item.Properties().durability(Config.durability_Emerald.get()).tab(CreativeTabs.tools));

    public static final Hoe obsidianHoe = new Hoe(BasisToolMaterial.obsidian, -3, -1F);
    public static final Axe obsidianAxe = new Axe(BasisToolMaterial.obsidian, -3.1F);
    public static final Pickaxe obsidianPickaxe = new Pickaxe(BasisToolMaterial.obsidian, -2.8F);
    public static final Shovel obsidianShovel = new Shovel(BasisToolMaterial.obsidian, -3F);
    public static final Sword obsidianSword = new Sword(BasisToolMaterial.obsidian, -2.4F);
    public static final Sickle obsidianSickle = new Sickle(new Item.Properties().durability(Config.durability_Obsidian.get()).tab(CreativeTabs.tools));

    public static final Hoe lapisHoe = new Hoe(BasisToolMaterial.lapis, -3, -1F);
    public static final Axe lapisAxe = new Axe(BasisToolMaterial.lapis, -3.1F);
    public static final Pickaxe lapisPickaxe = new Pickaxe(BasisToolMaterial.lapis, -2.8F);
    public static final Shovel lapisShovel = new Shovel(BasisToolMaterial.lapis, -3F);
    public static final Sword lapisSword = new Sword(BasisToolMaterial.lapis, -2.4F);
    public static final Sickle lapisSickle = new Sickle(new Item.Properties().durability(Config.durability_Lapis.get()).tab(CreativeTabs.tools));

    public static final Hoe redstoneHoe = new Hoe(BasisToolMaterial.redstone, -3, -0.5F);
    public static final Axe redstoneAxe = new Axe(BasisToolMaterial.redstone, -2.6F);
    public static final Pickaxe redstonePickaxe = new Pickaxe(BasisToolMaterial.redstone, -2.3F);
    public static final Shovel redstoneShovel = new Shovel(BasisToolMaterial.redstone, -2.5F);
    public static final Sword redstoneSword = new Sword(BasisToolMaterial.redstone, -1.9F);
    public static final Sickle redstoneSickle = new Sickle(new Item.Properties().durability(Config.durability_Redstone.get()).tab(CreativeTabs.tools));

    public static final ItemArmor emeraldHelmet = new ItemArmor(BasisArmorMaterial.emerald, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.armor));
    public static final ItemArmor emeraldChestplate = new ItemArmor(BasisArmorMaterial.emerald, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.armor));
    public static final ItemArmor emeraldLeggings = new ItemArmor(BasisArmorMaterial.emerald, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.armor));
    public static final ItemArmor emeraldBoots = new ItemArmor(BasisArmorMaterial.emerald, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.armor));

    public static final ItemArmor obsidianHelmet = new ItemArmor(BasisArmorMaterial.obsidian, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.armor).fireResistant());
    public static final ItemArmor obsidianChestplate = new ItemArmor(BasisArmorMaterial.obsidian, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.armor).fireResistant());
    public static final ItemArmor obsidianLeggings = new ItemArmor(BasisArmorMaterial.obsidian, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.armor).fireResistant());
    public static final ItemArmor obsidianBoots = new ItemArmor(BasisArmorMaterial.obsidian, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.armor).fireResistant());

    public static final ItemArmor lapisHelmet = new ItemArmor(BasisArmorMaterial.lapis, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.armor));
    public static final ItemArmor lapisChestplate = new ItemArmor(BasisArmorMaterial.lapis, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.armor));
    public static final ItemArmor lapisLeggings = new ItemArmor(BasisArmorMaterial.lapis, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.armor));
    public static final ItemArmor lapisBoots = new ItemArmor(BasisArmorMaterial.lapis, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.armor));

    public static final ItemArmor quartzHelmet = new ItemArmor(BasisArmorMaterial.quartz, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.armor).fireResistant());
    public static final ItemArmor quartzChestplate = new ItemArmor(BasisArmorMaterial.quartz, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.armor).fireResistant());
    public static final ItemArmor quartzLeggings = new ItemArmor(BasisArmorMaterial.quartz, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.armor).fireResistant());
    public static final ItemArmor quartzBoots = new ItemArmor(BasisArmorMaterial.quartz, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.armor).fireResistant());

    public static final ItemArmor copperHelmet = new ItemArmor(BasisArmorMaterial.copper, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.armor));
    public static final ItemArmor copperChestplate = new ItemArmor(BasisArmorMaterial.copper, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.armor));
    public static final ItemArmor copperLeggings = new ItemArmor(BasisArmorMaterial.copper, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.armor));
    public static final ItemArmor copperBoots = new ItemArmor(BasisArmorMaterial.copper, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.armor));

    public static final BonemealTool boneMealTool = new BonemealTool();
    public static final Hoe superHoe = new Hoe(BasisToolMaterial.supertools, -3, -1F, new Item.Properties().tab(CreativeTabs.supertools));
    public static final Axe superAxe = new Axe(BasisToolMaterial.supertools, -3.1F, new Item.Properties().tab(CreativeTabs.supertools));
    public static final Pickaxe superPickaxe = new Pickaxe(BasisToolMaterial.supertools, -2.8F, new Item.Properties().tab(CreativeTabs.supertools));
    public static final Shovel superShovel = new Shovel(BasisToolMaterial.supertools, -3F, new Item.Properties().tab(CreativeTabs.supertools));
    public static final Sword superSword = new Sword(BasisToolMaterial.supertools, -2.4F, new Item.Properties().tab(CreativeTabs.supertools));
    public static final Cups itemCup = new Cups(BasisToolMaterial.itemcup, -2.8F);
    public static final Cups specialCup = new Cups(BasisToolMaterial.specialcup, -2.8F);
    public static final Sickle superSickle = new Sickle(new Item.Properties().durability(Config.durability_SuperTools.get()).tab(CreativeTabs.supertools));


    @SubscribeEvent
    public static void register(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        woodenSickle.setRegistryName(Constants.modid, "woodensickle");
        stoneSickle.setRegistryName(Constants.modid, "stonesickle");
        ironSickle.setRegistryName(Constants.modid, "ironsickle");
        goldenSickle.setRegistryName(Constants.modid, "goldensickle");
        diamondSickle.setRegistryName(Constants.modid, "diamondsickle");
        netheriteSickle.setRegistryName(Constants.modid, "netheritesickle");
        registry.registerAll(woodenSickle,stoneSickle,ironSickle,goldenSickle,diamondSickle,netheriteSickle);

        quartzHoe.setRegistryName(Constants.modid, "quartzhoe");
        quartzAxe.setRegistryName(Constants.modid, "quartzaxe");
        quartzPickaxe.setRegistryName(Constants.modid, "quartzpickaxe");
        quartzShovel.setRegistryName(Constants.modid, "quartzshovel");
        quartzSword.setRegistryName(Constants.modid, "quartzsword");
        quartzSickle.setRegistryName(Constants.modid, "quartzsickle");
        registry.registerAll(quartzHoe,quartzAxe,quartzPickaxe,quartzShovel,quartzSword,quartzSickle);

        copperHoe.setRegistryName(Constants.modid, "copperhoe");
        copperAxe.setRegistryName(Constants.modid, "copperaxe");
        copperPickaxe.setRegistryName(Constants.modid, "copperpickaxe");
        copperShovel.setRegistryName(Constants.modid, "coppershovel");
        copperSword.setRegistryName(Constants.modid, "coppersword");
        copperSickle.setRegistryName(Constants.modid, "coppersickle");
        registry.registerAll(copperHoe,copperAxe,copperPickaxe,copperShovel,copperSword,copperSickle);

        emeraldHoe.setRegistryName(Constants.modid, "emeraldhoe");
        emeraldAxe.setRegistryName(Constants.modid, "emeraldaxe");
        emeraldPickaxe.setRegistryName(Constants.modid, "emeraldpickaxe");
        emeraldShovel.setRegistryName(Constants.modid, "emeraldshovel");
        emeraldSword.setRegistryName(Constants.modid, "emeraldsword");
        emeraldSickle.setRegistryName(Constants.modid, "emeraldsickle");
        registry.registerAll(emeraldHoe,emeraldAxe,emeraldPickaxe,emeraldShovel,emeraldSword,emeraldSickle);

        obsidianHoe.setRegistryName(Constants.modid, "obsidianhoe");
        obsidianAxe.setRegistryName(Constants.modid, "obsidianaxe");
        obsidianPickaxe.setRegistryName(Constants.modid, "obsidianpickaxe");
        obsidianShovel.setRegistryName(Constants.modid, "obsidianshovel");
        obsidianSword.setRegistryName(Constants.modid, "obsidiansword");
        obsidianSickle.setRegistryName(Constants.modid, "obsidiansickle");
        registry.registerAll(obsidianHoe,obsidianAxe,obsidianPickaxe,obsidianShovel,obsidianSword,obsidianSickle);

        lapisHoe.setRegistryName(Constants.modid, "lapishoe");
        lapisAxe.setRegistryName(Constants.modid, "lapisaxe");
        lapisPickaxe.setRegistryName(Constants.modid, "lapispickaxe");
        lapisShovel.setRegistryName(Constants.modid, "lapisshovel");
        lapisSword.setRegistryName(Constants.modid, "lapissword");
        lapisSickle.setRegistryName(Constants.modid, "lapissickle");
        registry.registerAll(lapisHoe,lapisAxe,lapisPickaxe,lapisShovel,lapisSword,lapisSickle);

        redstoneHoe.setRegistryName(Constants.modid, "redstonehoe");
        redstoneAxe.setRegistryName(Constants.modid, "redstoneaxe");
        redstonePickaxe.setRegistryName(Constants.modid, "redstonepickaxe");
        redstoneShovel.setRegistryName(Constants.modid, "redstoneshovel");
        redstoneSword.setRegistryName(Constants.modid, "redstonesword");
        redstoneSickle.setRegistryName(Constants.modid, "redstonesickle");
        registry.registerAll(redstoneHoe,redstoneAxe,redstonePickaxe,redstoneShovel,redstoneSword,redstoneSickle);

        emeraldHelmet.setRegistryName(Constants.modid, "emeraldhelmet");
        emeraldChestplate.setRegistryName(Constants.modid, "emeraldchestplate");
        emeraldLeggings.setRegistryName(Constants.modid, "emeraldleggings");
        emeraldBoots.setRegistryName(Constants.modid, "emeraldboots");
        registry.registerAll(emeraldHelmet,emeraldChestplate,emeraldLeggings,emeraldBoots);

        obsidianHelmet.setRegistryName(Constants.modid, "obsidianhelmet");
        obsidianChestplate.setRegistryName(Constants.modid, "obsidianchestplate");
        obsidianLeggings.setRegistryName(Constants.modid, "obsidianleggings");
        obsidianBoots.setRegistryName(Constants.modid, "obsidianboots");
        registry.registerAll(obsidianHelmet,obsidianChestplate,obsidianLeggings,obsidianBoots);

        lapisHelmet.setRegistryName(Constants.modid, "lapishelmet");
        lapisChestplate.setRegistryName(Constants.modid, "lapischestplate");
        lapisLeggings.setRegistryName(Constants.modid, "lapisleggings");
        lapisBoots.setRegistryName(Constants.modid, "lapisboots");
        registry.registerAll(lapisHelmet,lapisChestplate,lapisLeggings,lapisBoots);

        quartzHelmet.setRegistryName(Constants.modid, "quartzhelmet");
        quartzChestplate.setRegistryName(Constants.modid, "quartzchestplate");
        quartzLeggings.setRegistryName(Constants.modid, "quartzleggings");
        quartzBoots.setRegistryName(Constants.modid, "quartzboots");
        registry.registerAll(quartzHelmet,quartzChestplate,quartzLeggings,quartzBoots);

        copperHelmet.setRegistryName(Constants.modid, "copperhelmet");
        copperChestplate.setRegistryName(Constants.modid, "copperchestplate");
        copperLeggings.setRegistryName(Constants.modid, "copperleggings");
        copperBoots.setRegistryName(Constants.modid, "copperboots");
        registry.registerAll(copperHelmet,copperChestplate,copperLeggings,copperBoots);

        if(Config.enable_SuperTools.get()){
            boneMealTool.setRegistryName(Constants.modid, "bonemealtool");
            superHoe.setRegistryName(Constants.modid, "superhoe");
            superAxe.setRegistryName(Constants.modid, "superaxe");
            superPickaxe.setRegistryName(Constants.modid, "superpickaxe");
            superShovel.setRegistryName(Constants.modid, "supershovel");
            superSword.setRegistryName(Constants.modid, "supersword");
            itemCup.setRegistryName(Constants.modid, "itemcup");
            specialCup.setRegistryName(Constants.modid, "specialcup");
            superSickle.setRegistryName(Constants.modid, "supersickle");
            registry.registerAll(boneMealTool,superHoe,superAxe,superPickaxe,superShovel,superSword,itemCup,specialCup,superSickle);
        }
    }



    }

