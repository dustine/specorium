package desutine.specorium.client.color;

import desutine.specorium.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

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

        double timeFrame = ((double) (Minecraft.getMinecraft().theWorld.getTotalWorldTime() % (20 * 10))) / (20 * 10 * 2) + 0.5;
//        if(timeFrame > 1) timeFrame = 2 - timeFrame;

        return (int) (intColor * timeFrame);
//        return intColor;

//        final Color color = new Color((int) (intColor * timeFrame));
//        return color.getRGB();
    }

    @Override
    public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex) {
        return -1;
    }
}
