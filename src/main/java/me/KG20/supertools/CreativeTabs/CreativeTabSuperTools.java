package me.KG20.supertools.CreativeTabs;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTabSuperTools extends ItemGroup {

    public CreativeTabSuperTools(){
        super("supertools");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack createIcon(){
        return new ItemStack(Blocks.STONE);
    }

}
