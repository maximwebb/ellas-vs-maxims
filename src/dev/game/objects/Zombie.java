package dev.game.objects;

import dev.game.collision.CircleCollider;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;
import dev.game.plants.Plant;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Lane;
import dev.game.rooms.Room;

public class Zombie extends RenderedGameObject {

	private int health;
	private int laneNumber;
	private Lane lane;
	private int attackAmount;
	private boolean attacking = false;
	private int charge = 0;
	public CircleCollider collider;

	public Zombie(Vector2D pos, Vector2D velocity, int laneNum, int attack) {
		super(pos, velocity, 18, 32, Assets.zombie);

		health = 100;
		collider = new CircleCollider(this.pos, 25);
		this.laneNumber = laneNum;
		this.attackAmount = attack;
		this.lane = ((GameRoom)Room.getRoom()).getLanesList()[this.laneNumber];

		setClickAction(() ->  ((GameRoom) Room.getRoom()).removeGameObject(this) );
	}
	
	@Override
	public void update() {

		attack();
		if (attacking) {
			this.velocity = Vector2D.zero;
		}
		else {
			this.velocity = new Vector2D(-0.5f, 0);
		}

		super.update();

		collider.pos = this.pos;

		if(health <= 0) {
			((GameRoom) Room.getRoom()).removeZombie(this);
		}
	}

	public void attack() {
		attacking = false;
		for (Plant plant : this.lane.getPlantsList()) {
			if (Math.abs(plant.getPos().x - this.pos.x) < 5) {
				charge++;
				if (charge > 25) {
					plant.damage(attackAmount);
					charge = 0;
				}
				attacking = true;
			}
		}
	}


	public void damage(int damage) {
		health -= damage;
	}

	public int getLaneNumber() { return this.laneNumber; }
}
