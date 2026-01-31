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


public class UltimatepopsicleItem extends Item {
	public UltimatepopsicleItem() {
		super(new Properties().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.5f).alwaysEat().build()));
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
			entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1));
		    entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1));
		    entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3600, 2));
		    entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400, 1));
		    entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4800, 1));

			entity.clearFire();
	    }

		return retval;
	}
}