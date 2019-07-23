package dev.game.waves;

import java.util.HashMap;
import java.util.Random;

import dev.game.Game;
import dev.game.maths.Vector2D;
import dev.game.zombies.ZombieBuilder;
import dev.game.zombies.ZombieBuilder.ZombieType;

public class ZombieSpawnEvent extends WaveEvent {

	private static Random random = new Random();

	public int lane = 0;
	public ZombieType zombieType;

	//main constructor
	public ZombieSpawnEvent(double time, int lane, ZombieType zombieType) {
		super(time);
		//this.pos = new Vector2D(Game.getInstance().getRenderSpace().getWidth(), ((float)lane*Game.getInstance().getRenderSpace().getHeight())/4);
		//this.velocity = new Vector2D(-10f, 0);
		this.lane = lane;
		this.zombieType = zombieType;
	}

	//If zombieTypes is set to null, all zombie types will be selected.
	public ZombieSpawnEvent(double time, HashMap<ZombieType, Double> zombieRatios) {
		this(time, random.nextInt(4), ZombieBuilder.getRandomZombieType(zombieRatios));
	}
}