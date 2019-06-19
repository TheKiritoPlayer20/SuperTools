/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.CreativeTabs;

import me.Supervogel1.supertools.Registries.BlockRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsSuperAddonT1 extends CreativeTabs {

	public CreativeTabsSuperAddonT1() {
		super("supertoolsaddont1");	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockRegistry.cementblock);
	}

}
