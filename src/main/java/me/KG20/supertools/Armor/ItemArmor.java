package me.KG20.supertools.Armor;

import me.KG20.supertools.Init.CreativeTabs;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;

public class ItemArmor extends ArmorItem {


    public ItemArmor(IArmorMaterial materialIn, EquipmentSlotType slots) {
        super(materialIn, slots, new Properties().group(CreativeTabs.armor));
    }
}
