package desutine.specorium.registry;

import desutine.specorium.Reference;
import desutine.specorium.Specorium;
import desutine.specorium.item.ItemAscendedSpecoriumIngot;
import desutine.specorium.item.ItemSpecoriumIngot;
import desutine.specorium.item.ItemSpecoriumNugget;
import desutine.specorium.item.ItemTaintedSpecoriumIngot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModItems {
    public static final Item SPECORIUM_NUGGET = new ItemSpecoriumNugget();
    public static final Item SPECORIUM_INGOT = new ItemSpecoriumIngot();
    public static final Item SPECORIUM_TAINTED_INGOT = new ItemTaintedSpecoriumIngot();
    public static final Item SPECORIUM_ASCENDED_INGOT = new ItemAscendedSpecoriumIngot();

    public static void init() {
        final Map<Integer, String> colors = new HashMap<Integer, String>();
        for (int i = 0; i < 9; i++) {
            colors.put(i, "inventory");
        }

        registerItem(SPECORIUM_NUGGET, Reference.Names.SPECORIUM_NUGGET, colors);
        registerItem(SPECORIUM_INGOT, Reference.Names.SPECORIUM_INGOT, colors);
        registerItem(SPECORIUM_TAINTED_INGOT, Reference.Names.SPECORIUM_TAINTED_INGOT);
        registerItem(SPECORIUM_ASCENDED_INGOT, Reference.Names.SPECORIUM_ASCENDED_INGOT);
    }


    private static void registerItem(Item item, String name) {
        final Map<Integer, String> emptyMap = Collections.emptyMap();
        registerItem(item, name, emptyMap);
    }

    private static void registerItem(Item item, String name, Map<Integer, String> mappings) {
        if (item.getRegistryName() == null)
            item.setRegistryName(name);

        item.setCreativeTab(Specorium.CREATIVE_TAB);
        item.setUnlocalizedName(name);
        GameRegistry.register(item);
        Specorium.proxy.registerInventoryModel(item, mappings);
    }
}
