package me.KG20.supertools.Init;

import me.KG20.supertools.Main.Constants;
import me.KG20.supertools.Tools.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.modid, bus = Bus.MOD)
public class RegisterItems {

    public static final Hoe quartzHoe = new Hoe(BasisToolMaterial.quartz);
    public static final Axe quartzAxe = new Axe(BasisToolMaterial.quartz);
    public static final Pickaxe quartzPickaxe = new Pickaxe(BasisToolMaterial.quartz);
    public static final Shovel quartzShovel = new Shovel(BasisToolMaterial.quartz);
    public static final Sword quartzSword = new Sword(BasisToolMaterial.quartz);

    public static final Hoe emeraldHoe = new Hoe(BasisToolMaterial.emerald);
    public static final Axe emeraldAxe = new Axe(BasisToolMaterial.emerald);
    public static final Pickaxe emeraldPickaxe = new Pickaxe(BasisToolMaterial.emerald);
    public static final Shovel emeraldShovel = new Shovel(BasisToolMaterial.emerald);
    public static final Sword emeraldSword = new Sword(BasisToolMaterial.emerald);

    public static final Hoe obsidianHoe = new Hoe(BasisToolMaterial.obsidian);
    public static final Axe obsidianAxe = new Axe(BasisToolMaterial.obsidian);
    public static final Pickaxe obsidianPickaxe = new Pickaxe(BasisToolMaterial.obsidian);
    public static final Shovel obsidianShovel = new Shovel(BasisToolMaterial.obsidian);
    public static final Sword obsidianSword = new Sword(BasisToolMaterial.obsidian);

    public static final Hoe lapisHoe = new Hoe(BasisToolMaterial.lapis);
    public static final Axe lapisAxe = new Axe(BasisToolMaterial.lapis);
    public static final Pickaxe lapisPickaxe = new Pickaxe(BasisToolMaterial.lapis);
    public static final Shovel lapisShovel = new Shovel(BasisToolMaterial.lapis);
    public static final Sword lapisSword = new Sword(BasisToolMaterial.lapis);

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

    }



    }

