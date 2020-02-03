package me.KG20.supertools.Config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public  static ForgeConfigSpec.ConfigValue<String> string;
    public static ForgeConfigSpec.BooleanValue enable_SuperTools;
    public static ForgeConfigSpec.BooleanValue enable_ArmorStatusEffect;
    public static ForgeConfigSpec.BooleanValue enable_QuartzStatusEffects;
    public static ForgeConfigSpec.BooleanValue enable_ObsidianStatusEffects;
    public static ForgeConfigSpec.BooleanValue enable_ObsidianStatusEffectsLevel1;
    public static ForgeConfigSpec.BooleanValue enable_ObsidianStatusEffectsLevel2;
    public static ForgeConfigSpec.BooleanValue enable_BlockDropsInCreative;
    public static ForgeConfigSpec.IntValue durability_Quartz;
    public static ForgeConfigSpec.IntValue durability_Obsidian;
    public static ForgeConfigSpec.IntValue durability_Emerald;
    public static ForgeConfigSpec.IntValue durability_Lapis;
    public static ForgeConfigSpec.IntValue durability_Redstone;
    public static ForgeConfigSpec.IntValue durability_SuperTools;
    public static ForgeConfigSpec.IntValue durability_BoneMealTool;
    public static ForgeConfigSpec.IntValue durability_Cup;
    public static ForgeConfigSpec.IntValue durability_SpecialCup;
    public static ForgeConfigSpec.IntValue max_wood_logs;
    public static ForgeConfigSpec.DoubleValue attackdamage_Quartz;
    public static ForgeConfigSpec.DoubleValue attackdamage_Obsidian;
    public static ForgeConfigSpec.DoubleValue attackdamage_Emerald;
    public static ForgeConfigSpec.DoubleValue attackdamage_Lapis;
    public static ForgeConfigSpec.DoubleValue attackdamage_Redstone;
    public static ForgeConfigSpec.DoubleValue attackdamage_SuperTools;
    public static ForgeConfigSpec.DoubleValue attackdamage_Cup;
    public static ForgeConfigSpec.DoubleValue attackdamage_SpecialCup;

    //

    public static void init(ForgeConfigSpec.Builder Builder){

        Builder.comment("Config File of the Super Tools mod.");

        Builder.push("SuperTools");
        enable_SuperTools = Builder.comment("Enable Super Tools(Not the mod) (Default: true)").define("supertools", true);
        enable_BlockDropsInCreative = Builder.comment("Enable that the Super Tools drop Blocks in Creative Mode(Default: false)").define("creative_block_drops", false);

        Builder.push("Armor Effects");
        enable_ArmorStatusEffect = Builder.comment("Enable the Armor Potion Effects (Default: true)").define("armor_potion_effects", true);
        Builder.push("Quartz Effects");
        enable_QuartzStatusEffects = Builder.comment("Enable the Quartz Armor Potion Effects (Default: true)").define("quartz_armor_potion_effects", true);
        Builder.pop();
        Builder.push("Obsidian Effetcs");
        enable_ObsidianStatusEffects = Builder.comment("Enable the Obsidian Armor Potion Effects (Default: true)").define("obsidian_armor_potion_effects", true);
        Builder.push("Level 1");
        enable_ObsidianStatusEffectsLevel1 = Builder.comment("Enable the Obsidian Armor Potion Effects when you have only 1 piece or more pieces (Default: true)").define("obsidian_armor_potion_effects_level1", true);
        Builder.push("Level 2");
        enable_ObsidianStatusEffectsLevel2 = Builder.comment("Enable the Armor Status Effects when you have every piece(Default: true)").define("obsidian_armor_potion_effects_level2", true);
        Builder.pop();
        Builder.pop();
        Builder.pop();

        Builder.pop();
        Builder.push("Durabilities");
        durability_Quartz = Builder.comment("Quartz durabilty (Default: 1000)").defineInRange("quartz_tools_durabilty", 1000, 0, 999999999);
        durability_Obsidian = Builder.comment("Obsidian durabilty (Default: 2000)").defineInRange("obsidian_tools_durabilty", 2000, 0, 999999999);
        durability_Emerald = Builder.comment("Emerald durabilty (Default: 1561)").defineInRange("emerald_tools_durabilty", 1561, 0, 999999999);
        durability_Lapis = Builder.comment("Lapis durabilty (Default: 150)").defineInRange("lapis_tools_durabilty", 150, 0, 999999999);
        durability_Redstone = Builder.comment("Redstone durabilty (Default: 100)").defineInRange("redstone_tools_durabilty", 100, 0, 999999999);
        durability_SuperTools = Builder.comment("Super Tools durabilty (Default: 1350)").defineInRange("super_tools_durabilty", 1350, 0, 999999999);
        durability_BoneMealTool = Builder.comment("A Bag of Bonemeal durabilty (Default: 100)").defineInRange("a_bag_of_bonemeal _durabilty", 100, 0, 999999999);
        durability_Cup = Builder.comment("Cup durabilty (Default: 1700)").defineInRange("cup_durabilty", 1700, 0, 999999999);
        durability_SpecialCup = Builder.comment("SpecialCup durabilty (Default: 2000)").defineInRange("special_cup_durabilty", 2000, 0, 999999999);
        Builder.pop();
        Builder.push("Tool Attack Damage");
        Builder.push("DONT CHANGE THE STRINGS!");
        string = Builder.define("dontchange", "Base Axe damage: 6");
        string = Builder.define("dontchange2", "Base Sword damage: 3");
        string = Builder.define("dontchange3", "Base Shovel damage: 1.5");
        string = Builder.define("dontchange4", "Base Pickaxe damage: 1");
        string = Builder.define("dontchange5", "Base Hoe damage: 0");
        string = Builder.define("dontchange6", "Base Cup damage: 1");
        string = Builder.define("dontchange7", "To get the damage you want add the base damage of the Tool and the base attack damage of the material.");
        Builder.pop();
        Builder.push("Attack Damage");
        attackdamage_Quartz = Builder.comment("Quartz base attack damage").defineInRange("attackdamage_quartz", 2.0,0.0, 999999999);
        attackdamage_Obsidian = Builder.comment("Obsidian base attack damage").defineInRange("attackdamage_obsidian", 3.5,0.0, 999999999);
        attackdamage_Emerald = Builder.comment("Emerald base attack damage").defineInRange("attackdamage_emerald", 3.5,0.0, 999999999);
        attackdamage_Lapis = Builder.comment("Lapis base attack damage").defineInRange("attackdamage_lapis", 2.0,0.0, 999999999);
        attackdamage_Redstone = Builder.comment("Redstone base attack damage").defineInRange("attackdamage_redstone", -0.5,0.0, 999999999);
        attackdamage_SuperTools = Builder.comment("Super Tools base attack damage").defineInRange("attackdamage_supertools", 3.5,0.0, 999999999);
        attackdamage_Cup = Builder.comment("Cup base attack damage").defineInRange("attackdamage_cup", 3.5,0.0, 999999999);
        attackdamage_SpecialCup = Builder.comment("Special Cup base attack damage").defineInRange("attackdamage_specialcup", 4.0,0.0, 999999999);
        Builder.pop(2);

        Builder.push("Super Axe");
        max_wood_logs = Builder.comment("Set the Maxmium amount of Wood Logs being chopped with the Super Axe").defineInRange("max_wood_logs", 64, 0, 999999999);
    }


}
