package net.amogusplatina.chaosdelight.common.item.knifes;

import net.amogusplatina.chaosdelight.common.item.EnchantedKnifeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import io.github.chaosawakens.core.template.CAItemTierTemplates;
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
        super(CAItemTierTemplates.RUBY
                , 5
                , -2f
                , new Properties().rarity(Rarity.UNCOMMON).fireResistant()
                , getBaseEnchants()
        );

    }
}