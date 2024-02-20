package net.eca.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class EpicCoreApiConfigurationConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DAMAGE_REPORT;
	public static final ForgeConfigSpec.ConfigValue<Double> DAMAGE_REPORT_RANGE;
	public static final ForgeConfigSpec.ConfigValue<Double> SACRIFICE_CAUSE_SOUL_DAMAGE;
	static {
		BUILDER.push("damage_report");
		DAMAGE_REPORT = BUILDER.comment("When true, send detailed information about the entity being injured.为真时，发送实体受伤的详细信息").define("damage_report", true);
		DAMAGE_REPORT_RANGE = BUILDER.comment("Determined the range of damage reporting.这个值决定了伤害报告距离玩家起效的范围").define("damage_report_range", (double) 64);
		SACRIFICE_CAUSE_SOUL_DAMAGE = BUILDER.comment("This will determine the amount of soul damage caused by the level of sacrifice.这将决定sacrifice的等级造成的灵魂伤害数值。").define("sacrifice_cause_soul_damage", (double) 1);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
