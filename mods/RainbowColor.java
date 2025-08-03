package pixelclient.mods;

import java.awt.Color;

public class RainbowColor {
    public RainbowColor() {
    }

    public static int getColor() {
        long l = System.currentTimeMillis();
        return Color.HSBtoRGB((float)(l % 2000L) / 2000.0F, 0.8F, 0.8F);
    }
}