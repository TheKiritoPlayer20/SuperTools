package me.KG20.supertools.Armor;

import me.KG20.supertools.Config.Config;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemArmor extends ArmorItem {


    public ItemArmor(ArmorMaterial materialIn, EquipmentSlot slots, Item.Properties properties) {
        super(materialIn, slots, properties);
    }

    /*
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {

        ItemArmor obsidianHelmet = RegisterItems.obsidianHelmet;
        ItemArmor obsidianChestplate = RegisterItems.obsidianChestplate;
        ItemArmor obsidianLeggings = RegisterItems.obsidianLeggings;
        ItemArmor obsidianBoots = RegisterItems.obsidianBoots;

        ItemArmor quartzHelmet = RegisterItems.quartzHelmet;
        ItemArmor quartzChestplate = RegisterItems.quartzChestplate;
        ItemArmor quartzLeggings = RegisterItems.quartzLeggings;
        ItemArmor quartzBoots = RegisterItems.quartzBoots;

        if(Config.enable_ArmorStatusEffect.get()){

            if(Config.enable_ObsidianStatusEffects.get()){

                if(Config.enable_ObsidianStatusEffectsLevel1.get()){
                    if(player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(obsidianBoots) || player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(obsidianLeggings) ||
                            player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(obsidianChestplate) || player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(obsidianHelmet)){
                        player.addEffect(new MobEffectInstance(MobEffect.byId(2), 10, 0));

                    }

                    if(Config.enable_ObsidianStatusEffectsLevel2.get()){
                        if(player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(obsidianBoots) && player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(obsidianLeggings) &&
                                player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(obsidianChestplate) && player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(obsidianHelmet)) {

                            player.addEffect(new MobEffectInstance(MobEffect.byId(12), 10, 0));
                            player.addEffect(new MobEffectInstance(MobEffect.byId(2), 10, 1));
                            player.addEffect(new MobEffectInstance(MobEffect.byId(11), 10, 0));
                        }
                    }
                }
            }
            if(Config.enable_QuartzStatusEffects.get()){
                if(player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(quartzBoots) && player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(quartzLeggings) &&
                        player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(quartzChestplate) && player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(quartzHelmet)) {
                    player.addEffect(new MobEffectInstance(MobEffect.byId(12), 10, 0));
                }
            }
        }

    }
    */
}
