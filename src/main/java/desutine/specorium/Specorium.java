package desutine.specorium;

import desutine.specorium.proxy.Proxy;
import desutine.specorium.registry.ModBlocks;
import desutine.specorium.registry.ModItems;
import desutine.specorium.registry.ModRecipes;
import desutine.specorium.utility.Log;
import desutine.specorium.world.gen.WorldGeneratorSpecorium;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Specorium {
    public static final CreativeTabs CREATIVE_TAB = new CreativeTabs(Reference.MODID) {
        @Override
        public Item getTabIconItem() {
            return ModItems.SPECORIUM_ASCENDED_INGOT;
        }
    };

    @Mod.Instance(Reference.MODID)
    public static Specorium instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static Proxy proxy;

    private static Log log;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Specorium.log = new Log(event.getModLog());
        ModBlocks.init();
        ModItems.init();
        GameRegistry.registerWorldGenerator(new WorldGeneratorSpecorium(), 0);

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerColorHandlers();
        ModRecipes.init();
    }
}
