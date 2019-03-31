package dev.game;

import java.util.Random;

public class ZombieSpawner extends GameObject {

    Random random;
    int lanes;
    int zombies;

    public ZombieSpawner(int l, int z) {
        random = new Random();
        lanes = l;
        zombies = z;
    }

    //game should know number of lanes instead do it isn't hard coded everywhere
    @Override
    public void update() {
        if (random.nextInt(200)==1 && zombies>0){
            Game.getInstance().addEntity(new Zombie(Game.getInstance().width,(random.nextInt(lanes+1)*Game.getInstance().height/lanes),-1,0));
            zombies--;
        }
    }
}
