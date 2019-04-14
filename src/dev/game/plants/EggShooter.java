package dev.game.plants;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.Bullet;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class EggShooter extends Plant {

	private double charge = 0;

	public EggShooter(Vector2D pos, Vector2D velocity, int laneNum) {
		super(pos, velocity, laneNum, 100, 100, Assets.eggShooter);
	}

	public void update() {

		int zombieTargets = this.lane.getZombiesList().size();

		if (charge < 1) {
			charge += Room.getRoom().getDeltaTime();
		}

		if (zombieTargets > 0 && charge >= 1) {
			charge = 0;
			((GameRoom) Room.getRoom()).addGameObject(new Bullet(this.pos, Vector2D.i.scale(100), 20));
		}
	}
}
