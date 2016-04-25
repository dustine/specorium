package desutine.specorium.client.color;

import desutine.specorium.reference.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.awt.*;

public class ColorSpecorium implements IItemColor, IBlockColor {
    @Override
    public int getColorFromItemstack(ItemStack stack, int tintIndex) {
        int intColor;

        if (tintIndex != 0) return -1;
        switch (stack.getMetadata()) {
            case 0:
                intColor = Reference.Color.RED;
                break;
            case 1:
                intColor = Reference.Color.ORANGE;
                break;
            case 2:
                intColor = Reference.Color.YELLOW;
                break;
            case 3:
                intColor = Reference.Color.GREEN;
                break;
            case 4:
                intColor = Reference.Color.CYAN;
                break;
            case 5:
                intColor = Reference.Color.BLUE;
                break;
            case 6:
                intColor = Reference.Color.VIOLET;
                break;
            case 7:
                intColor = Reference.Color.WHITE;
                break;
            case 8:
                intColor = Reference.Color.BLACK;
                break;
            default:
                return -1;
        }

        double timeFrame = ((double) (Minecraft.getMinecraft().theWorld.getTotalWorldTime() % (20 * 2))) / (20 * 2) * 2 * Math.PI;
        timeFrame = Math.sin(timeFrame);
        timeFrame = (1 + timeFrame) / 8 + 0.75;

        final Color color = new Color(intColor);
        final float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        return Color.HSBtoRGB(hsb[0], hsb[1], (float) (hsb[2] * timeFrame));

    }

    @Override
    public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex) {
        return -1;
    }
}
