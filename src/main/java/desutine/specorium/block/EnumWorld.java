package desutine.specorium.block;

import net.minecraft.util.IStringSerializable;

@SuppressWarnings("WeakerAccess")
public enum EnumWorld implements IStringSerializable {
    OVERWORLD, NETHER, END;

    @Override
    public String getName() {
        return this.name().toLowerCase();
    }
}
