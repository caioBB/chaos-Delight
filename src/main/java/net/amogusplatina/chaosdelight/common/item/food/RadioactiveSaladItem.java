package net.amogusplatina.chaosdelight.common.item.food;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class RadioactiveSaladItem extends Item {
	public RadioactiveSaladItem() {
		super(new Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.5f).build()));
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(Items.BOWL);
	}

	// player eats it
	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.BOWL);
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		//effects
		if (!entity.level().isClientSide()) {
			entity.addEffect(new MobEffectInstance(MobEffects.POISON, 240, 1, false, true));
			entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 240, 1, false, true));
			entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1200, 1, false, true));
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2, false, true));
			entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 1200, 3, false, true));
			entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 2, false, true));
			entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 2, false, true));
		}

		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}


	@Override
	public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity Target, InteractionHand pUsedHand) {
		if(!pPlayer.level().isClientSide && !(pPlayer == Target)) {

			if(!pPlayer.isCreative()) {pStack.shrink(1);}

			Target.addEffect(new MobEffectInstance(MobEffects.POISON, 240, 1, false, true));
			Target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 240, 1, false, true));
			Target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1200, 1, false, true));

			Target.level().playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8f, 1.0f);
			return InteractionResult.CONSUME;
		}
		else {return InteractionResult.PASS;}

	}
}