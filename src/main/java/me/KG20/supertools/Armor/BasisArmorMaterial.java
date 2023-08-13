package me.KG20.supertools.Armor;

import me.KG20.supertools.Main.Constants;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.EnumMap;
import java.util.function.Supplier;

public class BasisArmorMaterial {
                                                                                                                                    //Boots,Leggings,Chestplate,Helmet
    //new int[]{4, 5, 8, 3} Emerald
    public final static ArmorMaterial emerald = new ArmorMaterialBasis(Constants.modid + ":emerald",33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266690_) -> {
        p_266690_.put(ArmorItem.Type.BOOTS, 4);
        p_266690_.put(ArmorItem.Type.LEGGINGS, 5);
        p_266690_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266690_.put(ArmorItem.Type.HELMET, 3);
    }), 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F,0.0F,() -> Ingredient.of(Items.EMERALD));
    public final static ArmorMaterial obsidian = new ArmorMaterialBasis(Constants.modid + ":obsidian", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266691_) -> {
        p_266691_.put(ArmorItem.Type.BOOTS, 2);
        p_266691_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266691_.put(ArmorItem.Type.CHESTPLATE, 10);
        p_266691_.put(ArmorItem.Type.HELMET, 2);
    }),12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F,0.0F,() -> Ingredient.of(Blocks.OBSIDIAN));
    public final static ArmorMaterial quartz = new ArmorMaterialBasis(Constants.modid + ":quartz", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266692_) -> {
        p_266692_.put(ArmorItem.Type.BOOTS, 2);
        p_266692_.put(ArmorItem.Type.LEGGINGS, 5);
        p_266692_.put(ArmorItem.Type.CHESTPLATE, 6);
        p_266692_.put(ArmorItem.Type.HELMET, 2);
    }),12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F,0.0F,() -> Ingredient.of(Items.QUARTZ));
    public final static ArmorMaterial lapis = new ArmorMaterialBasis(Constants.modid + ":lapis",10,Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266693_) -> {
        p_266693_.put(ArmorItem.Type.BOOTS, 2);
        p_266693_.put(ArmorItem.Type.LEGGINGS, 3);
        p_266693_.put(ArmorItem.Type.CHESTPLATE, 4);
        p_266693_.put(ArmorItem.Type.HELMET, 2);
    }),25, SoundEvents.ARMOR_EQUIP_IRON, 0.0F,0.0F,() -> Ingredient.of(Items.LAPIS_LAZULI));
    public final static ArmorMaterial copper = new ArmorMaterialBasis(Constants.modid + ":copper",10,Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266691_) -> {
        p_266691_.put(ArmorItem.Type.BOOTS, 2);
        p_266691_.put(ArmorItem.Type.LEGGINGS, 4);
        p_266691_.put(ArmorItem.Type.CHESTPLATE, 5);
        p_266691_.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.0F,0.0F,() -> Ingredient.of(Items.COPPER_INGOT));



    private static class ArmorMaterialBasis implements ArmorMaterial{
        public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
        private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
            p_266653_.put(ArmorItem.Type.BOOTS, 13);
            p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
            p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
            p_266653_.put(ArmorItem.Type.HELMET, 11);
        });
        private final String name;
        private final int durabilityMultiplier;
        private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
        private final int enchantmentValue;
        private final SoundEvent sound;
        private final float toughness;
        private final float knockbackResistance;
        private final LazyLoadedValue<Ingredient> repairIngredient;

        private ArmorMaterialBasis(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protFunction, int enchantValue, SoundEvent sound, float toughness, float knockback, Supplier<Ingredient> ingredient) {
            this.name = name;
            this.durabilityMultiplier = durabilityMultiplier;
            this.protectionFunctionForType = protFunction;
            this.enchantmentValue = enchantValue;
            this.sound = sound;
            this.toughness = toughness;
            this.knockbackResistance = knockback;
            this.repairIngredient = new LazyLoadedValue<>(ingredient);
        }

        public int getDurabilityForType(ArmorItem.Type p_266745_) {
            return HEALTH_FUNCTION_FOR_TYPE.get(p_266745_) * this.durabilityMultiplier;
        }

        public int getDefenseForType(ArmorItem.Type p_266752_) {
            return this.protectionFunctionForType.get(p_266752_);
        }

        public int getEnchantmentValue() {
            return this.enchantmentValue;
        }

        public SoundEvent getEquipSound() {
            return this.sound;
        }

        public Ingredient getRepairIngredient() {
            return this.repairIngredient.get();
        }

        public String getName() {
            return this.name;
        }

        public float getToughness() {
            return this.toughness;
        }

        public float getKnockbackResistance() {
            return this.knockbackResistance;
        }

        public String getSerializedName() {
            return this.name;
        }
    }


}
