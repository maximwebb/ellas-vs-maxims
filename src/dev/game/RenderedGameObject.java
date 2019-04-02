package dev.game;
//TODO: load image in Game.java, using Assets.java
import java.awt.*;
import java.awt.image.BufferedImage;
import dev.game.maths.Vector2D;

/* Superclass for plants and zombies */
public abstract class RenderedGameObject extends GameObject {
	protected Vector2D pos;
	protected Vector2D velocity;
	private BufferedImage sprite;

	public RenderedGameObject(Vector2D pos, Vector2D velocity, BufferedImage sprite) {
		this.pos = pos;
		this.velocity = velocity;
		this.sprite = sprite;
	}

	public void update() {
		pos = pos.add(velocity);
	}

	public Vector2D getPos() {
		return pos;
	}

	public Vector2D getVelocity() {
		return velocity;
	}

	public BufferedImage getSprite() {
		return sprite;
	}
}
