package dev.game;

import dev.game.gfx.Assets;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Plant extends RenderedGameObject {
	private int charge=0;
	private int eggCost;
	public Plant(int posX, int posY, int velX, int velY) {
		super(posX, posY, velX, velY, Assets.plant);
		/* Will vary for different plants in future */
		this.eggCost = 100;
	}

	public Plant(Plant plant, int posX, int posY){
		super(posX, posY, plant.getVelX(), plant.getVelY(), plant.getSprite());
	}

	public void shoot() {}
	@Override
	public void update() {
		super.update();

		int zombieTargets = 0;
		if (charge < 100) {
			charge++;
		}

		/* Basic collision checking */
		for(GameObject object : ((GameRoom)Room.getRoom()).gameObjectsList){
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

	public int getEggCost() {
		return this.eggCost;
	}
}
