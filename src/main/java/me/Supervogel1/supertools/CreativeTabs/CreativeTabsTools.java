/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.CreativeTabs;

import me.Supervogel1.supertools.Registries.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsTools extends CreativeTabs {

	public CreativeTabsTools() {
		super("Tools");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemRegistry.QuartzAxe);
	}

}
