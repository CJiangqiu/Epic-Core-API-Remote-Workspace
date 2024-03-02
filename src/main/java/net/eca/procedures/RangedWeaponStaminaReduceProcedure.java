package net.eca.stamina;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

@Mod.EventBusSubscriber
public class RangedWeaponStaminaReduceProcedure {
    @SubscribeEvent
    public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity) {
            execute(entity);
        }
    }

    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            if (livingEntity.getPersistentData().getDouble("stamina") < 10) {
                event.setAmount(event.getAmount() / 2);
            }
        }
    }

    public static void execute(Entity entity) {
        if (entity == null || !(entity instanceof LivingEntity))
            return;
        LivingEntity livingEntity = (LivingEntity) entity;
        if (livingEntity.getPersistentData().getDouble("stamina") >= 10) {
            if (livingEntity.getUseItem().is(ItemTags.create(new ResourceLocation("forge:weapons/ranged_weapon")))) {
                livingEntity.getPersistentData().putDouble("stamina", (livingEntity.getPersistentData().getDouble("stamina") - 10));
            }
        }
    }
}