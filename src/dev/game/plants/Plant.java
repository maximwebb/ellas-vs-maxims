package dev.game.plants;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Lane;
import dev.game.rooms.Room;

import java.awt.image.BufferedImage;

public class Plant extends RenderedGameObject {
	private int charge=0;
	private int laneNumber;
	private int eggCost;
	protected int health;
	protected Lane lane;
	
	public Plant(Vector2D pos, Vector2D velocity, int laneNum, int cost, int health, BufferedImage sprite) {
		super(pos, velocity, 18, 32, sprite);
		/* Will vary for different plants in future */
		this.laneNumber = laneNum;
		this.eggCost = cost;
		this.health = health;
		this.lane = ((GameRoom)Room.getRoom()).getLanesList()[this.laneNumber];
	}

	@Override
	public void update() {
		super.update();
		
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

	public void damage(int attackAmount) {
		this.health -= attackAmount;
		if (this.health < 0) {
			((GameRoom) Room.getRoom()).removePlant(this);

		}
	}

	public int getEggCost() {
		return this.eggCost;
	}

	public int getLaneNumber() { return this.laneNumber; }
}
