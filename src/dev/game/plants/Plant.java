package dev.game.plants;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;

import java.awt.image.BufferedImage;

public abstract class Plant extends RenderedGameObject {

	private int eggCost;
	private int damage;
	
	public Plant(Vector2D pos, Vector2D velocity, int cost, int damage, BufferedImage sprite) {
		super(pos, velocity, 18, 32, sprite);
		/* Will vary for different plants in future */
		this.eggCost = cost;
		this.damage = damage;
	}
	
	public int getEggCost() {
		return this.eggCost;
	}

	public int getDamage() {
		return this.damage;
	}
}
