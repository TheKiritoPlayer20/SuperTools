package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Cups extends PickaxeItem {

    public Cups(IItemTier material, float speed) {
        super(material, 1, speed, new Properties().group(CreativeTabs.supertools)
                .addToolType(ToolType.PICKAXE, material.getHarvestLevel())
                .addToolType(ToolType.AXE, material.getHarvestLevel())
                .addToolType(ToolType.SHOVEL, material.getHarvestLevel()));
    }

}
