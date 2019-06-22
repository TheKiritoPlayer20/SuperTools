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

    }



    }

