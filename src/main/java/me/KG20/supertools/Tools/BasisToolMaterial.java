package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import me.KG20.supertools.Config.Config;

import java.util.function.Supplier;

public class BasisToolMaterial {

    public static final Tier quartz = new ToolMaterial(3, Config.durability_Quartz.get(),6.0F, Config.attackdamage_Quartz.get(), 14, () -> Ingredient.of(Items.QUARTZ));
    public static final Tier obsidian = new ToolMaterial(3, Config.durability_Obsidian.get(), 7F, Config.attackdamage_Obsidian.get(), 10, () -> Ingredient.of(Blocks.OBSIDIAN));
    public static final Tier emerald = new ToolMaterial(3, Config.durability_Emerald.get(), 9.5F, Config.attackdamage_Emerald.get(), 10, () -> Ingredient.of(Items.EMERALD));
    public static final Tier lapis = new ToolMaterial(1, Config.durability_Lapis.get(), 6.0F, Config.attackdamage_Lapis.get(), 20, () -> Ingredient.of(Items.LAPIS_LAZULI));
    public static final Tier copper = new ToolMaterial(2, Config.durability_Copper.get(), 6.0F, Config.attackdamage_Copper.get(), 10, () -> Ingredient.of(Items.COPPER_INGOT));
    public static final Tier redstone = new ToolMaterial(2, Config.durability_Redstone.get(), 15.0F, Config.attackdamage_Redstone.get(), 20, () -> Ingredient.of(Items.REDSTONE));
    public static final Tier supertools = new ToolMaterial(4, Config.durability_SuperTools.get(), 10.6F, Config.attackdamage_SuperTools.get(), 16, () -> Ingredient.of(RegisterItems.adarum));
    public static final Tier itemcup = new ToolMaterial(4, Config.durability_Cup.get(), 10.6F, Config.attackdamage_Cup.get(),16, () -> Ingredient.of(Items.DIAMOND));
    public static final Tier specialcup = new ToolMaterial(4, Config.durability_SpecialCup.get(), 12F, Config.attackdamage_SpecialCup.get(), 16, () ->Ingredient.of(Items.DIAMOND));


    private static class ToolMaterial implements Tier{

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyLoadedValue<Ingredient> repair;

        public ToolMaterial(int harvestLevel, int maxUses, float efficiency, double attackDamage, int enchantability, Supplier<Ingredient> supplier) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = (float)attackDamage;
            this.enchantability = enchantability;
            this.repair = new LazyLoadedValue<>(supplier);
        }

        @Override
        public int getUses() {
            return maxUses;
        }

        @Override
        public float getSpeed() {
            return efficiency;
        }

        @Override
        public float getAttackDamageBonus() {
            return attackDamage;
        }

        @Override
        public int getLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantmentValue() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return this.repair.get();
        }
    }


}
