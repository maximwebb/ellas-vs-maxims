package dev.game.plants;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;

import java.awt.image.BufferedImage;

public abstract class Plant extends RenderedGameObject {
	
	private int eggCost;
	
	public Plant(Vector2D pos, Vector2D velocity, int cost, BufferedImage sprite) {
		super(pos, velocity, 18, 32, sprite);
		/* Will vary for different plants in future */
		this.eggCost = cost;
	}
	
	public int getEggCost() {
		return this.eggCost;
	}
}
