package net.amogusplatina.chaosdelight.item.food;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class HerculesbeetlelegItem extends Item {
	public HerculesbeetlelegItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.4f).meat().build()));
	}
}