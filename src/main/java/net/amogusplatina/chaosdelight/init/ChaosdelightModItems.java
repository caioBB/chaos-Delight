package net.amogusplatina.chaosdelight.init;

import net.amogusplatina.chaosdelight.item.*;
import net.amogusplatina.chaosdelight.item.food.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.amogusplatina.chaosdelight.item.*;
import net.amogusplatina.chaosdelight.ChaosdelightMod;

public class ChaosdelightModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ChaosdelightMod.MODID);
	public static final RegistryObject<Item> RADIOACTIVE_MIX;
	public static final RegistryObject<Item> RUBY_KNIFE;
	public static final RegistryObject<Item> TIGERS_EYE_KNIFE;
	public static final RegistryObject<Item> ULTIMATE_KNIFE;
	public static final RegistryObject<Item> AMETHYST_KNIFE;
	public static final RegistryObject<Item> EMERALD_KNIFE;
	public static final RegistryObject<Item> GOLDEN_SALAD;
	public static final RegistryObject<Item> ULTIMATE_APPLE_PIE;
	public static final RegistryObject<Item> ULTIMATE_APPLE_PIE_SLICE;
	public static final RegistryObject<Item> TITANIUMPIECRUST;
	public static final RegistryObject<Item> ENCHANTED_GOLDEN_SALAD;
	public static final RegistryObject<Item> LITTLE_BERTHA;
	public static final RegistryObject<Item> PINK_CAKE;
	public static final RegistryObject<Item> HERCULES_BEETLE_LEG;
	public static final RegistryObject<Item> MAN_MEME_STEAK;
	public static final RegistryObject<Item> HERCULESBEETLEWING;
	public static final RegistryObject<Item> ULTIMATE_POPSICLE;
	static {
		RADIOACTIVE_MIX = REGISTRY.register("radioactive_mix", RadioactivemealItem::new);
		RUBY_KNIFE = REGISTRY.register("ruby_knife", Knifes::RubyKnifeItem); //--------
		TIGERS_EYE_KNIFE = REGISTRY.register("tigers_eye_knife", TigersEyeKnifeItem::new);  //--------
		ULTIMATE_KNIFE = REGISTRY.register("ultimate_knife", UltimateKnifeItem::new);  //--------
		AMETHYST_KNIFE = REGISTRY.register("amethyst_knife", Knifes::AmethystknifeItem);  //--------
		EMERALD_KNIFE = REGISTRY.register("emerald_knife", Knifes::EmeraldKnifeItem); //--------
		GOLDEN_SALAD = REGISTRY.register("golden_salad", GoldenSaladItem::new);
		ULTIMATE_APPLE_PIE = block(ChaosdelightModBlocks.ULTIMATE_APPLE_PIE);
		ULTIMATE_APPLE_PIE_SLICE = REGISTRY.register("ultimate_apple_pie_slice", UltimateApplePieSliceItem::new);
		TITANIUMPIECRUST = REGISTRY.register("titaniumpiecrust", TitaniumpiecrustItem::new);
		ENCHANTED_GOLDEN_SALAD = REGISTRY.register("enchanted_golden_salad", EnchantedGoldenSaladItem::new);
		LITTLE_BERTHA = REGISTRY.register("little_bertha", SmallBerthaItem::new); //--------
		PINK_CAKE = REGISTRY.register("pink_cake", CorefuelItem::new);
		HERCULES_BEETLE_LEG = REGISTRY.register("hercules_beetle_leg", HerculesbeetlelegItem::new);
		MAN_MEME_STEAK = REGISTRY.register("man_meme_steak", ManmemesteakItem::new);
		HERCULESBEETLEWING = REGISTRY.register("herculesbeetlewing", HerculesbeetlewingItem::new);
		ULTIMATE_POPSICLE = REGISTRY.register("ultimate_popsicle", UltimatepopsicleItem::new);
	}


	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return block(block, new Item.Properties());
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}