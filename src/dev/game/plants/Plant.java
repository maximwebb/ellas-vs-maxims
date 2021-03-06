package dev.game.plants;

import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;
import dev.game.objects.Tile;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Lane;
import dev.game.rooms.Room;

import java.awt.image.BufferedImage;

public abstract class Plant extends RenderedGameObject {
	private int laneNumber;
	private int eggCost;
	protected int health;
	protected Lane lane;
	protected Tile tile;

	public Plant(Vector2D pos, Vector2D velocity, Tile tile, int cost, int health, BufferedImage sprite) {
		super(pos, velocity, 18, 32, sprite);
		/* Will vary for different plants in future */
		this.laneNumber = tile.getLaneNumber();
		this.eggCost = cost;
		this.health = health;
		this.lane = ((GameRoom) Room.getRoom()).getLanesList()[this.laneNumber];
		this.tile = tile;
	}

	public void damage(int attackAmount) {
		this.health -= attackAmount;
		if (this.health < 0) {
			((GameRoom) Room.getRoom()).removePlant(this);
		}
	}

	public int getEggCost() {
		return this.eggCost;
	}

	public int getLaneNumber() {
		return this.laneNumber;
	}

	public Tile getTile() {
		return this.tile;
	}
}