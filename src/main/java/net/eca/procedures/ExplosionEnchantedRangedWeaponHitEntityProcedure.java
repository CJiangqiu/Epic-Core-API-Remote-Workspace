package net.eca.procedures;

import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.eca.init.EpicCoreApiModEnchantments;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

@Mod.EventBusSubscriber
public class ExplosionEnchantedRangedWeaponHitEntityProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event.getEntity().level(), event.getSource(), event.getEntity());
        }
    }
public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity) {
    if (damagesource == null || entity == null)
        return;
    if (damagesource.getDirectEntity() instanceof Arrow arrow) {
        Entity shooter = arrow.getOwner();
        if (shooter instanceof LivingEntity livingEntity) {
            int explosionLevel = Math.max(
                getExplosionLevel(livingEntity.getMainHandItem()),
                getExplosionLevel(livingEntity.getOffhandItem())
            );
            if (explosionLevel > 0 && world instanceof Level _level && !_level.isClientSide()) {
                _level.explode(null, entity.getX(), entity.getY(), entity.getZ(), explosionLevel, Level.ExplosionInteraction.MOB);
            }
        }
    }
}

private static int getExplosionLevel(ItemStack itemStack) {
    if (itemStack.is(ItemTags.create(new ResourceLocation("forge:weapons/ranged_weapon")))) {
        return EnchantmentHelper.getItemEnchantmentLevel(EpicCoreApiModEnchantments.EXPLOSION.get(), itemStack);
    }
    return 0;
}



}
