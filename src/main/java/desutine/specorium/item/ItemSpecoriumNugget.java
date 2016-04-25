package desutine.specorium.item;

import desutine.specorium.reference.EnumColors;
import desutine.specorium.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemSpecoriumNugget extends Item {
    public ItemSpecoriumNugget() {
        this.setHasSubtypes(true);
//        this.setMaxDamage(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (EnumColors color : EnumColors.values()) {
            subItems.add(new ItemStack(ModItems.SPECORIUM_NUGGET, 1, color.ordinal()));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + '.' + EnumColors.values()[stack.getMetadata()].getName();
    }
}
