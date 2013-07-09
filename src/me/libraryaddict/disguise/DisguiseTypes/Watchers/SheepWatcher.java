package me.libraryaddict.disguise.DisguiseTypes.Watchers;

import me.libraryaddict.disguise.DisguiseTypes.AnimalColor;

public class SheepWatcher extends AgeableWatcher {

    public SheepWatcher(int entityId) {
        super(entityId);
        setValue(16, (byte) 0);
    }

    public AnimalColor getColor() {
        return AnimalColor.values()[(Byte) getValue(16) & 15];
    }

    public boolean isSheared() {
        return ((Byte) getValue(16) & 16) != 0;
    }

    public void setColor(AnimalColor color) {
        if (getColor() != color) {
            byte b0 = (Byte) getValue(16);
            setValue(16, (byte) (b0 & 240 | color.getId() & 15));
            sendData(16);
        }
    }

    public void setSheared(boolean flag) {
        if (isSheared() != flag) {
            byte b0 = (Byte) getValue(16);
            if (flag) {
                setValue(16, (byte) (b0 | 16));
            } else {
                setValue(16, (byte) (b0 & -17));
            }
            sendData(16);
        }
    }
}
