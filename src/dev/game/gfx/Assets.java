package dev.game.gfx;

import java.awt.image.BufferedImage;
import java.io.File;

public class Assets {

	public static BufferedImage maxim;
	public static BufferedImage ella;
	public static BufferedImage normalZombie;
	public static BufferedImage[] engineerZombie;
	public static BufferedImage[] politicsZombie;
	public static BufferedImage[] asnacZombie;
	public static BufferedImage eggShooter;
	public static BufferedImage eggFlower;
	public static BufferedImage chenapult;
	public static BufferedImage walbert;
	public static BufferedImage abhiBullet;
	public static BufferedImage lawn;
	public static BufferedImage plantButton;
	public static File bossTheme;
	public static File theme;

	/* Loads in all assets once */
	public static void init() {
		maxim = ImageLoader.loadImage("/textures/maxim.png");
		ella = ImageLoader.loadImage("/textures/ella.png");

		/* Zombies */
		normalZombie = ImageLoader.loadImage("/textures/normalZombie.png");

		engineerZombie = new BufferedImage[4];
		engineerZombie[0] = ImageLoader.loadImage("/textures/engineerZombie0.png");
		engineerZombie[1] = ImageLoader.loadImage("/textures/engineerZombie1.png");
		engineerZombie[2] = ImageLoader.loadImage("/textures/engineerZombie2.png");
		engineerZombie[3] = ImageLoader.loadImage("/textures/engineerZombie3.png");

		politicsZombie = new BufferedImage[2];
		politicsZombie[0] = ImageLoader.loadImage("/textures/politicsZombie0.png");
		politicsZombie[1] = ImageLoader.loadImage("/textures/politicsZombie1.png");

		asnacZombie = new BufferedImage[4];
		asnacZombie[0] = ImageLoader.loadImage("/textures/asnacZombie0.png");
		asnacZombie[1] = ImageLoader.loadImage("/textures/asnacZombie1.png");
		asnacZombie[2] = ImageLoader.loadImage("/textures/asnacZombie2.png");
		asnacZombie[3] = ImageLoader.loadImage("/textures/asnacZombie3.png");

		/* Plants */
		eggShooter = ImageLoader.loadImage("/textures/eggShooter.png");
		eggFlower = ImageLoader.loadImage("/textures/eggFlower.png");
		chenapult = ImageLoader.loadImage("/textures/chenapult.png");
		walbert = ImageLoader.loadImage("/textures/walbert.png");

		abhiBullet = ImageLoader.loadImage("/textures/abhiBullet.png");
		lawn = ImageLoader.loadImage("/backgrounds/lawn.png");
		plantButton = ImageLoader.loadImage("/textures/plantButton.png");

		theme = new File("./resources/music/MaximsVsElla-1_1.mid");
		bossTheme = new File("./resources/music/boss_theme-1.mid");
	}
}
