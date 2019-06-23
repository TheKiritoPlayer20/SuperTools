package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.ToolType;

public class Shovel extends ShovelItem {

    public Shovel(IItemTier material, float speed) {
        super(material, 1.5F, speed, new Properties().group(CreativeTabs.tools).addToolType(ToolType.SHOVEL, material.getHarvestLevel()));
    }

}
