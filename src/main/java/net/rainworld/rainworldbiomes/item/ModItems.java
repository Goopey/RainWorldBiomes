package net.rainworld.rainworldbiomes.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rainworld.rainworldbiomes.RainWorldBiomes;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, RainWorldBiomes.MODID);

    public static final RegistryObject<Item> BUBBLE_FRUIT = ITEMS.register("bubble_fruit", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POPPED_BUBBLE_FRUIT = ITEMS.register("popped_bubble_fruit", 
        () -> new Item(new Item.Properties().food(ModFoods.POPPED_BUBBLE_FRUIT_FOOD_PROPERTIES)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
