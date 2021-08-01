package me.KG20.supertools.Armor;

import me.KG20.supertools.Main.Constants;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class BasisArmorMaterial {

    public final static IArmorMaterial emerald = new ArmorMaterial(Constants.modid + ":emerald",33, new int[]{4, 5, 8, 3}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F,0.0F,() -> Ingredient.of(Items.EMERALD));
    public final static IArmorMaterial obsidian = new ArmorMaterial(Constants.modid + ":obsidian", 33, new int[]{2, 6, 10, 2}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F,0.0F,() -> Ingredient.of(Blocks.OBSIDIAN));
    public final static IArmorMaterial quartz = new ArmorMaterial(Constants.modid + ":quartz", 33, new int[]{2, 5, 6, 2}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F,0.0F,() -> Ingredient.of(Items.QUARTZ));
    public final static IArmorMaterial lapis = new ArmorMaterial(Constants.modid + ":lapis",10, new int[]{2, 3, 4, 2}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F,0.0F,() -> Ingredient.of(Items.LAPIS_LAZULI));

    private static class ArmorMaterial implements IArmorMaterial{

        private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final float knochbackResistance;
        private final LazyValue<Ingredient> repairMaterial;

        public ArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, double toughness, float knochbackResistance, Supplier<Ingredient> supplier) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = (float)toughness;
            this.knochbackResistance = knochbackResistance;
            this.repairMaterial = new LazyValue<Ingredient>(supplier);
        }

        @Override
        public int getDurabilityForSlot(EquipmentSlotType slotIn) {
            return Max_Damage_Array[slotIn.getIndex()] * maxDamageFactor;
        }

        @Override
        public int getDefenseForSlot(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantmentValue() {
            return enchantability;
        }

        @Override
        public SoundEvent getEquipSound() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return repairMaterial.get();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return this.knochbackResistance;
        }
    }


}
