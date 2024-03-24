package net.eca.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import net.eca.entity.ShotManaArrowEntity;
import net.eca.procedures.MagicWeaponManaReduceProcedure;
import net.eca.init.EpicCoreApiModAttributes;

public class MagicArrowStaffItem extends Item {
    public MagicArrowStaffItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 60;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = InteractionResultHolder.success(entity.getItemInHand(hand));
        entity.startUsingItem(hand);
        return ar;
    }

    @Override
    public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
        if (!world.isClientSide() && entity instanceof ServerPlayer player) {
            if (player.getAbilities().instabuild || ((LivingEntity) entity).getAttribute(EpicCoreApiModAttributes.MANA.get()).getValue() >= 5) {
                ShotManaArrowEntity projectile = ShotManaArrowEntity.shoot(world, entity, world.getRandom());
                itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
                if (!player.getAbilities().instabuild) {
                    MagicWeaponManaReduceProcedure.execute(entity);
                }
            }
        }
    }
}
