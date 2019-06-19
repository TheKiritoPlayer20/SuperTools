/*
 * CopyRight(©)
 * by Supervogel1
 *
 */

package me.Supervogel1.supertools.tools;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

import javax.annotation.Nullable;

    /* ======================================== FORGE END   =====================================*/

public enum EnumToolMaterialBasis
{
    WOOD(0, 59, 2.0F, 0.0F, 15),
    STONE(1, 131, 4.0F, 1.0F, 5),
    IRON(2, 250, 6.0F, 2.0F, 14),
    DIAMOND(3, 1561, 8.0F, 3.0F, 10),
    GOLD(0, 32, 12.0F, 0.0F, 22),

    //1.Zahl tool harvestLevel
    //2.Zahl haltbarkeit
    //3.Zahl(Float) Efficency
    //4.Zahl(Float) Damage gegen Mobs
    //5.Zahl Enchantbarkeit






    COAL(1, 150, 4.5F, 1.0F, 5),
    OBSIDIAN(3, 1800, 8.7F, 3.5F, 10),
    EMERALD(3, 1561, 9.5F, 3.5F, 10),
    LAPIS(1, 150, 6.0F, 2.0F, 5),
    QUARTZ(3, 2000, 10.0F, 4.0F, 10),
    REDSTONE(2, 100, 15.0F, 3.0F, 14),
    ItemCup(3, 1700, 10.6F, 0.0F, 15),
    SpecialCup(4, 2000, 15.0F, 0.0F, 17),
    SuperHoe(2, 1800, 10.6F, 0.0F, 16),
    SuperSword(3, 1700, 10.6F, 4.5F, 16);

    /** The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = WOOD/GOLD) */
    private final int harvestLevel;
    /** The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32) */
    private final int maxUses;
    /** The strength of this tool material against blocks which it is effective against. */
    private final float efficiency;
    /** Damage versus entities. */
    private final float attackDamage;
    /** Defines the natural enchantability factor of the material. */
    private final int enchantability;
    //Added by forge for custom Tool materials.
    private ItemStack repairMaterial = ItemStack.EMPTY;

    private EnumToolMaterialBasis(int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability)
    {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = damageVsEntity;
        this.enchantability = enchantability;
    }

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    public int getMaxUses()
    {
        return this.maxUses;
    }

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    public float getEfficiency()
    {
        return this.efficiency;
    }

    /**
     * Returns the damage against a given entity.
     */
    public float getAttackDamage()
    {
        return this.attackDamage;
    }

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    /**
     * Return the natural enchantability factor of the material.
     */
    public int getEnchantability()
    {
        return this.enchantability;
    }

    @Deprecated // Use getRepairItemStack below
    public Item getRepairItem()
    {
        if (this == WOOD)
        {
            return Item.getItemFromBlock(Blocks.PLANKS);
        }
        else if (this == STONE)
        {
            return Item.getItemFromBlock(Blocks.COBBLESTONE);
        }
        else if (this == GOLD)
        {
            return Items.GOLD_INGOT;
        }
        else if (this == IRON)
        {
            return Items.IRON_INGOT;
        }
        else if (this == DIAMOND)

            return  Items.DIAMOND;

        //Tools

        if (this == OBSIDIAN)
        {
            return Item.getItemFromBlock(Blocks.OBSIDIAN);
        }
        else if (this == COAL)
        {
            return Items.COAL;
        }
        else if (this == EMERALD)
        {
            return Items.EMERALD;
        }
        /*else if (this == LAPIS)
        {
            return Items.DYE;
        }
        */

        if (this == QUARTZ)
        {
            return Items.QUARTZ;
        }
        else if (this == REDSTONE)
        {
            return Items.REDSTONE;
        }

        //SuperTools
        else if (this == ItemCup)
        {
            return Items.DIAMOND;
        }
        else if (this == SuperSword)
        {
            return Items.DIAMOND;
        }
        else if (this == SuperHoe)
        {
            return Items.DIAMOND;
        }
        else if (this == SpecialCup)
        {
            return Items.DIAMOND;
        }
        else
        {
            return this == DIAMOND ? Items.DIAMOND : null;
        }

    }

    public EnumToolMaterialBasis setRepairItem(ItemStack stack)
    {
        if (!this.repairMaterial.isEmpty()) throw new RuntimeException("Repair material has already been set");
        if (this == WOOD || this == STONE || this == GOLD || this == IRON || this == DIAMOND) throw new RuntimeException("Can not change vanilla tool repair materials");
        this.repairMaterial = stack;
        return this;
    }

    public ItemStack getRepairItemStack()
    {
        if (!repairMaterial.isEmpty()) return repairMaterial;
        Item ret = this.getRepairItem();
        if (ret != null) repairMaterial = new ItemStack(ret, 1, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE);
        return repairMaterial;
    }
}

