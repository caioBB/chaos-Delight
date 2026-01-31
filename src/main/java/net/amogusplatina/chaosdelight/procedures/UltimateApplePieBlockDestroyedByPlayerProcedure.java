package net.amogusplatina.chaosdelight.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;

import net.amogusplatina.chaosdelight.init.ChaosdelightModItems;

public class UltimateApplePieBlockDestroyedByPlayerProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (!(entity instanceof LivingEntity living)) return;
        

        boolean hasKnife = living.getMainHandItem()
            .is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("farmersdelight", "tools/knives")));
        
        if (!hasKnife) return;
        

        if (blockstate.getBlock().getStateDefinition().getProperty("bites") instanceof IntegerProperty bitesProp) {
            int currentBites = blockstate.getValue(bitesProp);
            int slices = 4 - currentBites;  // Calcula fatias restantes
            
            if (slices > 0 && world instanceof Level level) {
                ItemStack sliceStack = new ItemStack(ChaosdelightModItems.ULTIMATE_APPLE_PIE_SLICE.get(), slices);
                Block.popResource(level, BlockPos.containing(x, y, z), sliceStack);
            }
        }
    }
}