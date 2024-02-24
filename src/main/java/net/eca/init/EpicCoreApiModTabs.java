
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eca.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.eca.EpicCoreApiMod;

public class EpicCoreApiModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EpicCoreApiMod.MODID);
	public static final RegistryObject<CreativeModeTab> EPIC_CORE_API = REGISTRY.register("epic_core_api",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.epic_core_api.epic_core_api")).icon(() -> new ItemStack(EpicCoreApiModItems.EPIC_CORE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(EpicCoreApiModBlocks.SILVER_ORE.get().asItem());
				tabData.accept(EpicCoreApiModItems.SILVER_INGOT.get());
				tabData.accept(EpicCoreApiModItems.SILVER_DUST.get());
				tabData.accept(EpicCoreApiModBlocks.SILVER_BLOCK.get().asItem());
				tabData.accept(EpicCoreApiModItems.STEEL_INGOT.get());
				tabData.accept(EpicCoreApiModBlocks.STEEL_BLOCK.get().asItem());
				tabData.accept(EpicCoreApiModItems.STEEL_HAMMER.get());
			}).withSearchBar().build());
}
