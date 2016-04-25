package desutine.specorium.registry;

import desutine.specorium.Reference;
import desutine.specorium.Specorium;
import desutine.specorium.block.BlockSpecoriumOre;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {
    public static final Block SPECORIUM_ORE = new BlockSpecoriumOre();

    public static void init() {
        SPECORIUM_ORE.setRegistryName(Reference.Names.SPECORIUM_ORE);

        SPECORIUM_ORE.setCreativeTab(Specorium.CREATIVE_TAB);
        SPECORIUM_ORE.setUnlocalizedName(Reference.Names.SPECORIUM_ORE);
        GameRegistry.register(SPECORIUM_ORE);

        final ItemBlock itemBlock = new ItemBlock(SPECORIUM_ORE) {
            @Override
            public int getMetadata(int damage) {
                if (damage >= 0 && damage <= 2) return damage;
                return 0;
            }
        };
        itemBlock.setRegistryName(SPECORIUM_ORE.getRegistryName());
        itemBlock.setUnlocalizedName(SPECORIUM_ORE.getUnlocalizedName());
        GameRegistry.register(itemBlock);

        final Map<Integer, String> metas = new HashMap<Integer, String>();
        metas.put(0, "world=overworld");
        metas.put(1, "world=nether");
        metas.put(2, "world=end");
        Specorium.proxy.registerInventoryModel(SPECORIUM_ORE, metas);
    }

}
