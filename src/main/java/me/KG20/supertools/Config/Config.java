package me.KG20.supertools.Config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public static ForgeConfigSpec.BooleanValue enable_SuperTools;
    public static ForgeConfigSpec.IntValue durability_quartz;
    public static ForgeConfigSpec.IntValue durability_obsidian;
    public static ForgeConfigSpec.IntValue durability_emerald;
    public static ForgeConfigSpec.IntValue durability_lapis;
    public static ForgeConfigSpec.IntValue durability_redstone;
    public static ForgeConfigSpec.IntValue durability_SuperTools;
    public static ForgeConfigSpec.IntValue durability_BoneMealTool;
    public static ForgeConfigSpec.IntValue durability_Cup;
    public static ForgeConfigSpec.IntValue durability_SpecialCup;

    public static void init(ForgeConfigSpec.Builder Builder){

        Builder.comment("Config File of the Super Tools mod.");

        enable_SuperTools = Builder.comment("Enable Super Tools(Not the mod) (Default: true)").define("supertools", true);
        durability_quartz = Builder.comment("Super Tools durabilty (Default: 1000)").defineInRange("Quartz Tools durabilty", 1000, 0, 999999999);
        durability_obsidian = Builder.comment("Super Tools durabilty (Default: 2000)").defineInRange("Obsidian Tools durabilty", 2000, 0, 999999999);
        durability_emerald = Builder.comment("Super Tools durabilty (Default: 1561)").defineInRange("Emerald Tools durabilty", 1561, 0, 999999999);
        durability_lapis = Builder.comment("Super Tools durabilty (Default: 150)").defineInRange("Lapis Tools durabilty", 150, 0, 999999999);
        durability_redstone = Builder.comment("Super Tools durabilty (Default: 100)").defineInRange("Redstone Tools durabilty", 100, 0, 999999999);
        durability_SuperTools = Builder.comment("Super Tools durabilty (Default: 1350)").defineInRange("Super Tools durabilty", 1350, 0, 999999999);
        durability_BoneMealTool = Builder.comment("Super Tools durabilty (Default: 100)").defineInRange("A Bag of Bonemeal durabilty", 100, 0, 999999999);
        durability_Cup = Builder.comment("Super Tools durabilty (Default: 1700)").defineInRange("Cup durabilty", 1700, 0, 999999999);
        durability_SpecialCup = Builder.comment("Super Tools durabilty (Default: 2000)").defineInRange("Special Cup durabilty", 2000, 0, 999999999);
    }


}
