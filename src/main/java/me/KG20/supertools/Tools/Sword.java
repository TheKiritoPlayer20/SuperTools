package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class Sword extends SwordItem {

    public Sword(Tier material, float speed) {
        super(material, 3, speed, new Properties().tab(CreativeTabs.tools));
    }

    public Sword(Tier material, float speed, Properties properties) {
        super(material, 3, speed, properties);
    }
}
