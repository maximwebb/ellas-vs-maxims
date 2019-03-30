package dev.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage ella;
	public static BufferedImage maxim;
	/* Loads in all assets once */
	public static void init() {
		maxim = ImageLoader.loadImage("/textures/maxim.png");
		ella = ImageLoader.loadImage("/textures/ella.png");
	}
}
