package me.KG20.supertools.Main;

import me.KG20.supertools.Config.SuperToolsConfig;
import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Proxy.ClientProxy;
import me.KG20.supertools.Proxy.CommonProxy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Constants.modid)
public class SuperTools
{

    private static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);


    public SuperTools(){
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
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
        proxy.complete();
    }


}
