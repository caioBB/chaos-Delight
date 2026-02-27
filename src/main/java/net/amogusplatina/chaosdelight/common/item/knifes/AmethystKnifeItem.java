package net.amogusplatina.chaosdelight.common.item.knifes;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.item.KnifeItem;


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