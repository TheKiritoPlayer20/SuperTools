package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraftforge.common.ForgeConfigSpec;

public class Hoe extends HoeItem {


    public Hoe(IItemTier material, ForgeConfigSpec.DoubleValue attackDamage, float speed) {
        super(material, attackDamage.get().intValue(), speed, new Properties().group(CreativeTabs.tools));
    }

    public Hoe(IItemTier material, ForgeConfigSpec.DoubleValue attackDamage, float speed, Properties properties) {
        super(material, attackDamage.get().intValue(), speed, properties);
    }

}
