package desutine.specorium.reference;

import net.minecraft.util.IStringSerializable;

public enum EnumColors implements IStringSerializable {
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE, WHITE, BLACK;

    @Override
    public String getName() {
        return this.name().toLowerCase();
    }
}
