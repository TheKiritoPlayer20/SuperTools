package me.KG20.supertools.CreativeTabs;

import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTabArmor extends ItemGroup {

    public CreativeTabArmor(){
        super("armor");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack createIcon(){
        return new ItemStack(RegisterItems.emeraldChestplate);
    }
}
