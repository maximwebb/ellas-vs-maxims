package dev.game.plants;

import dev.game.Bullet;
import dev.game.GameObject;
import dev.game.RenderedGameObject;
import dev.game.Zombie;
import dev.game.gfx.Assets;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

import java.awt.image.BufferedImage;

public abstract class Plant extends RenderedGameObject {
	private int charge=0;
	private int eggCost;
	public Plant(int posX, int posY, int velX, int velY, int eggCost, BufferedImage sprite) {
		super(posX, posY, velX, velY, sprite);
		this.eggCost = eggCost;
	}

	/* Do we REEEALLLY need this constructor? */
	public Plant(Plant plant, int posX, int posY){
		super(posX, posY, plant.getVelX(), plant.getVelY(), plant.getSprite());
	}

	@Override
	public abstract void update();

	public void setPosX(int posX) { this.posX = posX; }

	public void setPosY(int posY) { this.posY = posY; }

	public int getEggCost() {
		return this.eggCost;
	}
}
