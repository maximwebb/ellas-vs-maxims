package dev.game;

import dev.game.gfx.Assets;

public class Zombie extends RenderedGameObject {

	int energyLevel;

	public Zombie(int posX, int posY, int velX, int velY) {
		super(posX, posY, velX, velY, Assets.zombie);
		energyLevel = 100;
	}
}
