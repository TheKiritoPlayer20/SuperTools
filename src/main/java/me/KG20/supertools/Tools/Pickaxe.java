package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;

public class Pickaxe extends PickaxeItem {

    public Pickaxe(IItemTier material, float speed) {
        super(material, 1, speed, new Properties().tab(CreativeTabs.tools).addToolType(ToolType.PICKAXE, material.getLevel()));
    }

    public Pickaxe(IItemTier material, float speed, Properties properties) {
        super(material, 1, speed, properties.addToolType(ToolType.PICKAXE, material.getLevel()));
    }


}
