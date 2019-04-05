package dev.game.plants;

import dev.game.*;
import dev.game.gfx.Assets;
import dev.game.rooms.*;
import dev.game.maths.Vector2D;

public class EggFlower extends Plant {

	private static int charge = 0;

	public EggFlower(Vector2D pos, Vector2D velocity, int laneNum) {
		super(pos, velocity, laneNum, 50, 100, Assets.eggFlower);
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
