/*Sacrifice Enchantment: This is a custom enchantment that causes soul damage equal to the level of the enchantment to the entity being attacked.
献祭附魔：这是一种自定义附魔，它会对被攻击的实体造成等于附魔等级的灵魂伤害。
*/

package net.eca.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class SacrificeEnchantment extends Enchantment {
	public SacrificeEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}
