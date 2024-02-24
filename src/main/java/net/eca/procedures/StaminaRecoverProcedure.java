package net.eca.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.eca.network.EpicCoreApiModVariables;
import net.eca.init.EpicCoreApiModAttributes;
import net.eca.configuration.EpicCoreApiConfigurationConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StaminaRecoverProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EpicCoreApiModVariables.PlayerVariables())).stamina < ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get())
				.getBaseValue()) {
			{
				double _setval = (entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EpicCoreApiModVariables.PlayerVariables())).stamina
						+ (double) EpicCoreApiConfigurationConfiguration.STAMINA_RECOVER_VALUE.get() / 20;
				entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EpicCoreApiModVariables.PlayerVariables())).stamina > ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get())
				.getBaseValue()) {
			{
				double _setval = ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getBaseValue();
				entity.getCapability(EpicCoreApiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
