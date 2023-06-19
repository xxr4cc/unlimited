package net.r4cc.unlimited.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class DragonScale extends Item{

    public DragonScale(Properties properties) {
        super(properties);

    }

    @Override
    public Rarity getRarity(ItemStack properties) {
        return Rarity.EPIC;
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

}
