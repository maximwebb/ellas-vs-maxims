package dev.game;

import java.awt.image.BufferedImage;
import java.util.Random;

//To-Do: Limited number of zombie spawns, only spawn in lanes, less frequent zombies
public class ZombieSpawner extends Entity {

    Random random;
    Boolean spawingEnabled = false;

    public ZombieSpawner() {
        super(0,0,0,0,null);
        random = new Random();
    }

    @Override
    public void update() {
        super.update();
        if (random.nextInt(100)==1 && spawingEnabled){
            Game.getInstance().addEntity(new Zombie(Game.getInstance().width,random.nextInt(Game.getInstance().height),-1,0));
        }
    }
}
