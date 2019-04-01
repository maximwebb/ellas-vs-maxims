package dev.game;
//TODO: load image in Game.java, using Assets.java
import java.awt.*;
import java.awt.image.BufferedImage;

/* Superclass for plants and zombies */
public abstract class RenderedGameObject extends GameObject {
	private int posX;
	private int posY;
	private int velX;
	private int velY;
	private BufferedImage sprite;

	public RenderedGameObject(int posX, int posY, int velX, int velY, BufferedImage sprite) {
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		this.sprite = sprite;
	}

	public void update() {
		posX += velX;
		posY += velY;
	}

	public int getVelX(){
		return velX;
	}

	public int getVelY(){
		return velY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public BufferedImage getSprite() {
		return sprite;
	}

}
