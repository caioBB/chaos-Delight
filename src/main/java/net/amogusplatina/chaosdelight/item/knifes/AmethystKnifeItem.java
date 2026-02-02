package net.amogusplatina.chaosdelight.item.knifes;

import net.amogusplatina.chaosdelight.item.EnchantedKnifeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import vectorwing.farmersdelight.common.item.KnifeItem;

import java.util.HashMap;
import java.util.Map;


public class AmethystKnifeItem extends KnifeItem {
    public AmethystKnifeItem() {
        super(new Tier() {
                  public int getUses() {return 2700;}
                  public float getSpeed() {return 4f;}
                  public float getAttackDamageBonus() {return 3f;}
                  public int getLevel() {return 3;}
                  public int getEnchantmentValue() {return 2;}
                  public Ingredient getRepairIngredient() {return Ingredient.of();}
              }
                , 5
                , -2f
                , new Properties().setNoRepair()
        );

    }
}