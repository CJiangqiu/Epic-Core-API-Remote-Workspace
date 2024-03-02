package net.eca.stamina;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.eca.init.EpicCoreApiModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StaminaGetProcedure {
    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {
        execute(event, event.getEntity());
    }

    public static double execute(Entity entity) {
        return execute(null, entity);
    }

    private static double execute(@Nullable Event event, Entity entity) {
        if (entity == null || !(entity instanceof LivingEntity))
            return 0;
        LivingEntity livingEntity = (LivingEntity) entity;
        livingEntity.getPersistentData().putDouble("stamina", livingEntity.getAttribute(EpicCoreApiModAttributes.STAMINA.get()).getBaseValue());
        return livingEntity.getPersistentData().getDouble("stamina");
    }
}