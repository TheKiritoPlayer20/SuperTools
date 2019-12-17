package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ToolType;

public class Sword extends SwordItem {

    public Sword(IItemTier material, float speed) {
        super(material, 3, speed, new Properties().group(CreativeTabs.tools));
    }

    public Sword(IItemTier material, float speed, Properties properties) {
        super(material, 3, speed, properties);
    }
}
