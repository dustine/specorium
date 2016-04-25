package desutine.specorium.registry;

import desutine.specorium.Specorium;
import desutine.specorium.block.BlockAscendedSpecorium;
import desutine.specorium.block.BlockSpecoriumOre;
import desutine.specorium.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModBlocks {
    public static final Block SPECORIUM_ORE = new BlockSpecoriumOre();
    public static final Block ASCENDED_SPECORIUM = new BlockAscendedSpecorium();

    public static void init() {
        registerBlock(ASCENDED_SPECORIUM, Reference.Names.ASCENDED_SPECORIUM, null, null);

        final HashMap<Integer, String> mapping = new HashMap<Integer, String>();
        mapping.put(0, "world=overworld");
        mapping.put(1, "world=nether");
        mapping.put(2, "world=end");
        registerBlock(SPECORIUM_ORE, Reference.Names.SPECORIUM_ORE, new ItemBlock(SPECORIUM_ORE) {
            @Override
            public int getMetadata(int damage) {
                if (damage >= 0 && damage <= 2) return damage;
                return 0;
            }
        }, mapping);
    }

    /**
     * Registers a block
     *
     * @param block     Block instance
     * @param name      Unlocalized block name
     * @param itemBlock Correspondent ItemBlock for this block, set null for default
     * @param mapping   Mappings from meta to submodel, set null for default
     */
    private static void registerBlock(final Block block, String name, ItemBlock itemBlock, Map<Integer, String> mapping) {
        block.setRegistryName(name);

        block.setCreativeTab(Specorium.CREATIVE_TAB);
        block.setUnlocalizedName(name);
        GameRegistry.register(block);

        if (itemBlock == null) itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(name);
        GameRegistry.register(itemBlock);

        if (mapping == null) mapping = Collections.emptyMap();
        Specorium.proxy.registerInventoryModel(block, mapping);
    }

}
