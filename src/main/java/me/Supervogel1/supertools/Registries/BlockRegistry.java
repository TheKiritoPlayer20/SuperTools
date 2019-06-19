/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.Registries;

import me.Supervogel1.supertools.addon.Tier1.CementBlock;
import me.Supervogel1.supertools.addon.Tier1.ConcreteBlock;
import me.Supervogel1.supertools.addon.Tier1.wetconcreteblock;
import me.Supervogel1.supertools.blocks.blocks;
import me.Supervogel1.supertools.main.SuperTools;
import me.Supervogel1.supertools.main.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

	public static Block cementblock;
	public static Block wetconcreteblock;
	public static Block concreteblock;
	public static Block blocktest;
	//public static Block concretefurnace; noch nicht fertig!
	//public static Block litconcretefurnace; noch nicht fertig!

    public BlockRegistry() {
        init();
        register();
    }

    private  void init(){
    	cementblock = new CementBlock().setHardness(4F).setCreativeTab(SuperTools.SuperAddonT1);
    	Utils.setNames(cementblock, "cementblock");
    	wetconcreteblock = new wetconcreteblock().setHardness(1.5F).setCreativeTab(SuperTools.SuperAddonT1);
    	Utils.setNames(wetconcreteblock, "wetconcreteblock");
    	concreteblock = new ConcreteBlock().setHardness(4.5F).setCreativeTab(SuperTools.SuperAddonT1);
    	Utils.setNames(concreteblock, "concreteblock");
    	//concretefurnace = new ConcreteFurnace(false).setHardness(3.5F).setCreativeTab(SuperTools.SuperAddonT1);
    	//Utils.setNames(concretefurnace, "concretefurnace");
    	//litconcretefurnace = new ConcreteFurnace(true).setHardness(3.5F).setCreativeTab(SuperTools.SuperAddonT1);
    	//Utils.setNames(litconcretefurnace, "litconcretefurnace");
		blocktest = new blocks().setHardness(4F).setCreativeTab(SuperTools.SuperAddonT1);
		Utils.setNames(blocktest, "blocktest");

    }

    private void register(){
		ForgeRegistries.BLOCKS.register(cementblock);
		ForgeRegistries.BLOCKS.register(wetconcreteblock);
		ForgeRegistries.BLOCKS.register(concreteblock);
		ForgeRegistries.BLOCKS.register(blocktest);
    	//registerBlock(concretefurnace);
    	//registerBlock(litconcretefurnace);
    }

    
}