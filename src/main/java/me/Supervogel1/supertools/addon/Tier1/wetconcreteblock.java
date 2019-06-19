/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.addon.Tier1;

import java.util.Random;

import me.Supervogel1.supertools.Registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class wetconcreteblock extends Block {

	public static Block block;
	
	public wetconcreteblock() {
		super(Material.ROCK);
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockRegistry.wetconcreteblock);
    }
}
