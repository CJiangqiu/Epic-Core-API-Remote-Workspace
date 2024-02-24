
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.eca.item.SteelIngotItem;
import net.eca.item.SteelHammerItem;
import net.eca.item.SilverIngotItem;
import net.eca.item.SilverDustItem;
import net.eca.item.EpicCoreItem;
import net.eca.EpicCoreApiMod;

public class EpicCoreApiModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EpicCoreApiMod.MODID);
	public static final RegistryObject<Item> SILVER_ORE = block(EpicCoreApiModBlocks.SILVER_ORE);
	public static final RegistryObject<Item> SILVER_INGOT = REGISTRY.register("silver_ingot", () -> new SilverIngotItem());
	public static final RegistryObject<Item> SILVER_DUST = REGISTRY.register("silver_dust", () -> new SilverDustItem());
	public static final RegistryObject<Item> SILVER_BLOCK = block(EpicCoreApiModBlocks.SILVER_BLOCK);
	public static final RegistryObject<Item> STEEL_INGOT = REGISTRY.register("steel_ingot", () -> new SteelIngotItem());
	public static final RegistryObject<Item> STEEL_BLOCK = block(EpicCoreApiModBlocks.STEEL_BLOCK);
	public static final RegistryObject<Item> STEEL_HAMMER = REGISTRY.register("steel_hammer", () -> new SteelHammerItem());
	public static final RegistryObject<Item> EPIC_CORE = REGISTRY.register("epic_core", () -> new EpicCoreItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
