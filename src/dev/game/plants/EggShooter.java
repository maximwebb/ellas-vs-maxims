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

	private int charge = 0;
	private int damageCharge = 0;

	public EggShooter(Vector2D pos, Vector2D velocity, int laneNum) {
		super(pos, velocity, laneNum, 100, 100, Assets.eggShooter);
	}

	public void update() {
		int zombieTargets = this.lane.getZombiesList().size();
		
		/* Basic collision checking */
//		for(GameObject object : ((GameRoom)Room.getRoom()).gameObjectsList){
//			if(object instanceof Zombie){
//				// temporary collision detection - it's a bit overkill but it does the job
//				VectorLine rayCast = new VectorLine(this.pos, Vector2D.i);
//
//				if(CollisionHelper.checkCollision(rayCast, ((Zombie)object).collider)) {
//					zombieTargets++;
//					if(rayCast.lambda == 0) {
//						((GameRoom) Room.getRoom()).removeGameObject(this);
//					}
//				}
//			}
//		}

		charge++;

		
		if(zombieTargets > 0 && charge >= 30) {
			charge = 0;
			((GameRoom) Room.getRoom()).addGameObject(new Bullet(this.pos, Vector2D.i.scale(10)));
		}
	}
}
