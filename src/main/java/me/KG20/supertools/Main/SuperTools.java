package me.KG20.supertools.Main;

import com.mojang.logging.LogUtils;
import me.KG20.supertools.Config.SuperToolsConfig;
import me.KG20.supertools.Event.EventHandler;
import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import me.KG20.supertools.Init.RegisterTier;
import me.KG20.supertools.Proxy.ClientProxy;
import me.KG20.supertools.Proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;

@Mod(Constants.modid)
public class SuperTools {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public SuperTools(){
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().register(RegisterItems.class);
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
        proxy.construct();
        SuperToolsConfig.loadConfig(SuperToolsConfig.Server_Config, FMLPaths.CONFIGDIR.get().resolve("supertools.toml"));
        CreativeTabs.init();
    }
    
    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event){
        proxy.setup();
    }

    @SubscribeEvent
    public void ready(FMLLoadCompleteEvent event){
        new RegisterTier();
        proxy.complete();
    }



}
