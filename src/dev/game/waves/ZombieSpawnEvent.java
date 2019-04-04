package dev.game.waves;

import java.util.Random;

import dev.game.Game;
import dev.game.maths.Vector2D;

public class ZombieSpawnEvent extends WaveEvent{
	
	private static Random random = new Random();
	
	public final Vector2D pos;
	public final Vector2D velocity;
	
	//main constructor
	public ZombieSpawnEvent(double time, Vector2D pos, Vector2D velocity) {
		super(time);
		this.pos = pos;
		this.velocity = velocity;
	}
	
	//alternative constructor to make spawning into lanes easier
	public ZombieSpawnEvent(double time, int lane) {
		super(time);
		this.pos = new Vector2D(Game.getInstance().getRenderSpace().getWidth(), ((float)lane*Game.getInstance().getRenderSpace().getHeight())/4);
		this.velocity = new Vector2D(-1, 0);
	}
	
	//alternative constructor for spawning into random lane
	public ZombieSpawnEvent(double time) {
		this(time, random.nextInt(4));
	}
}