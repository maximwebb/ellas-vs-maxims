package dev.game;

import dev.game.gfx.Assets;

public class Bullet extends Entity {
    public Bullet(int posX, int posY) {
        super(posX, posY, 10,0, Assets.ella);
    }

}
