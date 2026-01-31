package net.amogusplatina.chaosdelight.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;

public class SmallBerthaItemIsCraftedsmeltedProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		itemstack.enchant(Enchantments.BANE_OF_ARTHROPODS, 3);
		itemstack.enchant(Enchantments.FIRE_ASPECT, 2);
		itemstack.enchant(Enchantments.KNOCKBACK, 2);
	}
}