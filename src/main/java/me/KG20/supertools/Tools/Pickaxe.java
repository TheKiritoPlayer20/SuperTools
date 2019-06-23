package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;

public class Pickaxe extends PickaxeItem {

    public Pickaxe(IItemTier material, float speed) {
        super(material, 1, speed, new Properties().group(CreativeTabs.tools).addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
    }

}
