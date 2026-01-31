package net.amogusplatina.chaosdelight.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;

public class RubyknifeItemIsCraftedsmeltedProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		itemstack.enchant(Enchantments.FIRE_ASPECT, 1);
	}
}