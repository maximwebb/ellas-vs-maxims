package dev.game.zombies;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.plants.Plant;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class NormalZombie extends Zombie {
	public NormalZombie(Vector2D pos, int laneNum) {
		super(pos, new Vector2D(-10f, 0), laneNum, 40, 100, Assets.normalZombie);
	}

	@Override
	public void update() {

		attack();
		if (attacking) {
			this.velocity = Vector2D.zero;
		}
		else {
			this.velocity = new Vector2D(-10f, 0);
		}

		super.move();

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
}
