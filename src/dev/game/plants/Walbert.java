package dev.game.plants;

import dev.game.*;
import dev.game.gfx.Assets;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Walbert extends Plant {

	private static int charge = 0;

	public Walbert(int posX, int posY, int velX, int velY) {
		super(posX, posY, velX, velY, 50, Assets.walbert);
	}

	public void update() {

	}
}
