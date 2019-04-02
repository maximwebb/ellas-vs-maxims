package dev.game.plants;

import dev.game.Bullet;
import dev.game.GameObject;
import dev.game.RenderedGameObject;
import dev.game.Zombie;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

import java.awt.image.BufferedImage;

public abstract class Plant extends RenderedGameObject {
	private int charge=0;
	private int eggCost;
	
	public Plant(Vector2D pos, Vector2D velocity, int eggCost, BufferedImage sprite) {
		super(pos, velocity, sprite);
		this.eggCost = eggCost;
	}

	/* Do we REEEALLLY need this constructor?
	public Plant(Plant plant, int posX, int posY){
		super(posX, posY, plant.getVelX(), plant.getVelY(), plant.getSprite());
	} */
  
	@Override
	public abstract void update();

	public void setPos(Vector2D pos) { this.pos = pos; }

	public int getEggCost() {
		return this.eggCost;
	}
}
