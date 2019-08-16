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
    public static ForgeConfigSpec.IntValue max_wood_logs;

    //

    public static void init(ForgeConfigSpec.Builder Builder){

        Builder.comment("Config File of the Super Tools mod.");

        Builder.push("SuperTools");
        enable_SuperTools = Builder.comment("Enable Super Tools(Not the mod) (Default: true)").define("supertools", true);
        Builder.push("Durabilities");
        durability_quartz = Builder.comment("Super Tools durabilty (Default: 1000)").defineInRange("quartz_tools_durabilty", 1000, 0, 999999999);
        durability_obsidian = Builder.comment("Super Tools durabilty (Default: 2000)").defineInRange("obsidian_tools_durabilty", 2000, 0, 999999999);
        durability_emerald = Builder.comment("Super Tools durabilty (Default: 1561)").defineInRange("emerald_tools_durabilty", 1561, 0, 999999999);
        durability_lapis = Builder.comment("Super Tools durabilty (Default: 150)").defineInRange("lapis_tools_durabilty", 150, 0, 999999999);
        durability_redstone = Builder.comment("Super Tools durabilty (Default: 100)").defineInRange("redstone_tools_durabilty", 100, 0, 999999999);
        durability_SuperTools = Builder.comment("Super Tools durabilty (Default: 1350)").defineInRange("super_tools_durabilty", 1350, 0, 999999999);
        durability_BoneMealTool = Builder.comment("Super Tools durabilty (Default: 100)").defineInRange("a_bag_of_bonemeal _durabilty", 100, 0, 999999999);
        durability_Cup = Builder.comment("Super Tools durabilty (Default: 1700)").defineInRange("cup_durabilty", 1700, 0, 999999999);
        durability_SpecialCup = Builder.comment("Super Tools durabilty (Default: 2000)").defineInRange("special_cup_durabilty", 2000, 0, 999999999);
        Builder.pop();
        Builder.push("Super Axe");
        max_wood_logs = Builder.comment("Set the Maxmium amount of Wood Logs being chopped with the Super Axe").defineInRange("max_wood_logs", 64, 0, 999999999);
    }


}
