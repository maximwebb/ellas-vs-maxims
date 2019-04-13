package dev.game.zombies;

import dev.game.gfx.AnimationHandler;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.plants.Plant;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class EngineerZombie extends Zombie {

	public EngineerZombie(Vector2D pos, int laneNum) {
		super(pos, new Vector2D(-10f, 0), laneNum, 40, 200, Assets.engineerZombie[0]);
	}

	@Override
	public void update() {
		attack();

		if (attacking) {
			this.velocity = Vector2D.zero;
		}
		else {
			this.velocity = initialVelocity;
		}

		super.move();

		collider.pos = this.pos;

		if (health <= 160 && health > 130) {
			this.sprite = Assets.engineerZombie[1];
		}
		else if (health <= 130 && health > 100) {

			this.sprite = Assets.engineerZombie[2];
		}
		else if (health < 100) {
			this.sprite = Assets.engineerZombie[3];
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
				if (charge > 15) {
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
