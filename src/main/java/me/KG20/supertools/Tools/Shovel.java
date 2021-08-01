package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.ToolType;

public class Shovel extends ShovelItem {

    public Shovel(IItemTier material, float speed) {
        super(material, 1.5F, speed, new Properties().tab(CreativeTabs.tools).addToolType(ToolType.SHOVEL, material.getLevel()));
    }

    public Shovel(IItemTier material, float speed, Properties properties) {
        super(material, 1.5F, speed, properties.addToolType(ToolType.SHOVEL, material.getLevel()));
    }
}
