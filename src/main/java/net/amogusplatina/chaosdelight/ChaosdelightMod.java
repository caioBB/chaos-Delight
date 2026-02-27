package net.amogusplatina.chaosdelight;

import net.amogusplatina.chaosdelight.common.init.ChaosdelightModBlocks;
import net.amogusplatina.chaosdelight.common.init.ChaosdelightModItems;
import net.amogusplatina.chaosdelight.common.init.ChaosdelightModTabs;
import net.amogusplatina.chaosdelight.common.loot.LootModifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("chaosdelight")
public class ChaosdelightMod {
	public static final Logger LOGGER = LogManager.getLogger(ChaosdelightMod.class);
	public static final String MODID = "chaosdelight";

	public ChaosdelightMod(FMLJavaModLoadingContext context) {

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new LootModifier());
		IEventBus bus = context.getModEventBus();
		ChaosdelightModBlocks.REGISTRY.register(bus);
		ChaosdelightModItems.REGISTRY.register(bus);
		ChaosdelightModTabs.REGISTRY.register(bus);

	}
}