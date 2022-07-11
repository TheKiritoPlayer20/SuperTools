package me.KG20.supertools.Init;

import me.KG20.supertools.Config.Config;
import me.KG20.supertools.CreativeTabs.CreativeTabArmor;
import me.KG20.supertools.CreativeTabs.CreativeTabSuperTools;
import me.KG20.supertools.CreativeTabs.CreativeTabTools;

public class CreativeTabs {

    public final static CreativeTabTools tools = new CreativeTabTools();
    public final static CreativeTabArmor armor = new CreativeTabArmor();
    public static CreativeTabSuperTools supertools;

    public static void init(){
        if(Config.enable_SuperTools.get()){
            supertools = new CreativeTabSuperTools();
        }
    }

}
