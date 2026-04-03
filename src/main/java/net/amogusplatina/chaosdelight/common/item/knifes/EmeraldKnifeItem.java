package net.amogusplatina.chaosdelight.common.item.knifes;

import net.amogusplatina.chaosdelight.common.item.EnchantedKnifeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import io.github.chaosawakens.core.template.CAItemTierTemplates;
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
        super(CAItemTierTemplates.EMERALD
                , 0
                , -2f
                , new Properties()
                , getBaseEnchants()
        );

    }
}