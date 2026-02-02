package net.amogusplatina.chaosdelight.item.food;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class HerculesBeetleWingItem extends Item {
	public HerculesBeetleWingItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).build()));
	}
}