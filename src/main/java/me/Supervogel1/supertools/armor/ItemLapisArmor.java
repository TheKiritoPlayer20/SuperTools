/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.armor;

import me.Supervogel1.supertools.main.SuperTools;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemLapisArmor extends ItemArmor{

	public ItemLapisArmor(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, 0, equipmentSlotIn);
	}

	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (slot == EntityEquipmentSlot.HEAD){
			return "supertools:textures/models/armor/lapis_layer_1.png";
		} else if (slot == EntityEquipmentSlot.CHEST)  {
			return "supertools:textures/models/armor/lapis_layer_1.png";
		} else if (slot == EntityEquipmentSlot.FEET){
			return "supertools:textures/models/armor/lapis_layer_1.png";
		} else if (slot == EntityEquipmentSlot.LEGS){
			return "supertools:textures/models/armor/lapis_layer_2.png";
		} else {
			return null;
		}
	}
}

