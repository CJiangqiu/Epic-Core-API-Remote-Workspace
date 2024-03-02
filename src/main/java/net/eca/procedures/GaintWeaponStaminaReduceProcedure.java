package net.eca.stamina;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

@Mod.EventBusSubscriber
public class GaintWeaponStaminaReduceProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		Entity sourceentity = event.getSource().getEntity();
		if (sourceentity == null)
			return;
		double stamina = sourceentity.getPersistentData().getDouble("stamina");
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:weapons/giant_weapon")))) {
			double newStamina = stamina - 10;
			if (newStamina < 0) {
				newStamina = 0;
			}
			sourceentity.getPersistentData().putDouble("stamina", newStamina);
		}
	}
}
