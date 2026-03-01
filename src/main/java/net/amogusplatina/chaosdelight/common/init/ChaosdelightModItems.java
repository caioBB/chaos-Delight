package net.amogusplatina.chaosdelight.common.init;

import net.amogusplatina.chaosdelight.ChaosdelightMod;
import net.amogusplatina.chaosdelight.common.item.FoilBlockItem;
import net.amogusplatina.chaosdelight.common.item.food.*;
import net.amogusplatina.chaosdelight.common.item.knifes.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
	public static final RegistryObject<Item> TITANIUM_PIE_CRUST;
	public static final RegistryObject<Item> ENCHANTED_GOLDEN_SALAD;
	public static final RegistryObject<Item> LITTLE_BERTHA;
	public static final RegistryObject<Item> PINK_CAKE;
	public static final RegistryObject<Item> HERCULES_BEETLE_LEG;
	public static final RegistryObject<Item> MAN_MEME_STEAK;
	public static final RegistryObject<Item> HERCULES_BEETLE_WING;
	public static final RegistryObject<Item> ULTIMATE_POPSICLE;
	public static final RegistryObject<Item> RAW_STINK_BUG_CHOPS;
	public static final RegistryObject<Item> COOKED_STINK_BUG_CHOPS;
	static {
		RADIOACTIVE_MIX = REGISTRY.register("radioactive_mix", RadioactiveSaladItem::new);

		RUBY_KNIFE = REGISTRY.register("ruby_knife", RubyKnifeItem::new);
		TIGERS_EYE_KNIFE = REGISTRY.register("tigers_eye_knife", TigersEyeKnifeItem::new);
		ULTIMATE_KNIFE = REGISTRY.register("ultimate_knife", UltimateKnifeItem::new);
		AMETHYST_KNIFE = REGISTRY.register("amethyst_knife", AmethystKnifeItem::new);
		EMERALD_KNIFE = REGISTRY.register("emerald_knife", EmeraldKnifeItem::new);
		LITTLE_BERTHA = REGISTRY.register("little_bertha", LittleBerthaItem::new);


		ENCHANTED_GOLDEN_SALAD = REGISTRY.register("enchanted_golden_salad", EnchantedGoldenSaladItem::new);
		GOLDEN_SALAD = REGISTRY.register("golden_salad", GoldenSaladItem::new);

		ULTIMATE_APPLE_PIE = block(ChaosdelightModBlocks.ULTIMATE_APPLE_PIE, new Item.Properties().fireResistant(), true);
		ULTIMATE_APPLE_PIE_SLICE = REGISTRY.register("ultimate_apple_pie_slice", UltimateApplePieSliceItem::new);
		TITANIUM_PIE_CRUST = REGISTRY.register("titanium_pie_crust", () -> new Item(new Item.Properties().fireResistant()));
		ULTIMATE_POPSICLE = REGISTRY.register("ultimate_popsicle", UltimatePopsicleItem::new);
		PINK_CAKE = REGISTRY.register("pink_cake", () -> new Item(
				new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

		MAN_MEME_STEAK = REGISTRY.register("man_meme_steak", ManMemeSteakItem::new);

		HERCULES_BEETLE_LEG = REGISTRY.register("hercules_beetle_leg", () -> new Item(
				new Item.Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.4f).meat().build())));
		HERCULES_BEETLE_WING = REGISTRY.register("hercules_beetle_wing", () -> new Item(
				new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).build())));

		RAW_STINK_BUG_CHOPS = REGISTRY.register("raw_stink_bug_chops", () -> new StinkBugChopsItem((
				new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.5f).build()))));
		COOKED_STINK_BUG_CHOPS = REGISTRY.register("cooked_stink_bug_chops", () -> new StinkBugChopsItem((
				new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5f).build()))));
	}



	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties, boolean isFoil) {
		return REGISTRY.register(block.getId().getPath(), () -> isFoil ? new FoilBlockItem(block.get(), properties) : new BlockItem(block.get(), properties));
	}
}