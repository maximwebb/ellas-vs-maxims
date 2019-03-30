package dev.game;

import java.awt.image.BufferedImage;
import java.util.Random;

public class ZombieSpawner extends Entity {
    Random random;

    public ZombieSpawner() {
        super(0,0,0,0,null);
        random = new Random();
    }

    @Override
    public void update() {
        super.update();
        if (random.nextInt(100)==1){
            Game.getInstance().addEntity(new Zombie(Game.getInstance().width,random.nextInt(Game.getInstance().height),-1,0));
        }
    }
}
