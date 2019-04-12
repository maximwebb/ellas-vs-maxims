package dev.game.gfx;

import java.awt.*;
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
	public static BufferedImage levels;
	public static BufferedImage plantButton;
	public static BufferedImage explosion;
	public static BufferedImage[] youmu;
	public static BufferedImage[] slashes;
	public static BufferedImage[] startButton;
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

		/*henry youmu plant*/
		youmu = new BufferedImage[6];
		youmu[0] = ImageLoader.loadImage("/textures/youmuSprite/youmuSprite000.png");
		youmu[1] = ImageLoader.loadImage("/textures/youmuSprite/youmuSprite001.png");
		youmu[2] = ImageLoader.loadImage("/textures/youmuSprite/youmuSprite002.png");
		youmu[3] = ImageLoader.loadImage("/textures/youmuSprite/youmuSprite003.png");
		youmu[4] = ImageLoader.loadImage("/textures/youmuSprite/youmuSprite004.png");
		youmu[5] = ImageLoader.loadImage("/textures/youmuSprite/youmuSprite005.png");
		slashes = new BufferedImage[7];
		slashes[0] = ImageLoader.loadImage("/textures/slashes/slash000.png");
		slashes[1] = ImageLoader.loadImage("/textures/slashes/slash001.png");
		slashes[2] = ImageLoader.loadImage("/textures/slashes/slash002.png");
		slashes[3] = ImageLoader.loadImage("/textures/slashes/slash003.png");
		slashes[4] = ImageLoader.loadImage("/textures/slashes/slash004.png");
		slashes[5] = ImageLoader.loadImage("/textures/slashes/slash005.png");
		slashes[6] = ImageLoader.loadImage("/textures/slashes/slash006.png");
		explosion = ImageLoader.loadImage("/textures/explosion.png");

		abhiBullet = ImageLoader.loadImage("/textures/abhiBullet.png");
		lawn = ImageLoader.loadImage("/backgrounds/lawn.png");
		title = ImageLoader.loadImage("/backgrounds/title.png");
		levels = ImageLoader.loadImage("/backgrounds/levels.png");

		/* Buttons */
		plantButton = ImageLoader.loadImage("/textures/plantButton.png");

		startButton = new BufferedImage[2];
		startButton[0] = ImageLoader.loadImage("/textures/startButton0.png");
		startButton[1] = ImageLoader.loadImage("/textures/startButton1.png");

		levelsButton = new BufferedImage[2];
		levelsButton[0] = ImageLoader.loadImage("/textures/levelsButton0.png");
		levelsButton[0] = ImageLoader.loadImage("/textures/levelsButton1.png");


	}
}
