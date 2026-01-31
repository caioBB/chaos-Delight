package net.amogusplatina.chaosdelight.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class UltimateApplePieSliceItem extends Item {
	public UltimateApplePieSliceItem() {
		super(new Properties().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(8).saturationMod(1f).alwaysEat().build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// effects
		if (!entity.level().isClientSide()) {
			entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 4));
			entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 3));
			entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 4800, 4));
			entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 3));
			entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 7200, 3));
			entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 7200, 3));
		}

		return retval;
	}
}