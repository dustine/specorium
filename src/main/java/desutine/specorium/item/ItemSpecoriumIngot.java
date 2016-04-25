package desutine.specorium.item;

import desutine.specorium.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemSpecoriumIngot extends Item {
    public ItemSpecoriumIngot() {
        setHasSubtypes(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
//        super.getSubItems(itemIn, tab, subItems);
        subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, 0)); // Red
        subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, 1)); // Orange
        subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, 2)); // Yellow
        subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, 3)); // Green
        subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, 4)); // Cyan
        subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, 5)); // Blue
        subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, 6)); // Indigo
        subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, 7)); // White
        subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, 8)); // Black
    }
}
