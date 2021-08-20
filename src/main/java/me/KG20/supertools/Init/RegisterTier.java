package me.KG20.supertools.Init;


import me.KG20.supertools.Main.Constants;
import me.KG20.supertools.Tools.BasisToolMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Constants.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterTier {

    public RegisterTier(){
        var gold = new ResourceLocation("gold");
        var wood = new ResourceLocation("wood");
        var stone = new ResourceLocation("stone");
        var iron = new ResourceLocation("iron");
        var diamond = new ResourceLocation("diamond");
        var netherite = new ResourceLocation("netherite");
        var quartz = new ResourceLocation("quartz");
        var obsidian = new ResourceLocation("obsidian");
        var emerald = new ResourceLocation("emerald");
        var lapis = new ResourceLocation("lapis");
        var redstone = new ResourceLocation("redstone");
        var supertools = new ResourceLocation("supertools");
        var itemcup = new ResourceLocation("itemcup");
        var specialcup = new ResourceLocation("specialcup");


        TierSortingRegistry.registerTier(BasisToolMaterial.quartz, quartz, List.of(redstone, iron), List.of(netherite, supertools, itemcup, specialcup));
        TierSortingRegistry.registerTier(BasisToolMaterial.obsidian, obsidian, List.of(redstone, iron), List.of(netherite, supertools, itemcup, specialcup));
        TierSortingRegistry.registerTier(BasisToolMaterial.emerald, emerald, List.of(redstone, iron), List.of(netherite, supertools, itemcup, specialcup));
        TierSortingRegistry.registerTier(BasisToolMaterial.lapis, lapis, List.of(wood, gold), List.of(iron, redstone));
        TierSortingRegistry.registerTier(BasisToolMaterial.redstone, redstone, List.of(stone, lapis), List.of(quartz, diamond, obsidian, emerald));
        TierSortingRegistry.registerTier(BasisToolMaterial.supertools, supertools, List.of(quartz,emerald, obsidian, diamond), List.of());
        TierSortingRegistry.registerTier(BasisToolMaterial.itemcup, itemcup, List.of(quartz,emerald, obsidian, diamond), List.of());
        TierSortingRegistry.registerTier(BasisToolMaterial.specialcup, specialcup, List.of(quartz,emerald, obsidian, diamond), List.of());
    }

}
