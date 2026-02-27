package net.amogusplatina.chaosdelight.common.item.knifes;

import net.amogusplatina.chaosdelight.common.item.EnchantedKnifeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.HashMap;
import java.util.Map;


public class EmeraldKnifeItem extends EnchantedKnifeItem {
    public static Map<Enchantment, Integer> getBaseEnchants() {
        Map<Enchantment, Integer> baseEnchants = new HashMap<>();
        baseEnchants.put(Enchantments.MOB_LOOTING, 1);
        return baseEnchants;
    }

    public EmeraldKnifeItem() {
        super(new Tier() {
                  public int getUses() {return 1300;}
                  public float getSpeed() {return 4f;}
                  public float getAttackDamageBonus() {return -2.5f;}
                  public int getLevel() {return 3;}
                  public int getEnchantmentValue() {return 2;}
                  public Ingredient getRepairIngredient() {return Ingredient.of(Items.EMERALD);}
              }
                , 5
                , -2f
                , new Properties().rarity(Rarity.RARE)
                , getBaseEnchants()
        );

    }
}