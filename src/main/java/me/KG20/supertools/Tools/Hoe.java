package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;

public class Hoe extends HoeItem {

    public Hoe(IItemTier material, float speed) {
        super(material, speed, new Properties().group(CreativeTabs.tools));
    }
}
