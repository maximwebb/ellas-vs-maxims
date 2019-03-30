package dev.game;

import java.awt.image.BufferedImage;

public class Plant extends Entity {
	public Plant(int posX, int posY, int velX, int velY, BufferedImage sprite) {
		super(posX, posY, velX, velY, sprite);
	}

	public Plant(Plant plant, int posX, int posY){
		super(posX, posY, plant.getVelX(), plant.getVelY(), plant.sprite);

	}

	public void shoot() {

	}



}
