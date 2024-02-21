package net.eca.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class EpicCoreApiConfigurationConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DAMAGE_REPORT;
	public static final ForgeConfigSpec.ConfigValue<Double> DAMAGE_REPORT_RANGE;
	public static final ForgeConfigSpec.ConfigValue<Double> SACRIFICE_MAX_HEALTH_REDUCE;
	public static final ForgeConfigSpec.ConfigValue<String> PRESET_COMMAND;
	static {
		BUILDER.push("damage_report");
		DAMAGE_REPORT = BUILDER.comment("When true, send detailed information about the entity being injured.为真时，发送实体受伤的详细信息").define("damage_report", true);
		DAMAGE_REPORT_RANGE = BUILDER.comment("Determined the range of damage reporting.这个值决定了伤害报告距离玩家起效的范围").define("damage_report_range", (double) 64);
		SACRIFICE_MAX_HEALTH_REDUCE = BUILDER.comment("Control the maximum health reduction caused by sacrifice enchantment.控制献祭附魔造成的最大生命值减少").define("sacrifice_max_health_reduce", (double) 1);
		PRESET_COMMAND = BUILDER.comment("You can enter the command you want to preset here.你可以在这里输入你想预置的命令。").define("preset_command", "");
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
