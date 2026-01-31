package net.amogusplatina.chaosdelight.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import vectorwing.farmersdelight.common.item.KnifeItem;

import java.util.Map;
import java.util.Set;

public class CDKnifeItem extends KnifeItem
{
    public Map<Enchantment, Integer> baseEnchants;

    public CDKnifeItem(Tier tier, float attackDamage, float attackSpeed, Properties properties, Map<Enchantment, Integer> baseEnchants) {
        super(tier, attackDamage, attackSpeed, properties);
        this.baseEnchants = baseEnchants;
    }

    public void applyEnchantments(ItemStack itemStack) {
        if (this.baseEnchants != null) {
            for (Map.Entry<Enchantment, Integer> entry : this.baseEnchants.entrySet()) {
                itemStack.enchant(entry.getKey(), entry.getValue());
            }
        }
    }
}