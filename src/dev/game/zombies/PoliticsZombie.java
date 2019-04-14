package dev.game.zombies;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.plants.Plant;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class PoliticsZombie extends Zombie {

	private boolean hasNewspaper = true;

	public PoliticsZombie(Vector2D pos, int laneNum) {
		super(pos, new Vector2D(-8f, 0), laneNum, 40, 150, Assets.politicsZombie[0]);
	}

	@Override
	public void update() {
		attack();

		if (attacking) {
			this.velocity = Vector2D.zero;
		} else {
			this.velocity = this.initialVelocity;
		}

		super.move();

		collider.pos = this.pos;

		if (health <= 100) {
			this.sprite = Assets.politicsZombie[1];
			this.initialVelocity = new Vector2D(-20f, 0);
			this.velocity = new Vector2D(-20f, 0);
			hasNewspaper = false;
		}

		if (health <= 0) {
			((GameRoom) Room.getRoom()).removeZombie(this);
		}
	}

	public void attack() {
		attacking = false;
		for (Plant plant : this.lane.getPlantsList()) {
			if (Math.abs(plant.getPos().x - this.pos.x) < 5) {
				charge++;
				if (hasNewspaper) {
					if (charge > 20) {
						plant.damage(attackAmount);
						charge = 0;
					}
				} else {
					if (charge > 5) {
						plant.damage(attackAmount);
						charge = 0;
					}
				}
				attacking = true;
			}
		}
	}

	public void damage(int damage) {
		health -= damage;
	}
}