package dev.game.waves;

import java.util.Random;

import dev.game.Game;
import dev.game.maths.Vector2D;

public class ZombieSpawnEvent extends WaveEvent{
	
	private static Random random = new Random();
	
	public final Vector2D pos;
	public final Vector2D velocity;
	public int lane = 0;
	
	//main constructor
	//Is this needed? We will only ever be spawning zombies into lanes, so I'd suggest making the alt constructor the main one...
	public ZombieSpawnEvent(double time, Vector2D pos, Vector2D velocity) {
		super(time);
		this.pos = pos;
		this.velocity = velocity;
	}
	
	//alternative constructor to make spawning into lanes easier
	public ZombieSpawnEvent(double time, int lane) {
		super(time);
		this.pos = new Vector2D(Game.getInstance().getRenderSpace().getWidth(), ((float)lane*Game.getInstance().getRenderSpace().getHeight())/4);
		this.velocity = new Vector2D(-10f, 0);
		this.lane = lane;
	}
	
	//alternative constructor for spawning into random lane
	public ZombieSpawnEvent(double time) {
		this(time, random.nextInt(4));
	}
}
