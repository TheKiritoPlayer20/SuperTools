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

public class SuperSword extends ItemSwordBasis {


	public SuperSword(EnumToolMaterialBasis material) {
		super(material);
		this.setMaxStackSize(1);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
	// parameters of PotionEffect are: id, amplifier, duration in ticks (20 = 1 second)
	target.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 1, 60));
	return bFull3D;
	}
}