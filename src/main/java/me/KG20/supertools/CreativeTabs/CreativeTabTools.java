package me.KG20.supertools.CreativeTabs;

import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTabTools extends CreativeModeTab {

    public CreativeTabTools(){
        super("tools");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack makeIcon(){
        return new ItemStack(RegisterItems.quartzAxe);
    }

}
