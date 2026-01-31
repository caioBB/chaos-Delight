package net.amogusplatina.chaosdelight.procedures;


import net.amogusplatina.chaosdelight.init.ChaosdelightModItems;


import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;


import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;

@SuppressWarnings("deprecation")
public class UltimateApplePieOnBlockRightClicked1Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
            
        BlockPos pos = BlockPos.containing(x, y, z);
        BlockState blockState = world.getBlockState(pos);
        

        IntegerProperty BITES_PROP = null;

        for (Property<?> prop : blockState.getProperties()) {
            if (prop.getName().equals("bites") && prop instanceof IntegerProperty) {
                BITES_PROP = (IntegerProperty) prop;
                break;
            }
        }
        

        if (BITES_PROP == null) {
            System.err.println("ERRO: Bloco não possui propriedade 'bites' em " + pos);
            return;
        }
        

        int currentBites = blockState.getValue(BITES_PROP);

        
        boolean hasKnife = (entity instanceof LivingEntity _livEnt ? 
                           _livEnt.getMainHandItem() : ItemStack.EMPTY)
                          .is(ItemTags.create(new ResourceLocation("farmersdelight:tools/knives")));
        
        if (!hasKnife) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, pos, 
                        ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")),
                        SoundSource.PLAYERS, 0.8F, 0.8F);
                }
            }
            
            if (entity instanceof Player _player)
                _player.getFoodData().setFoodLevel(8 + (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0));
            if (entity instanceof Player _player)
                _player.getFoodData().setSaturation((float) (1 + (entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0)));
            

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 4));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 3));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 4800, 4));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 3));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 7200, 3));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 7200, 3));
                

            currentBites++;
            
        } else {
            if (world instanceof Level _level && entity instanceof LivingEntity livingEntity) {
                if (!_level.isClientSide()) {
                	
                    _level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
                    

                    Direction direction = livingEntity.getDirection().getOpposite();
                    

                    ItemStack sliceStack = new ItemStack(ChaosdelightModItems.ULTIMATE_APPLE_PIE_SLICE.get(), 1);
                    

                    double spawnX = pos.getX() + 0.5;
                    double spawnY = pos.getY() + 0.3;
                    double spawnZ = pos.getZ() + 0.5;
                    
                    double velocityX = direction.getStepX() * 0.15;
                    double velocityY = 0.05;
                    double velocityZ = direction.getStepZ() * 0.15;
                    

                    ItemEntity itemEntity = new ItemEntity(_level, spawnX, spawnY, spawnZ, sliceStack);
                    itemEntity.setDeltaMovement(velocityX, velocityY, velocityZ);
                    _level.addFreshEntity(itemEntity);
                }
            } else {
                // Fallback caso não seja um Level válido
                System.err.println("AVISO: Não foi possível dropar a fatia - mundo ou entidade inválida.");
            }

            currentBites++;
        }
        

        if (currentBites <= BITES_PROP.getPossibleValues().stream().max(Integer::compare).orElse(3)) {
            BlockState newState = blockState.setValue(BITES_PROP, currentBites);
            world.setBlock(pos, newState, 3); 
        } else {
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        }
    }
}