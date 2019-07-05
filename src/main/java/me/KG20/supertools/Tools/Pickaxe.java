package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import me.KG20.supertools.Main.SuperTools;
import net.minecraft.advancements.Advancement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import org.omg.CORBA.SystemException;

import java.util.ArrayList;
import java.util.Random;

public class Pickaxe extends PickaxeItem {

    public Pickaxe(IItemTier material, float speed) {
        super(material, 1, speed, new Properties().group(CreativeTabs.tools).addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
    }

}
