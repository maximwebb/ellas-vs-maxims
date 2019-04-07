package dev.game.zombies;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.plants.Plant;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class AsnacZombie extends Zombie {

	public AsnacZombie(Vector2D pos, int laneNum) {
		super(pos, new Vector2D(-7f, 0), laneNum, 40, 350, Assets.asnacZombie[0]);
	}

	@Override
	public void update() {
		attack();

		if (attacking) {
			this.velocity = Vector2D.zero;
		}
		else {
			this.velocity = this.initialVelocity;
		}

		super.move();

		collider.pos = this.pos;

		if (health <= 280 && health > 200) {
			this.sprite = Assets.asnacZombie[1];
		}
		else if (health <= 150 && health > 100) {

			this.sprite = Assets.asnacZombie[2];
		}
		else if (health < 100) {
			this.sprite = Assets.asnacZombie[3];
		}

		if(health <= 0) {
			((GameRoom) Room.getRoom()).removeZombie(this);
		}
	}

	public void attack() {
		attacking = false;
		for (Plant plant : this.lane.getPlantsList()) {
			if (Math.abs(plant.getPos().x - this.pos.x) < 5) {
				charge++;
				if (charge > 18) {
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
}