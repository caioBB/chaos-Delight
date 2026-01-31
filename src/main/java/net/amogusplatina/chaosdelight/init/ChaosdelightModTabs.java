/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.amogusplatina.chaosdelight.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.amogusplatina.chaosdelight.ChaosdelightMod;

public class ChaosdelightModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChaosdelightMod.MODID);
	public static final RegistryObject<CreativeModeTab> CHAOS_DELIGHT = REGISTRY.register("chaos_delight",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.chaosdelight.chaos_delight")).icon(() -> new ItemStack(ChaosdelightModItems.ULTIMATE_KNIFE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ChaosdelightModItems.ULTIMATE_KNIFE.get());
				tabData.accept(ChaosdelightModItems.EMERALD_KNIFE.get());
				tabData.accept(ChaosdelightModItems.RUBY_KNIFE.get());
				tabData.accept(ChaosdelightModItems.AMETHYST_KNIFE.get());
				tabData.accept(ChaosdelightModItems.TIGERS_EYE_KNIFE.get());
				tabData.accept(ChaosdelightModItems.LITTLE_BERTHA.get());
				tabData.accept(ChaosdelightModItems.HERCULES_BEETLE_LEG.get());
				tabData.accept(ChaosdelightModItems.HERCULESBEETLEWING.get());
				tabData.accept(ChaosdelightModItems.PINK_CAKE.get());
				tabData.accept(ChaosdelightModItems.TITANIUMPIECRUST.get());
				tabData.accept(ChaosdelightModBlocks.ULTIMATE_APPLE_PIE.get().asItem());
				tabData.accept(ChaosdelightModItems.ULTIMATE_APPLE_PIE_SLICE.get());
				tabData.accept(ChaosdelightModItems.ULTIMATE_POPSICLE.get());
				tabData.accept(ChaosdelightModItems.RADIOACTIVE_MIX.get());
				tabData.accept(ChaosdelightModItems.GOLDEN_SALAD.get());
				tabData.accept(ChaosdelightModItems.ENCHANTED_GOLDEN_SALAD.get());
				tabData.accept(ChaosdelightModItems.MAN_MEME_STEAK.get());
			}).build());
}