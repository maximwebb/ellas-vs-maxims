package dev.game.objects;

import dev.game.Game;
import dev.game.maths.Vector2D;
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
            Vector2D pos = new Vector2D(Game.getInstance().getRenderSpace().getWidth(),(random.nextInt(lanes+1)*Game.getInstance().getRenderSpace().getHeight()/lanes));
            Vector2D vel = new Vector2D(-1,0);
            ((GameRoom)Room.getRoom()).addGameObject(new Zombie(pos,vel));
            zombies--;
        }
    }
}
