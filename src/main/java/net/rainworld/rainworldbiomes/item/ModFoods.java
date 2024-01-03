package net.rainworld.rainworldbiomes.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties POPPED_BUBBLE_FRUIT_FOOD_PROPERTIES = new FoodProperties
        .Builder()
        .nutrition(3)
        .saturationMod(0.3f)
        .build();

    public static final FoodProperties MUSHROOM_FOOD_PROPERTIES = new FoodProperties
        .Builder()
        .nutrition(3)
        .fast()
        .saturationMod(0.3f)
        .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200), 1f)
        .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200), 1f)
        .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200), 1f)
        .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 1f)
        .build();
}