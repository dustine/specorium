package desutine.specorium.client.color;

import desutine.specorium.Reference;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class ColorTaintedSpecorium implements IItemColor {

    @Override
    public int getColorFromItemstack(ItemStack stack, int tintIndex) {
        return Reference.Color.MAROON;
    }
}
