package dev.game.plants;

import dev.game.collision.CollisionHelper;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.maths.VectorLine;
import dev.game.objects.Bullet;
import dev.game.objects.GameObject;
import dev.game.objects.Zombie;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class EggShooter extends Plant {

	private double charge = 0;

	public EggShooter(Vector2D pos, Vector2D velocity) {
		super(pos, velocity, 100, 25, Assets.eggShooter);
	}

	public void update() {
		int zombieTargets = 0;

		/* Basic collision checking */
		for(GameObject object : ((GameRoom)Room.getRoom()).gameObjectsList){
			if(object instanceof Zombie){
				// temporary collision detection - it's a bit overkill but it does the job
				VectorLine rayCast = new VectorLine(this.pos, Vector2D.i);

				if(CollisionHelper.checkCollision(rayCast, ((Zombie)object).collider)) {
					zombieTargets++;

					if(rayCast.lambda == 0) {
						((GameRoom) Room.getRoom()).removeGameObject(this);
					}
				}
			}
		}

		if (charge < 2) {
			charge += Room.getRoom().getDeltaTime();
		}

		if(zombieTargets > 0 && charge >= 2) {
			charge = 0;
			((GameRoom) Room.getRoom()).addGameObject(new Bullet(this.pos, Vector2D.i.scale(50), 25));
		}
	}

}
