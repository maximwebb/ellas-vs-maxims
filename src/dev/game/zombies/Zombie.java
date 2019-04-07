package dev.game.zombies;

import dev.game.collision.CircleCollider;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;
import dev.game.plants.Plant;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Lane;
import dev.game.rooms.Room;

import java.awt.image.BufferedImage;

public abstract class Zombie extends RenderedGameObject {

	protected int health;
	protected int laneNumber;
	protected Lane lane;
	protected int attackAmount;
	protected boolean attacking = false;
	protected Vector2D initialVelocity;
	protected int charge = 0;
	public CircleCollider collider;

	public Zombie(Vector2D pos, Vector2D velocity, int laneNum, int attack, int health, BufferedImage sprite) {
		super(pos, velocity, 18, 32, sprite);
		this.initialVelocity = velocity;
		this.health = health;
		collider = new CircleCollider(this.pos, 5);
		this.laneNumber = laneNum;
		this.attackAmount = attack;
		this.lane = ((GameRoom)Room.getRoom()).getLanesList()[this.laneNumber];

		setClickAction(() ->  ((GameRoom) Room.getRoom()).removeGameObject(this) );
	}

	public abstract void update();

	public abstract void damage(int damage);

	public void move() {
		super.update();
	}

	public int getLaneNumber() { return this.laneNumber; }
}
