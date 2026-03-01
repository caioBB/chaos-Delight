package net.amogusplatina.chaosdelight.common.item.food;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public class StinkBugChopsItem extends Item {
    public StinkBugChopsItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        String key = this.getDescriptionId();
        list.add(Component.translatable(key + ".description_0"));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = new ItemStack(Items.BOWL);
        super.finishUsingItem(itemstack, world, entity);

        //effect
        Random random = new Random();

        if ( random.nextInt(100) > 75 ) {
            entity.addEffect(new MobEffectInstance(MobEffects.POISON, 256, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 560, 1));
        }

        if (itemstack.isEmpty()) {
            return retval;
        } else {
            if (entity instanceof Player player && !player.getAbilities().instabuild) {
                if (!player.getInventory().add(retval))
                    player.drop(retval, false);
            }
            return itemstack;
        }
    }
}
