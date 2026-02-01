/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.amogusplatina.chaosdelight.init;

import net.amogusplatina.chaosdelight.ChaosdelightMod;
import net.amogusplatina.chaosdelight.block.UltimateApplePieBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChaosdelightModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ChaosdelightMod.MODID);
	public static final RegistryObject<Block> ULTIMATE_APPLE_PIE;
	static {
		ULTIMATE_APPLE_PIE = REGISTRY.register("ultimate_apple_pie", UltimateApplePieBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}