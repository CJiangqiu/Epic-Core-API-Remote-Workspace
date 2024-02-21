package net.eca.procedures;

import net.eca.configuration.EpicCoreApiConfigurationConfiguration;

public class OverlayShowProcedure {
	public static boolean execute() {
		if (EpicCoreApiConfigurationConfiguration.OVERLAY_SHOW.get() == true) {
			return true;
		}
		return false;
	}
}
