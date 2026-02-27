package net.amogusplatina.chaosdelight.common.block;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.ForgeEventFactory;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;

import java.util.function.Supplier;

public class UltimatePieBlock extends PieBlock {
	public UltimatePieBlock(Properties properties, Supplier<Item> pieSlice) {
		super(properties, pieSlice);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack heldStack = player.getItemInHand(hand);
		if (level.isClientSide) {
			if (heldStack.is(ModTags.KNIVES)) {
				return cutSlice(level, pos, state, player);
			}

			if (this.consumeBite(level, pos, state, player) == InteractionResult.SUCCESS) {
				return InteractionResult.SUCCESS;
			}

			if (heldStack.isEmpty()) {
				return InteractionResult.CONSUME;
			}
		}

		if (heldStack.is(ModTags.KNIVES)) {
			return cutSlice(level, pos, state, player);
		}
		return this.consumeBite(level, pos, state, player);
	}

	protected InteractionResult consumeBite(Level level, BlockPos pos, BlockState state, Player playerIn) {
		if (!playerIn.canEat(false)) {
			return InteractionResult.PASS;
		} else {
			ItemStack sliceStack = this.getPieSliceItem();
			ItemStack sliceCopy = sliceStack.copy();
			FoodProperties sliceFood = sliceStack.getItem().getFoodProperties();

			playerIn.getFoodData().eat(sliceStack.getItem(), sliceStack);
			// Fire an event for food-tracking mods like Spice of Life, but ignore the result.
			ForgeEventFactory.onItemUseFinish(playerIn, sliceCopy, 0, ItemStack.EMPTY);
			if (this.getPieSliceItem().getItem().isEdible() && sliceFood != null) {
				for (Pair<MobEffectInstance, Float> pair : sliceFood.getEffects()) {
					if (!level.isClientSide && pair.getFirst() != null && level.random.nextFloat() < pair.getSecond()) {
						playerIn.addEffect(new MobEffectInstance(pair.getFirst()));
					}
				}
			}

			int bites = state.getValue(BITES);
			if (bites < getMaxBites() - 1) {
				level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
			} else {
				level.removeBlock(pos, false);
			}
			playerIn.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 4));
			playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 3));
			playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 4800, 4));
			playerIn.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 3));
			playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 7200, 3));
			playerIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 7200, 3));
			level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
			return InteractionResult.SUCCESS;
		}
	}

	protected InteractionResult cutSlice(Level level, BlockPos pos, BlockState state, Player player) {
		int bites = state.getValue(BITES);
		if (bites < getMaxBites() - 1) {
			level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
		} else {
			level.removeBlock(pos, false);
		}

		Direction direction = player.getDirection().getOpposite();
		ItemUtils.spawnItemEntity(level, this.getPieSliceItem(), pos.getX() + 0.5, pos.getY() + 0.3, pos.getZ() + 0.5,
				direction.getStepX() * 0.15, 0.05, direction.getStepZ() * 0.15);
		level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
		return InteractionResult.SUCCESS;
	}
}