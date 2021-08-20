package me.KG20.supertools.CreativeTabs;

import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTabArmor extends CreativeModeTab {

    public CreativeTabArmor(){
        super("armor");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack makeIcon(){
        return new ItemStack(RegisterItems.emeraldChestplate);
    }
}
