package dev.game.zombies;

import dev.game.maths.Vector2D;

public class ZombieBuilder {
	public enum ZombieType {
		NORMAL,
		ENGINEER,
		POLITICS,
		ASNAC,
		NONE
	}

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

	public Zombie buildZombie(Vector2D pos, int lane) {
		Zombie zombie = null;
		switch(currentZombie) {
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

}
