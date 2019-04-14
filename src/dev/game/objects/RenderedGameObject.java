package dev.game.objects;
//TODO: load image in Game.java, using Assets.java

import dev.game.maths.Vector2D;
import dev.game.rooms.Room;

import java.awt.image.BufferedImage;

/* Superclass for plants and zombies */
public abstract class RenderedGameObject extends GameObject {
	protected Vector2D pos;
	protected Vector2D velocity;
	protected BufferedImage sprite;
	private int width;
	private int height;
	private ClickAction clickAction;

	public RenderedGameObject(Vector2D pos, Vector2D velocity, int width, int height, BufferedImage sprite) {
		this.pos = pos;
		this.velocity = velocity;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		this.clickAction = null;
	}

	public void update() {
		pos = pos.add(velocity.scale((float) Room.getRoom().getDeltaTime()));
	}

	public Vector2D getPos() {
		return pos;
	}

	public void setPos(Vector2D pos) {
		this.pos = pos;
	}

	public Vector2D getVelocity() {
		return velocity;
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ClickAction getClickAction() {
		return clickAction;
	}

	public void setClickAction(ClickAction clickAction) {
		this.clickAction = clickAction;
	}
}
