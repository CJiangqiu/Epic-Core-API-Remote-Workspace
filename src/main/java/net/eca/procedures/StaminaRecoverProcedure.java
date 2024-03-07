package net.eca.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.eca.init.EpicCoreApiModAttributes;

import javax.annotation.Nullable;

import java.util.UUID;
import java.util.Random; 

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
        if (((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getValue() < ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getBaseValue()) {
            
            UUID randomUUID = UUID.randomUUID();
            ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.STAMINA.get())
                    .addPermanentModifier((new AttributeModifier(randomUUID, "stamina_recover", 0.05, AttributeModifier.Operation.ADDITION)));
        }
    }
}