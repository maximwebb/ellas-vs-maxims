package dev.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage maxim;
	public static BufferedImage ella;
	public static BufferedImage zombie;
	public static BufferedImage plant;
	public static BufferedImage lawn;
	public static BufferedImage plantButton;
	/* Loads in all assets once */
	public static void init() {
		maxim = ImageLoader.loadImage("/textures/maxim.png");
		ella = ImageLoader.loadImage("/textures/ella.png");
		zombie = ImageLoader.loadImage("/textures/zombie.png");
		plant = ImageLoader.loadImage("/textures/plant.png");
		lawn = ImageLoader.loadImage("/backgrounds/lawn.png");
		plantButton = ImageLoader.loadImage("/textures/plantButton.png");
	}
}
