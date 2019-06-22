package me.KG20.supertools.Main;

import me.KG20.supertools.CreativeTabs.CreativeTabArmor;
import me.KG20.supertools.CreativeTabs.CreativeTabSuperTools;
import me.KG20.supertools.CreativeTabs.CreativeTabTools;
import me.KG20.supertools.proxy.ClientProxy;
import me.KG20.supertools.proxy.CommonProxy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.modid)
public class SuperTools
{

    public static CreativeTabTools tools;
    public static CreativeTabArmor armor;
    public static CreativeTabSuperTools supertools;


    private static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);


    public SuperTools(){
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        proxy.construct();
    }



    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event){
        proxy.setup();
        tools = new CreativeTabTools();
        armor = new CreativeTabArmor();
        supertools = new CreativeTabSuperTools();
    }

    @SubscribeEvent
    public void ready(FMLLoadCompleteEvent event){
        proxy.complete();
    }


}
