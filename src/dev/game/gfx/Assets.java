package dev.game.gfx;

import java.awt.image.BufferedImage;

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
	public static BufferedImage title;
	public static BufferedImage levelComplete;
	public static BufferedImage gameOver;
	public static BufferedImage levels;
	public static BufferedImage plantButton;
	public static BufferedImage mainMenuButton;
	public static BufferedImage[] startButton;
	public static BufferedImage[] levelSelectButton;
	public static BufferedImage[] levelsButton;
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
		title = ImageLoader.loadImage("/backgrounds/title.png");
		levelComplete = ImageLoader.loadImage("/backgrounds/levelComplete.png");
		gameOver = ImageLoader.loadImage("/backgrounds/gameOver.png");
		levels = ImageLoader.loadImage("/backgrounds/levels.png");

		/* Buttons */
		plantButton = ImageLoader.loadImage("/textures/plantButton.png");
		mainMenuButton = ImageLoader.loadImage("/textures/mainMenuButton.png");

		startButton = new BufferedImage[2];
		startButton[0] = ImageLoader.loadImage("/textures/startButton0.png");
		startButton[1] = ImageLoader.loadImage("/textures/startButton1.png");

		levelSelectButton = new BufferedImage[2];
		levelSelectButton[0] = ImageLoader.loadImage("/textures/levelsButton0.png");
		levelSelectButton[0] = ImageLoader.loadImage("/textures/levelsButton1.png");

		levelsButton = new BufferedImage[4];
		levelsButton[0] = ImageLoader.loadImage("/textures/level1.png");
		levelsButton[1] = ImageLoader.loadImage("/textures/level2.png");
		levelsButton[2] = ImageLoader.loadImage("/textures/level3.png");
		levelsButton[3] = ImageLoader.loadImage("/textures/level4.png");


	}
}
