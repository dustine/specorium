package desutine.specorium.item;

import desutine.specorium.reference.EnumColors;
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
        for (EnumColors color : EnumColors.values()) {
            subItems.add(new ItemStack(ModItems.SPECORIUM_INGOT, 1, color.ordinal()));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + '.' + EnumColors.values()[stack.getMetadata()].getName();
    }
}

