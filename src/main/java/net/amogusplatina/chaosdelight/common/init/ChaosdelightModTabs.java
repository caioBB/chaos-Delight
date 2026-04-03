package net.amogusplatina.chaosdelight.common.init;


import net.amogusplatina.chaosdelight.ChaosdelightMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;



public class ChaosdelightModTabs {


	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChaosdelightMod.MODID);
	public static final RegistryObject<CreativeModeTab> CHAOS_DELIGHT = REGISTRY.register("chaos_delight",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.chaosdelight.chaos_delight")).icon(() -> new ItemStack(ChaosdelightModItems.ULTIMATE_KNIFE.get())).displayItems((parameters, tabData) -> {

				//knives
				tabData.accept(ChaosdelightModItems.ULTIMATE_KNIFE.get().getDefaultInstance());
				tabData.accept(ChaosdelightModItems.RUBY_KNIFE.get().getDefaultInstance());
				tabData.accept(ChaosdelightModItems.KUNZITE_KNIFE.get());
				tabData.accept(ChaosdelightModItems.EMERALD_KNIFE.get().getDefaultInstance());
				//cats eye
				//pink tourmaline
				tabData.accept(ChaosdelightModItems.KYANITE_KNIFE.get().getDefaultInstance());
				tabData.accept(ChaosdelightModItems.CRYSTALWOOD_KNIFE.get().getDefaultInstance());
				tabData.accept(ChaosdelightModItems.LITTLE_BERTHA.get().getDefaultInstance());
                //ingredients
				tabData.accept(ChaosdelightModItems.HERCULES_BEETLE_LEG.get());
				tabData.accept(ChaosdelightModItems.HERCULES_BEETLE_WING.get());
				tabData.accept(ChaosdelightModItems.RAW_STINK_BUG_CHOPS.get());
				tabData.accept(ChaosdelightModItems.COOKED_STINK_BUG_CHOPS.get());
				tabData.accept(ChaosdelightModItems.PINK_CAKE.get());
				tabData.accept(ChaosdelightModItems.TITANIUM_PIE_CRUST.get());
				//foods
				tabData.accept(ChaosdelightModBlocks.ULTIMATE_APPLE_PIE.get().asItem());
				tabData.accept(ChaosdelightModItems.ULTIMATE_APPLE_PIE_SLICE.get());
				tabData.accept(ChaosdelightModItems.ULTIMATE_POPSICLE.get());
				tabData.accept(ChaosdelightModItems.RADIOACTIVE_MIX.get());
				tabData.accept(ChaosdelightModItems.GOLDEN_SALAD.get());
				tabData.accept(ChaosdelightModItems.ENCHANTED_GOLDEN_SALAD.get());
				tabData.accept(ChaosdelightModItems.MAN_MEME_STEAK.get());

			}).build());
}