package pl.pp.palette;

import java.awt.*;

public class Palette {

    public static int paletteSpace = 50;
    public static int paletteX = 400;
    public static int widthPalette = 100;
    public static int heightPalette = 20;
    public static int paletteY = Utils.maxHeight - paletteSpace - heightPalette;


    public static Shape getShape() {
        return new Rectangle(paletteX, paletteY, widthPalette, heightPalette);
    }

}
