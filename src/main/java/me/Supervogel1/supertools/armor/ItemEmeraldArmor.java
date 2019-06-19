package me.Supervogel1.supertools.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemEmeraldArmor extends ItemArmor{

	public ItemEmeraldArmor(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, 0, equipmentSlotIn);
	}

	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (slot == EntityEquipmentSlot.HEAD){
			return "supertools:textures/models/armor/emerald_layer_1.png";
		} else if (slot == EntityEquipmentSlot.CHEST){
			return "supertools:textures/models/armor/emerald_layer_1.png";
		} else if (slot == EntityEquipmentSlot.FEET){
			return "supertools:textures/models/armor/emerald_layer_1.png";
		} else if (slot == EntityEquipmentSlot.LEGS){
			return "supertools:textures/models/armor/emerald_layer_2.png";
		} else {
			return null;
		}
	}
}
