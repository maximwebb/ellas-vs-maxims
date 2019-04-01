package dev.game.plants;

import dev.game.*;
import dev.game.gfx.Assets;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class EggFlower extends Plant {

	private static int charge = 0;

	public EggFlower(int posX, int posY, int velX, int velY) {
		super(posX, posY, velX, velY, 50, Assets.eggFlower);
	}

	public void update() {
		if (charge < 300) {
			charge++;
		}
		else {
			((GameRoom)Room.getRoom()).setEggCount(((GameRoom)Room.getRoom()).eggCount + 50);
			charge = 0;
		}
	}
}
