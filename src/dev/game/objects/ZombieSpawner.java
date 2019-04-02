package dev.game.objects;

import dev.game.Game;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

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

    /* game should know number of lanes instead do it isn't hard coded everywhere */
    @Override
    public void update() {
        if (random.nextInt(200)==1 && zombies>0){
            ((GameRoom)Room.getRoom()).addGameObject(new Zombie(Game.getInstance().getRenderSpace().getWidth(),(random.nextInt(lanes+1)*Game.getInstance().getRenderSpace().getHeight()/lanes),-1,0));
            zombies--;
        }
    }
}
