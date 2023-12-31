package net.r4cc.unlimited.item;

//IMPORTS
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.r4cc.unlimited.Unlimited;
import net.r4cc.unlimited.item.custom.DragonScale;

//MODITEMS CLASS
public class ModItems {

    //CREATE ITEMS
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Unlimited.MOD_ID);


    //ITEMS

    //NAMRA_SCALE
    public  static final RegistryObject<DragonScale> NAMRA_SCALE = ITEMS.register("namra_scale",
            () -> new DragonScale(new DragonScale.Properties()));


    //SEND EVENT BUS
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }

}
