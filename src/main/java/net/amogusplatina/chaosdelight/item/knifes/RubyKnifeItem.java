package net.amogusplatina.chaosdelight.item.knifes;

import net.amogusplatina.chaosdelight.item.EnchantedKnifeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.HashMap;
import java.util.Map;


public class RubyKnifeItem extends EnchantedKnifeItem {
    public static Map<Enchantment, Integer> getBaseEnchants() {
        Map<Enchantment, Integer> baseEnchants = new HashMap<>();
        baseEnchants.put(Enchantments.FIRE_ASPECT, 1);
        return baseEnchants;
    }

    public RubyKnifeItem() {
        super(new Tier() {
                  public int getUses() {return 3000;}
                  public float getSpeed() {return 4f;}
                  public float getAttackDamageBonus() {return 7f;}
                  public int getLevel() {return 4;}
                  public int getEnchantmentValue() {return 2;}
                  public Ingredient getRepairIngredient() {return Ingredient.of();}
              }
                , 5
                , -2f
                , new Properties().rarity(Rarity.RARE).fireResistant().setNoRepair()
                , getBaseEnchants()
        );

    }
}