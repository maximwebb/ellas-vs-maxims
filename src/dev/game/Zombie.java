package dev.game;

import dev.game.gfx.Assets;

import java.awt.image.BufferedImage;

public class Zombie extends Entity {

	int energyLevel;

	public Zombie(int posX, int posY, int velX, int velY) {
		super(posX, posY, velX, velY, Assets.zombie);
		energyLevel = 100;
	}
}
