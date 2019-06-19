/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class Itemcup extends ItemPickaxeBasis {


	public Itemcup(EnumToolMaterialBasis material) {
		super(material); 
		this.setMaxStackSize(1);
	}
	public boolean hitEntity(ItemStack stack, EntityLivingBase living1, EntityLivingBase living2)
	{
	living1.setFire(5);
	living2.setFire(5);
	return true;
	}
	

}

