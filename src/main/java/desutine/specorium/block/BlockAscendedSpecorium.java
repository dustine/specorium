package desutine.specorium.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAscendedSpecorium extends Block {
    public BlockAscendedSpecorium() {
        super(Material.IRON);
        setHarvestLevel("pickaxe", 2);
        setHardness(5);
    }
}
