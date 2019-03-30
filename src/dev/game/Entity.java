package dev.game;
//TODO: load image in Game.java, using Assets.java
import java.awt.image.BufferedImage;

/* Superclass for plants and zombies */
public class Entity {
	public int posX;
	public int posY;
	private int velX;
	private int velY;
	public BufferedImage sprite;

	public Entity(int posX, int posY, int velX, int velY, BufferedImage sprite) {
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		this.sprite = sprite;
	}

	public void updatePos() {
		posX += velX;
		posY += velY;
	}
}
