package dev.game.zombies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import dev.game.Game;
import dev.game.maths.Vector2D;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;
import dev.game.waves.ZombieSpawnEvent;

public class ZombieBuilder {

	public enum ZombieType {
		NORMAL,
		ENGINEER,
		POLITICS,
		ASNAC,
		NONE
	}


	//This all isn't needed
	/*
	public ZombieType currentZombie;

	public ZombieBuilder() {
		currentZombie = ZombieType.NORMAL;
	}

	public ZombieType getCurrentZombieType() {
		return currentZombie;
	}

	public void setCurrentZombieType(ZombieType zombie) {
		currentZombie = zombie;
	}
	*/

	//this can be static
	public static Zombie buildZombie(int lane, ZombieType zombieType) {

		Zombie zombie = null;
		Vector2D pos = new Vector2D(Game.getInstance().getRenderSpace().getWidth(), ((float) lane * Game.getInstance().getRenderSpace().getHeight()) / 4);

		switch (zombieType) {
			case NORMAL:
				zombie = new NormalZombie(pos, lane);
				break;
			case ENGINEER:
				zombie = new EngineerZombie(pos, lane);
				break;
			case POLITICS:
				zombie = new PoliticsZombie(pos, lane);
				break;
			case ASNAC:
				zombie = new AsnacZombie(pos, lane);
				break;
		}

		return zombie;
	}

	public static ZombieType getRandomZombieType() {

		double randNum = Math.random() * 7;

		if (randNum < 3) {
			return ZombieType.NORMAL;
		} else if (randNum < 5) {
			return ZombieType.ENGINEER;
		} else if (randNum < 6) {
			return ZombieType.ASNAC;
		} else {
			return ZombieType.POLITICS;
		}
	}

	public ZombieType getZombieType(LinkedHashMap<Float, ZombieType> cumulativeRatios) {

		double randNum = Math.random();
		Iterator<Entry<Float, ZombieType>> iterator = cumulativeRatios.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Float, ZombieType> entry = iterator.next();
			if (randNum < entry.getKey().doubleValue()) {
				return entry.getValue();
			}
		}

		return null;
	}
}
