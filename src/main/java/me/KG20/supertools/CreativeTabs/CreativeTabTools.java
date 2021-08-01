package me.KG20.supertools.CreativeTabs;

import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTabTools extends ItemGroup {

    public CreativeTabTools(){
        super("tools");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack makeIcon(){
        return new ItemStack(RegisterItems.quartzAxe);
    }

}
