package me.Supervogel1.supertools.CreativeTabs;

import me.Supervogel1.supertools.Registries.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsSuperToolsArmor  extends CreativeTabs {

		public CreativeTabsSuperToolsArmor() {
			super("Armor");
		}

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.EmeraldChestplate);
		}

	}

