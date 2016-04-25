package desutine.specorium.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.Map;

public abstract class Proxy {
    public void registerInventoryModel(Block block, Map<Integer, String> mapping) {
        // NOOP
    }

    public void registerInventoryModel(Item item, Map<Integer, String> mapping) {
        // NOOP
    }

    public void registerColorHandlers() {
        // NOOP
    }
}

