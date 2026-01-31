package net.amogusplatina.chaosdelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.FireAspectEnchantment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Knifes {
    // returning the knifes, so i don't need to do all in the init... Cleaner :)
    // Also makes possible the pre-made enchantments in the Creative Tab and JEI, and a lot of other stuff.
    public static CDKnifeItem AmethystknifeItem()
    {
        Map<Enchantment, Integer> baseEnchants = new HashMap<>();

        return new CDKnifeItem( //parameters
                // Tier
                new Tier() {
                    public int getUses() { return 2700; }
                    public float getSpeed() { return 4f; }
                    public float getAttackDamageBonus() { return 3f; }
                    public int getLevel() { return 3; }
                    public int getEnchantmentValue() { return 2; }
                    public Ingredient getRepairIngredient() { return Ingredient.of(); }}
                , 3
                , -2f
                , new Item.Properties().setNoRepair()
                , baseEnchants
        );
    }

    public static CDKnifeItem EmeraldKnifeItem()
    {
        Map<Enchantment, Integer> baseEnchants = new HashMap<>();
        baseEnchants.put(Enchantments.MOB_LOOTING, 1);

        return new CDKnifeItem( // parameters
                new Tier() {
                    public int getUses() { return 1300;}
                    public float getSpeed() { return 4f; }
                    public float getAttackDamageBonus() { return -2.5f; }
                    public int getLevel() { return 3; }
                    public int getEnchantmentValue() { return 2; }
                    public Ingredient getRepairIngredient() { return Ingredient.of(Items.EMERALD); }
                }
                , 3
                , -2f
                , new Item.Properties().rarity(Rarity.RARE)
                , baseEnchants
        );
    }

    public static CDKnifeItem RubyKnifeItem()
    {
        Map<Enchantment, Integer> baseEnchants = new HashMap<>();
        baseEnchants.put(Enchantments.FIRE_ASPECT, 1);


        return new CDKnifeItem( // parameters
                new Tier() {
                    public int getUses() { return 3000;}
                    public float getSpeed() { return 4f; }
                    public float getAttackDamageBonus() { return 7f; }
                    public int getLevel() { return 4; }
                    public int getEnchantmentValue() { return 2; }
                    public Ingredient getRepairIngredient() { return Ingredient.of(); }
                }
                , 3
                , -2f
                , new Item.Properties().setNoRepair().rarity(Rarity.RARE)
                , baseEnchants
        );
    }
}
