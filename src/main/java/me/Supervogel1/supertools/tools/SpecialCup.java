/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class SpecialCup extends ItemPickaxeBasis {
	


	public SpecialCup(EnumToolMaterialBasis material) {
		super(material);
		this.setMaxStackSize(1);
	}
	public

    @Override
	boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
	par1ItemStack.damageItem(1, par3EntityLivingBase);
	par2EntityLivingBase.addPotionEffect(
	new PotionEffect(Potion.getPotionById(20), 100, 5));

	return true;
	}

  
       

   	}