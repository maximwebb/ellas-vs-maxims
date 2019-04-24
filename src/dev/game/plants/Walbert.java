package dev.game.plants;

import dev.game.*;
import dev.game.gfx.Assets;
import dev.game.objects.Tile;
import dev.game.rooms.*;
import dev.game.maths.Vector2D;

public class Walbert extends Plant {

	private static int charge = 0;

	public Walbert(Vector2D pos, Vector2D velocity, Tile tile) {
		super(pos, velocity, tile, 50, 500, Assets.walbert); //temporarily ella instead of walbert
	}

	public void update() {

	}
}