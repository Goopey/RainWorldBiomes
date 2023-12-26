package net.rainworld.rainworldbiomes.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rainworld.rainworldbiomes.RainWorldBiomes;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RainWorldBiomes.MODID);

    public static final RegistryObject<CreativeModeTab> RWB_FOOD = CREATIVE_MODE_TAB.register(
        "RWB Foods", 
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BUBBLE_FRUIT.get()))
            .title(Component.translatable("creativetab.rwb_foods"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.BUBBLE_FRUIT.get());
                pOutput.accept(ModItems.POPPED_BUBBLE_FRUIT.get());
            })
            .build()
        );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
