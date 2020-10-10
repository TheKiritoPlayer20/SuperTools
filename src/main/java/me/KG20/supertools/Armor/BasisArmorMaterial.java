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

    public final static IArmorMaterial emerald = new ArmorMaterial(Constants.modid + ":emerald",33, new int[]{4, 5, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F,() -> Ingredient.fromItems(Items.EMERALD));
    public final static IArmorMaterial obsidian = new ArmorMaterial(Constants.modid + ":obsidian", 33, new int[]{2, 6, 10, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F,() -> Ingredient.fromItems(Blocks.OBSIDIAN));
    public final static IArmorMaterial quartz = new ArmorMaterial(Constants.modid + ":quartz", 33, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F,() -> Ingredient.fromItems(Items.QUARTZ));
    public final static IArmorMaterial lapis = new ArmorMaterial(Constants.modid + ":lapis",10, new int[]{2, 3, 4, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F,() -> Ingredient.fromItems(Items.LAPIS_LAZULI));

    private static class ArmorMaterial implements IArmorMaterial{

        private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;

        public ArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> supplier) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = toughness;
            this.repairMaterial = new LazyValue<Ingredient>(supplier);
        }

        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;


        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return Max_Damage_Array[slotIn.getIndex()] * maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial.getValue();
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
            // The scale of the amount of knockback resisted from attacks and projectiles.
            // Does not affect explosions. 1.0 is 100% knockback resistance.
            return 0;
        }
    }


}
