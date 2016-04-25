package desutine.specorium.proxy;

import desutine.specorium.client.color.ColorSpecorium;
import desutine.specorium.client.color.ColorToastedSpecorium;
import desutine.specorium.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import java.util.Map;

public class ClientProxy extends Proxy {
    @Override
    public void registerInventoryModel(Block block, Map<Integer, String> mapping) {
        super.registerInventoryModel(block, mapping);

        registerInventoryModel(Item.getItemFromBlock(block), mapping);
    }

    @Override
    public void registerInventoryModel(Item item, Map<Integer, String> mapping) {
        super.registerInventoryModel(item, mapping);

        if (mapping.isEmpty()) {
            ModelLoader.setCustomModelResourceLocation(item, 0,
                    new ModelResourceLocation(item.getRegistryName(), "inventory"));
        } else {
            for (Integer meta : mapping.keySet()) {
                ModelLoader.setCustomModelResourceLocation(item, meta,
                        new ModelResourceLocation(item.getRegistryName(), mapping.get(meta)));
            }
        }
    }

    @Override
    public void registerColorHandlers() {
        super.registerColorHandlers();

        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ColorSpecorium(), ModItems.SPECORIUM_NUGGET);
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ColorSpecorium(), ModItems.SPECORIUM_INGOT);
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ColorToastedSpecorium(), ModItems.SPECORIUM_TAINTED_INGOT);
    }
}
