package dev.game.gfx;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage maxim;
	public static BufferedImage ella;
	public static BufferedImage zombie;
	public static BufferedImage eggShooter;
	public static BufferedImage eggFlower;
	public static BufferedImage chenapult;
	public static BufferedImage abhiBullet;
	public static BufferedImage lawn;
	public static BufferedImage plantButton;
	/* Loads in all assets once */
	public static void init() {
		maxim = ImageLoader.loadImage("/textures/maxim.png");
		ella = ImageLoader.loadImage("/textures/ella.png");
		zombie = ImageLoader.loadImage("/textures/zombie.png");
		eggShooter = ImageLoader.loadImage("/textures/eggShooter.png");
		eggFlower = ImageLoader.loadImage("/textures/eggFlower.png");
		chenapult = ImageLoader.loadImage("/textures/chenapult.png");
		abhiBullet = ImageLoader.loadImage("/textures/abhiBullet.png");
		lawn = ImageLoader.loadImage("/backgrounds/lawn.png");
		plantButton = ImageLoader.loadImage("/textures/plantButton.png");
	}
}
