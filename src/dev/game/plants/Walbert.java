package dev.game.plants;

import dev.game.*;
import dev.game.gfx.Assets;
import dev.game.rooms.*;
import dev.game.maths.Vector2D;

public class Walbert extends Plant {

	private static int charge = 0;

	public Walbert(Vector2D pos, Vector2D velocity) {
		super(pos, velocity, 50, Assets.walbert);
	}

	public void update() {

	}
}
