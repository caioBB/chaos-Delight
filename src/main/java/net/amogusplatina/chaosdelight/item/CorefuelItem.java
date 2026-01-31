package net.amogusplatina.chaosdelight.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CorefuelItem extends Item {
	public CorefuelItem() {
		super(new Properties().fireResistant().rarity(Rarity.EPIC));
	}
}