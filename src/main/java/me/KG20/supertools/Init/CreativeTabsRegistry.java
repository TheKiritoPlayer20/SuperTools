package me.KG20.supertools.Init;

import com.mojang.datafixers.kinds.Const;
import me.KG20.supertools.Config.Config;
import me.KG20.supertools.Main.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Constants.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabsRegistry {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.modid);

    public static final List<Item> ARMOR_ITEMS = new ArrayList<>();
    public static final List<Item> TOOLS_ITEMS = new ArrayList<>();
    public static final List<Item> SUPER_TOOLS_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> ARMOR = TABS.register("armor",
            ()-> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.armor"))
                    .icon(() -> new ItemStack(RegisterItems.emeraldChestplate))
                    .displayItems((displayParams, output) ->
                        ARMOR_ITEMS.forEach(itemLike -> output.accept(new ItemStack(itemLike))))
                    .build()
    );

    public static RegistryObject<CreativeModeTab> SUPERTOOLS;

    public static void registerSuperToolsTab(){
        SUPERTOOLS = TABS.register("supertools",
                ()-> CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup.supertools"))
                        .icon(() -> new ItemStack(RegisterItems.specialCup))
                        .displayItems((displayParams, output) ->
                                SUPER_TOOLS_ITEMS.forEach(itemLike -> output.accept(new ItemStack(itemLike))))
                        .build()
        );
    }

    /*
    public static final RegistryObject<CreativeModeTab> SUPERTOOLS = TABS.register("supertools",
            ()-> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.supertools"))
                    .icon(() -> new ItemStack(RegisterItems.specialCup))
                    .displayItems((displayParams, output) ->
                            SUPER_TOOLS_ITEMS.forEach(itemLike -> output.accept(new ItemStack(itemLike))))
                    .build()
    );*/

    public static final RegistryObject<CreativeModeTab> TOOLS = TABS.register("tools",
            ()-> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tools"))
                    .icon(() -> new ItemStack(RegisterItems.quartzAxe))
                    .displayItems((displayParams, output) ->
                            TOOLS_ITEMS.forEach(itemLike -> output.accept(new ItemStack(itemLike))))
                    .build()
    );

}
