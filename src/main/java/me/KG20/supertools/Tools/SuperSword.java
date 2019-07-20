package me.KG20.supertools.Tools;

import me.KG20.supertools.Init.CreativeTabs;
import me.KG20.supertools.Init.RegisterItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class SuperSword extends SwordItem {

    public SuperSword(IItemTier material, float speed) {
        super(material, 3, speed, new Properties().group(CreativeTabs.tools));
    }
    public SuperSword(IItemTier material, float speed, Properties properties) {
        super(material, 3, speed, properties);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(RegisterItems.superSword.equals(stack.getItem())){
            target.addPotionEffect(new EffectInstance(Effect.get(18), 60, 1));
            target.addPotionEffect(new EffectInstance(Effect.get(19), 60, 1));
            target.addPotionEffect(new EffectInstance(Effect.get(24), 60, 1));
        }
        return super.hitEntity(stack, target, attacker);
    }
}
