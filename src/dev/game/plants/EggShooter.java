package dev.game.plants;

import dev.game.Bullet;
import dev.game.GameObject;
import dev.game.RenderedGameObject;
import dev.game.Zombie;
import dev.game.collision.CollisionHelper;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.maths.VectorLine;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class EggShooter extends Plant {

	private int charge = 0;

	public EggShooter(Vector2D pos, Vector2D velocity) {
		super(pos, velocity, 100, Assets.eggShooter);
	}

	public void update() {
		super.update();
    
		int zombieTargets = 0;
		
		/* Basic collision checking */
		for(GameObject object : ((GameRoom)Room.getRoom()).gameObjectsList){
			if(object instanceof Zombie){
				/* Meme-worthy collision checking, someone plz write something good
				if(Math.abs(((RenderedGameObject)object).pos.y() - this.pos.y()) < 50 && ((RenderedGameObject)object).pos.x() > this.pos.x()) {

					zombieTargets++;

					if (Math.abs(((RenderedGameObject) object).getPosX() - this.getPosX()) < 20) {
						((GameRoom) Room.getRoom()).removeGameObject(this);
					}
				}*/

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
		
		if (charge < 100) {
			charge++;
		}
		
		if(zombieTargets > 0 && charge >= 100) {
			charge = 0;
			((GameRoom) Room.getRoom()).addGameObject(new Bullet(this.pos, Vector2D.i.scale(10)));
		}
	}

}
