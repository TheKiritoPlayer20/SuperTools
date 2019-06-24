package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraftforge.common.ToolType;

public class Axe extends AxeItem {

    public Axe(IItemTier material, float speed) {
        super(material, 6, speed, new Properties().group(CreativeTabs.tools).addToolType(ToolType.AXE, material.getHarvestLevel()));
    }


}
