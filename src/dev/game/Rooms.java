package dev.game;

public class Rooms {
    public static Room getArenaRoom(){
        Room room = new Room();
        room.addEntity(new ZombieSpawner(4, 10));
        return room;
    }
}
