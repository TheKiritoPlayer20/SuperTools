package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.ToolType;

public class Sword extends SwordItem {

    public Sword(IItemTier material, float speed) {
        super(material, 3, speed, new Properties().group(CreativeTabs.tools));
    }
}
