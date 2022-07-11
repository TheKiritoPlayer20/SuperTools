package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class Shovel extends ShovelItem {

    private final TagKey<Block> blocks =  BlockTags.MINEABLE_WITH_SHOVEL;

    public Shovel(Tier material, float speed) {
        super(material, 1.5F, speed, new Properties().tab(CreativeTabs.tools));
    }

    public Shovel(Tier material, float speed, Properties properties) {
        super(material, 1.5F, speed, properties);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(blocks) && net.minecraftforge.common.TierSortingRegistry.isCorrectTierForDrops(getTier(), state);
    }
}
