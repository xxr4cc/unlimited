package net.r4cc.unlimited.item;


import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.r4cc.unlimited.Unlimited;

@Mod.EventBusSubscriber(modid = Unlimited.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab UNLIMITED_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        UNLIMITED_TAB = event.registerCreativeModeTab(new ResourceLocation(Unlimited.MOD_ID, "unlimited_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.NAMRA_SCALE.get()))
                        .title(Component.translatable("creativemodetab.unlimited_tab")));
    }
}
