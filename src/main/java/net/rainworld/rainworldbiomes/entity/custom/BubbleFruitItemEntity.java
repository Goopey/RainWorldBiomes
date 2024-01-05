package net.rainworld.rainworldbiomes.entity.custom;

import org.jetbrains.annotations.ApiStatus.OverrideOnly;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.rainworld.rainworldbiomes.item.ModItems;

public class BubbleFruitItemEntity extends ItemEntity {
    private static final int PICKUP_TIME = 20;

    public BubbleFruitItemEntity(Level level, double x, double y, double z, ItemStack itemStack) {
        super(level, x, y, z, itemStack);
    }

    @Override
    public void tick() {
        if (this.isInWater()) {
            ItemEntity poppedBubbleFruitItemEntity = new ItemEntity(
                this.level(),
                this.position().x, 
                this.position().y, 
                this.position().z, 
                new ItemStack(ModItems.POPPED_BUBBLE_FRUIT.get())
            );
            poppedBubbleFruitItemEntity.getItem().setCount(this.getItem().getCount());
            this.discard();
            this.level().addFreshEntity(poppedBubbleFruitItemEntity);
        }

        super.tick();
    }

    public static void spawnBubbleFruitItemEntity(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        Level level = event.getLevel();
        double posX = entity.getX();
        double posY = entity.getY();
        double posZ = entity.getZ();

        if (entity instanceof ItemEntity && !(entity instanceof BubbleFruitItemEntity)) {
            ItemEntity itemEntity = (ItemEntity) entity;

            if (itemEntity.getItem().getItem() == ModItems.BUBBLE_FRUIT.get()) {
                event.setCanceled(true);
                
                BubbleFruitItemEntity bubbleFruitItemEntity = 
                    new BubbleFruitItemEntity(level, posX, posY, posZ, new ItemStack(ModItems.BUBBLE_FRUIT.get()));
                bubbleFruitItemEntity.setPickUpDelay(PICKUP_TIME);
                bubbleFruitItemEntity.setDeltaMovement(entity.getDeltaMovement());
                
                entity.discard();
                level.addFreshEntity(bubbleFruitItemEntity);
            }
        }
    }
}