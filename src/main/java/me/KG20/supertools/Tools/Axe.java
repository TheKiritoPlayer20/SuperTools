package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class Axe extends AxeItem {

    public Axe(IItemTier material) {
        super(material, 6, -3.1F, new Properties().group(CreativeTabs.tools).addToolType(ToolType.AXE, material.getHarvestLevel()));
    }

}
