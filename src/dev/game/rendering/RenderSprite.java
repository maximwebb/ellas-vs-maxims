package dev.game.rendering;

import java.awt.image.BufferedImage;

public class RenderSprite extends RenderCall {
    private BufferedImage img;
    private int width;
    private int height;

    public RenderSprite(BufferedImage img, int x, int y, int width, int height) {
        super(x, y);
        this.img = img;
        this.width=width;
        this.height=height;
    }

    public BufferedImage getImg() {
        return img;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
