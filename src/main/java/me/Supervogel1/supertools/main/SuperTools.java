/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.main;

import me.Supervogel1.supertools.CreativeTabs.CreativeTabsSuperAddonT1;
import me.Supervogel1.supertools.CreativeTabs.CreativeTabsSuperTools;
import me.Supervogel1.supertools.CreativeTabs.CreativeTabsSuperToolsArmor;
import me.Supervogel1.supertools.CreativeTabs.CreativeTabsTools;
import me.Supervogel1.supertools.Registries.BlockRecipes;
import me.Supervogel1.supertools.Registries.BlockRegistry;
import me.Supervogel1.supertools.Registries.ItemRecipes;
import me.Supervogel1.supertools.Registries.ItemRegistry;
import me.Supervogel1.supertools.proxys.SuperToolsProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid=SuperTools.MODID, name="SuperTools", version=SuperTools.VERSION)
public class SuperTools {

	public static final String MODID = "supertools";
	public static final String VERSION = "1.3";


	@SidedProxy(clientSide = "me.Supervogel1.supertools.proxys.SuperToolsClientProxy", serverSide = "me.Supervogel1.supertools.proxys.SuperToolsProxy")
	public static SuperToolsProxy proxy = new SuperToolsProxy();
	
	public static CreativeTabs tools;
	public static CreativeTabs supertools;
	public static CreativeTabs Armor;
	public static CreativeTabs SuperAddonT1;



	
	@Mod.Instance(MODID)
	public static SuperTools Instance = new SuperTools();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {


	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		tools = new CreativeTabsTools();
		supertools = new CreativeTabsSuperTools();
		Armor = new CreativeTabsSuperToolsArmor();
		SuperAddonT1 = new CreativeTabsSuperAddonT1();

		
		//Init Regisitry only before Recipes

		//Registry
		new BlockRegistry();
		new ItemRegistry();
		
		
		//Recipes
		new BlockRecipes();
		new ItemRecipes();

		proxy.registerRenderers();
		
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

}