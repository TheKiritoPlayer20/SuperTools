package me.KG20.supertools.Armor;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.*;
import net.minecraft.world.World;
import net.minecraftforge.common.asm.PotionEffectTransformer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemArmor extends ArmorItem {


    public ItemArmor(IArmorMaterial materialIn, EquipmentSlotType slots) {
        super(materialIn, slots, new Properties().group(CreativeTabs.armor));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {

        ItemArmor obsidianHelmet = RegisterItems.obsidianHelmet;
        ItemArmor obsidianChestplate = RegisterItems.obsidianChestplate;
        ItemArmor obsidianLeggings = RegisterItems.obsidianLeggings;
        ItemArmor obsidianBoots = RegisterItems.obsidianBoots;

        ItemArmor quartzHelmet = RegisterItems.quartzHelmet;
        ItemArmor quartzChestplate = RegisterItems.quartzChestplate;
        ItemArmor quartzLeggings = RegisterItems.quartzLeggings;
        ItemArmor quartzBoots = RegisterItems.quartzBoots;


        if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(obsidianBoots) || player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(obsidianLeggings) ||
                player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(obsidianChestplate) || player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(obsidianHelmet)){
            player.addPotionEffect(new EffectInstance(Effect.getPotionById(2), 10, 0));

            if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(obsidianBoots) && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(obsidianLeggings) &&
                    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(obsidianChestplate) && player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(obsidianHelmet)) {

                player.addPotionEffect(new EffectInstance(Effect.getPotionById(12), 10, 0));
                player.addPotionEffect(new EffectInstance(Effect.getPotionById(2), 10, 1));
                player.addPotionEffect(new EffectInstance(Effect.getPotionById(11), 10, 0));
            }
        }

        if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(quartzBoots) && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(quartzLeggings) &&
                player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(quartzChestplate) && player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(quartzHelmet)) {
            player.addPotionEffect(new EffectInstance(Effect.getPotionById(12), 10, 0));
        }

    }
}
