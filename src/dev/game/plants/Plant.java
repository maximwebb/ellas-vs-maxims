package dev.game.plants;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;

import java.awt.image.BufferedImage;

public class Plant extends RenderedGameObject {
	private int charge=0;
	private int eggCost;
	public Plant(Vector2D pos, Vector2D velocity, int cost, BufferedImage sprite) {
		super(pos, velocity, 30, 40, sprite);
		/* Will vary for different plants in future */
		this.eggCost = cost;
	}

	public Plant(Plant plant, float posX, int posY){
		super(plant.getPos(), plant.getVelocity(),30, 40, plant.getSprite());
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
		/*for(GameObject object : ((GameRoom)Room.getRoom()).gameObjectsList){
			if(object instanceof Zombie){
				/* Meme-worthy collision checking, someone plz write something good *//*
				if(Math.abs(((RenderedGameObject)object).getPos().y - this.getPosY()) < 50 && ((RenderedGameObject)object).getPosX() > this.getPosX()) {

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
		}*/
	}

	public int getEggCost() {
		return this.eggCost;
	}
}
