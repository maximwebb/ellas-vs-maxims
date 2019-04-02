package dev.game.objects;
//TODO: load image in Game.java, using Assets.java
import java.awt.image.BufferedImage;

/* Superclass for plants and zombies */
public abstract class RenderedGameObject extends GameObject {
	private float posX;
	private float posY;
	private int width;
	private int height;
	private float velX;
	private float velY;
	private ClickAction clickAction;
	private BufferedImage sprite;

	public RenderedGameObject(float posX, float posY, int width, int height, float velX, float velY, BufferedImage sprite) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.velX = velX;
		this.velY = velY;
		this.sprite = sprite;
		this.clickAction = null;
	}

	public ClickAction getClickAction() {
		return clickAction;
	}

	public void setClickAction(ClickAction clickAction) {
		this.clickAction = clickAction;
	}

	public void update() {
		posX += velX;
		posY += velY;
	}

	public float getVelX(){
		return velX;
	}

	public float getVelY(){
		return velY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public float getPosX() {
		return posX;
	}

	public float getPosY() {
		return posY;
	}

	public BufferedImage getSprite() {
		return sprite;
	}

}
