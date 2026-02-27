package net.amogusplatina.chaosdelight.common.loot;

import net.amogusplatina.chaosdelight.common.init.ChaosdelightModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootModifier {
    // tables
    private static final ResourceLocation HerculesBeetle = Blocks.COAL_BLOCK.getLootTable(); //=  insect.HerculesBeetleEntity.getLootTable(); place holder**

    @SubscribeEvent
    public void onLootTableLoad(LootTableLoadEvent event) {
        if (event.getName().equals(HerculesBeetle)) {
            LootPool.Builder beetleLeg = LootPool.lootPool()
                    .setRolls(BinomialDistributionGenerator.binomial(4, 0.5F))
                    .add(LootItem.lootTableItem(ChaosdelightModItems.HERCULES_BEETLE_LEG.get()));

            LootPool.Builder beetleWing = LootPool.lootPool()
                    .setRolls(BinomialDistributionGenerator.binomial(2, 0.5F))
                    .add(LootItem.lootTableItem(ChaosdelightModItems.HERCULES_BEETLE_WING.get()));


            event.getTable().addPool(beetleLeg.build());
            event.getTable().addPool(beetleWing.build());
        }
    }
}
