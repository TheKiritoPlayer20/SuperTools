package me.KG20.supertools.Tools;


import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public class BasisToolMaterial {

    public static final IItemTier quartz = new ToolMaterial(3, 1000,6.0F, 2.0F, 14, () -> Ingredient.fromItems(Items.QUARTZ));
    public static final IItemTier obsidian = new ToolMaterial(3, 2000, 7F, 3.5F, 10, () -> Ingredient.fromItems(Blocks.OBSIDIAN));
    public static final IItemTier emerald = new ToolMaterial(3, 1561, 9.5F, 3.5F, 10, () -> Ingredient.fromItems(Items.EMERALD));
    public static final IItemTier lapis = new ToolMaterial(1, 150, 6.0F, 2.0F, 20, () -> Ingredient.fromItems(Items.LAPIS_LAZULI));
    public static final IItemTier redstone = new ToolMaterial(2, 100, 15.0F, -0.5F, 20, () -> Ingredient.fromItems(Items.REDSTONE));
    public static final IItemTier supertools = new ToolMaterial(3, 1700, 10.6F, 4.5F, 16, () -> Ingredient.fromItems(Items.DIAMOND));


    private static class ToolMaterial implements IItemTier{

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyLoadBase<Ingredient> repair;

        public ToolMaterial(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> supplier) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repair = new LazyLoadBase<Ingredient>(supplier);
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repair.getValue();
        }
    }


}
