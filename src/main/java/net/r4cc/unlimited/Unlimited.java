package net.r4cc.unlimited;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.model.renderable.BakedModelRenderable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.r4cc.unlimited.block.ModBlocks;
import net.r4cc.unlimited.item.ModCreativeModeTabs;
import net.r4cc.unlimited.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Unlimited.MOD_ID)
public class Unlimited
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "unlimited";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "unlimited" namespace

    public Unlimited() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Register MODITEMS
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTabs.UNLIMITED_TAB) {
            event.accept(ModItems.NAMRA_SCALE);
        }

        if(event.getTab() == ModCreativeModeTabs.UNLIMITED_TAB) {
            event.accept(ModBlocks.NAMRA_ORE);
        }
        if(event.getTab() == ModCreativeModeTabs.UNLIMITED_TAB) {
            event.accept(ModBlocks.DEEPSLATE_NAMRA_ORE);
        }

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


        }
    }
}
