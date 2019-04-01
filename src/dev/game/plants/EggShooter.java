package dev.game.plants;

import dev.game.Bullet;
import dev.game.GameObject;
import dev.game.RenderedGameObject;
import dev.game.Zombie;
import dev.game.gfx.Assets;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class EggShooter extends Plant {

	private static int charge = 0;

	public EggShooter(int posX, int posY, int velX, int velY) {
		super(posX, posY, velX, velY, 100, Assets.eggShooter);
	}

	public void update() {
		int zombieTargets = 0;
		if (charge < 100) {
			charge++;
		}

		/* Basic collision checking */
		for(GameObject object : ((GameRoom) Room.getRoom()).gameObjectsList){
			if(object instanceof Zombie){
				/* Meme-worthy collision checking, someone plz write something good */
				if(Math.abs(((RenderedGameObject)object).getPosY() - this.getPosY()) < 50 && ((RenderedGameObject)object).getPosX() > this.getPosX()) {

					zombieTargets++;

					if (Math.abs(((RenderedGameObject) object).getPosX() - this.getPosX()) < 20) {
						((GameRoom) Room.getRoom()).removeGameObject(this);
					}
				}
			}
		}

		if(zombieTargets > 0 && charge >= 100) {
			charge = 0;
			((GameRoom) Room.getRoom()).addGameObject(new Bullet(getPosX(), getPosY()));
		}
	}

}
