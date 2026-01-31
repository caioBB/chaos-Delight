package net.amogusplatina.chaosdelight.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;

public class UltimateKnifeItemIsCraftedsmeltedProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		itemstack.enchant(Enchantments.KNOCKBACK, 2);
		itemstack.enchant(Enchantments.MOB_LOOTING, 3);
		itemstack.enchant(Enchantments.UNBREAKING, 3);
		itemstack.enchant(Enchantments.FIRE_ASPECT, 2);
	}
}