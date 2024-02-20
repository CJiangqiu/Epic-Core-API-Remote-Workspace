
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.eca.enchantment.SacrificeEnchantment;
import net.eca.enchantment.PoisoningEnchantment;
import net.eca.enchantment.DivineWrathEnchantment;
import net.eca.EpicCoreApiMod;

public class EpicCoreApiModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EpicCoreApiMod.MODID);
	public static final RegistryObject<Enchantment> SACRIFICE = REGISTRY.register("sacrifice", () -> new SacrificeEnchantment());
	public static final RegistryObject<Enchantment> POISONING = REGISTRY.register("poisoning", () -> new PoisoningEnchantment());
	public static final RegistryObject<Enchantment> DIVINE_WRATH = REGISTRY.register("divine_wrath", () -> new DivineWrathEnchantment());
}
