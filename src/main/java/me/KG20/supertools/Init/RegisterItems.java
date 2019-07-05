package me.KG20.supertools.Init;

import me.KG20.supertools.Armor.BasisArmorMaterial;
import me.KG20.supertools.Armor.ItemArmor;
import me.KG20.supertools.Main.Constants;
import me.KG20.supertools.Tools.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterItems {

    public static final Hoe quartzHoe = new Hoe(BasisToolMaterial.quartz, -1F);
    public static final Axe quartzAxe = new Axe(BasisToolMaterial.quartz, -3.1F);
    public static final Pickaxe quartzPickaxe = new Pickaxe(BasisToolMaterial.quartz, -2.8F);
    public static final Shovel quartzShovel = new Shovel(BasisToolMaterial.quartz, -3F);
    public static final Sword quartzSword = new Sword(BasisToolMaterial.quartz, -2.4F);

    public static final Hoe emeraldHoe = new Hoe(BasisToolMaterial.emerald, -1F);
    public static final Axe emeraldAxe = new Axe(BasisToolMaterial.emerald, -3.1F);
    public static final Pickaxe emeraldPickaxe = new Pickaxe(BasisToolMaterial.emerald, -2.8F);
    public static final Shovel emeraldShovel = new Shovel(BasisToolMaterial.emerald, -3F);
    public static final Sword emeraldSword = new Sword(BasisToolMaterial.emerald, -2.4F);

    public static final Hoe obsidianHoe = new Hoe(BasisToolMaterial.obsidian, -1F);
    public static final Axe obsidianAxe = new Axe(BasisToolMaterial.obsidian, -3.1F);
    public static final Pickaxe obsidianPickaxe = new Pickaxe(BasisToolMaterial.obsidian, -2.8F);
    public static final Shovel obsidianShovel = new Shovel(BasisToolMaterial.obsidian, -3F);
    public static final Sword obsidianSword = new Sword(BasisToolMaterial.obsidian, -2.4F);

    public static final Hoe lapisHoe = new Hoe(BasisToolMaterial.lapis, -1F);
    public static final Axe lapisAxe = new Axe(BasisToolMaterial.lapis, -3.1F);
    public static final Pickaxe lapisPickaxe = new Pickaxe(BasisToolMaterial.lapis, -2.8F);
    public static final Shovel lapisShovel = new Shovel(BasisToolMaterial.lapis, -3F);
    public static final Sword lapisSword = new Sword(BasisToolMaterial.lapis, -2.4F);

    public static final Hoe redstoneHoe = new Hoe(BasisToolMaterial.redstone, -0.5F);
    public static final Axe redstoneAxe = new Axe(BasisToolMaterial.redstone, -2.6F);
    public static final Pickaxe redstonePickaxe = new Pickaxe(BasisToolMaterial.redstone, -2.3F);
    public static final Shovel redstoneShovel = new Shovel(BasisToolMaterial.redstone, -2.5F);
    public static final Sword redstoneSword = new Sword(BasisToolMaterial.redstone, -1.9F);

    public static final ItemArmor emeraldHelmet = new ItemArmor(BasisArmorMaterial.emerald, EquipmentSlotType.HEAD);
    public static final ItemArmor emeraldChestplate = new ItemArmor(BasisArmorMaterial.emerald, EquipmentSlotType.CHEST);
    public static final ItemArmor emeraldLeggings = new ItemArmor(BasisArmorMaterial.emerald, EquipmentSlotType.LEGS);
    public static final ItemArmor emeraldBoots = new ItemArmor(BasisArmorMaterial.emerald, EquipmentSlotType.FEET);

    public static final ItemArmor obsidianHelmet = new ItemArmor(BasisArmorMaterial.obsidian, EquipmentSlotType.HEAD);
    public static final ItemArmor obsidianChestplate = new ItemArmor(BasisArmorMaterial.obsidian, EquipmentSlotType.CHEST);
    public static final ItemArmor obsidianLeggings = new ItemArmor(BasisArmorMaterial.obsidian, EquipmentSlotType.LEGS);
    public static final ItemArmor obsidianBoots = new ItemArmor(BasisArmorMaterial.obsidian, EquipmentSlotType.FEET);

    public static final ItemArmor lapisHelmet = new ItemArmor(BasisArmorMaterial.lapis, EquipmentSlotType.HEAD);
    public static final ItemArmor lapisChestplate = new ItemArmor(BasisArmorMaterial.lapis, EquipmentSlotType.CHEST);
    public static final ItemArmor lapisLeggings = new ItemArmor(BasisArmorMaterial.lapis, EquipmentSlotType.LEGS);
    public static final ItemArmor lapisBoots = new ItemArmor(BasisArmorMaterial.lapis, EquipmentSlotType.FEET);

    public static final ItemArmor quartzHelmet = new ItemArmor(BasisArmorMaterial.quartz, EquipmentSlotType.HEAD);
    public static final ItemArmor quartzChestplate = new ItemArmor(BasisArmorMaterial.quartz, EquipmentSlotType.CHEST);
    public static final ItemArmor quartzLeggings = new ItemArmor(BasisArmorMaterial.quartz, EquipmentSlotType.LEGS);
    public static final ItemArmor quartzBoots = new ItemArmor(BasisArmorMaterial.quartz, EquipmentSlotType.FEET);

    public static final BonemealTool boneMealTool = new BonemealTool();
    public static final SuperHoe superHoe = new SuperHoe(BasisToolMaterial.supertools, -1F, new Item.Properties().group(CreativeTabs.supertools));
    public static final SuperAxe superAxe = new SuperAxe(BasisToolMaterial.supertools, -3.1F, new Item.Properties().group(CreativeTabs.supertools));
    public static final SuperPickaxe superPickaxe = new SuperPickaxe(BasisToolMaterial.supertools, -2.8F, new Item.Properties().group(CreativeTabs.supertools));
    public static final SuperShovel superShovel = new SuperShovel(BasisToolMaterial.supertools, -3F, new Item.Properties().group(CreativeTabs.supertools));
    public static final SuperSword superSword = new SuperSword(BasisToolMaterial.supertools, -2.4F, new Item.Properties().group(CreativeTabs.supertools));
    public static final Cups itemCup = new Cups(BasisToolMaterial.itemcup, -2.8F);
    public static final Cups specialCup = new Cups(BasisToolMaterial.specialcup, -2.8F);


    @SubscribeEvent
    public static void register(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        quartzHoe.setRegistryName(Constants.modid, "quartzhoe");
        quartzAxe.setRegistryName(Constants.modid, "quartzaxe");
        quartzPickaxe.setRegistryName(Constants.modid, "quartzpickaxe");
        quartzShovel.setRegistryName(Constants.modid, "quartzshovel");
        quartzSword.setRegistryName(Constants.modid, "quartzsword");
        registry.registerAll(quartzHoe,quartzAxe,quartzPickaxe,quartzShovel,quartzSword);

        emeraldHoe.setRegistryName(Constants.modid, "emeraldhoe");
        emeraldAxe.setRegistryName(Constants.modid, "emeraldaxe");
        emeraldPickaxe.setRegistryName(Constants.modid, "emeraldpickaxe");
        emeraldShovel.setRegistryName(Constants.modid, "emeraldshovel");
        emeraldSword.setRegistryName(Constants.modid, "emeraldsword");
        registry.registerAll(emeraldHoe,emeraldAxe,emeraldPickaxe,emeraldShovel,emeraldSword);

        obsidianHoe.setRegistryName(Constants.modid, "obsidianhoe");
        obsidianAxe.setRegistryName(Constants.modid, "obsidianaxe");
        obsidianPickaxe.setRegistryName(Constants.modid, "obsidianpickaxe");
        obsidianShovel.setRegistryName(Constants.modid, "obsidianshovel");
        obsidianSword.setRegistryName(Constants.modid, "obsidiansword");
        registry.registerAll(obsidianHoe,obsidianAxe,obsidianPickaxe,obsidianShovel,obsidianSword);

        lapisHoe.setRegistryName(Constants.modid, "lapishoe");
        lapisAxe.setRegistryName(Constants.modid, "lapisaxe");
        lapisPickaxe.setRegistryName(Constants.modid, "lapispickaxe");
        lapisShovel.setRegistryName(Constants.modid, "lapisshovel");
        lapisSword.setRegistryName(Constants.modid, "lapissword");
        registry.registerAll(lapisHoe,lapisAxe,lapisPickaxe,lapisShovel,lapisSword);

        redstoneHoe.setRegistryName(Constants.modid, "redstonehoe");
        redstoneAxe.setRegistryName(Constants.modid, "redstoneaxe");
        redstonePickaxe.setRegistryName(Constants.modid, "redstonepickaxe");
        redstoneShovel.setRegistryName(Constants.modid, "redstoneshovel");
        redstoneSword.setRegistryName(Constants.modid, "redstonesword");
        registry.registerAll(redstoneHoe,redstoneAxe,redstonePickaxe,redstoneShovel,redstoneSword);

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

        boneMealTool.setRegistryName(Constants.modid, "bonemealtool");
        superHoe.setRegistryName(Constants.modid, "superhoe");
        superAxe.setRegistryName(Constants.modid, "superaxe");
        superPickaxe.setRegistryName(Constants.modid, "superpickaxe");
        superShovel.setRegistryName(Constants.modid, "supershovel");
        superSword.setRegistryName(Constants.modid, "supersword");
        itemCup.setRegistryName(Constants.modid, "itemcup");
        specialCup.setRegistryName(Constants.modid, "specialcup");
        registry.registerAll(boneMealTool,superHoe,superAxe,superPickaxe,superShovel,superSword,itemCup,specialCup);


    }



    }

