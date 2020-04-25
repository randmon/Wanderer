package dev.randmon.wanderer.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;

    /** Constructor
     * @param sheet spritesheet to be buffered
     * */
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /** Crop method crops spritesheet into individual sprites
     * @param x, y, width, height - where to crop */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
