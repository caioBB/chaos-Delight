package net.amogusplatina.chaosdelight.common.init;

import net.amogusplatina.chaosdelight.ChaosdelightMod;
import net.amogusplatina.chaosdelight.common.block.UltimatePieBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ChaosdelightModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ChaosdelightMod.MODID);
	public static final RegistryObject<Block> ULTIMATE_APPLE_PIE;
	static {
		ULTIMATE_APPLE_PIE = REGISTRY.register("ultimate_apple_pie", () -> new UltimatePieBlock(Block.Properties.copy(Blocks.CAKE).explosionResistance(10f), ChaosdelightModItems.ULTIMATE_APPLE_PIE_SLICE));
	}
}