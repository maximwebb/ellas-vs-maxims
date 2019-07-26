package dev.game.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage EMPTY;
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
	public static BufferedImage lawnmower;
	public static BufferedImage lawn;
	public static BufferedImage title;
	public static BufferedImage levelComplete;
	public static BufferedImage gameOver;
	public static BufferedImage levels;
	public static BufferedImage plantButton;
	public static BufferedImage youmu;
	public static BufferedImage[] youmuSprites;
	public static BufferedImage[] slashSprites;
	public static BufferedImage mainMenuButton;
	public static BufferedImage[] startButton;
	public static BufferedImage[] levelSelectButton;
	public static BufferedImage[] levelsButton;

	/* Loads in all assets once */
	public static void init() {
		//single transparent pixel
		EMPTY = ImageLoader.loadImage("/textures/EMPTY.png");

		maxim = ImageLoader.loadImage("/textures/maxim.png");
		ella = ImageLoader.loadImage("/textures/ella.png");

		/* Zombies */
		normalZombie = ImageLoader.loadImage("/textures/normalZombie.png");
		engineerZombie = ImageLoader.loadImageArray("/textures", "engineerZombie", 4);
		politicsZombie = ImageLoader.loadImageArray("/textures", "politicsZombie", 2);
		asnacZombie = ImageLoader.loadImageArray("/textures", "asnacZombie", 4);

		/* Plants */
		eggShooter = ImageLoader.loadImage("/textures/eggShooter.png");
		eggFlower = ImageLoader.loadImage("/textures/eggFlower.png");
		chenapult = ImageLoader.loadImage("/textures/chenapult.png");
		walbert = ImageLoader.loadImage("/textures/walbert.png");

		/*henry youmu plant*/
		youmu = ImageLoader.loadImage("/textures/youmuSprite/youmuSprite000.png");
		youmuSprites = ImageLoader.loadImageArray("/textures/youmuSprite", "youmuSprite", 6);
		slashSprites = ImageLoader.loadImageArray("/textures/slashes", "slash", 7);

		abhiBullet = ImageLoader.loadImage("/textures/abhiBullet.png");
		lawnmower = ImageLoader.loadImage("/textures/lawnmower.png");
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
