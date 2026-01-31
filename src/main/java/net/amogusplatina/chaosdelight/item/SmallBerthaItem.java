package net.amogusplatina.chaosdelight.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;

import net.amogusplatina.chaosdelight.procedures.SmallBerthaItemIsCraftedsmeltedProcedure;

public class SmallBerthaItem extends SwordItem {
	public SmallBerthaItem() {
		super(new Tier() {
			public int getUses() {
				return 12000;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 194f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, -2.4f, new Properties());
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		SmallBerthaItemIsCraftedsmeltedProcedure.execute(world, itemstack);
	}
}