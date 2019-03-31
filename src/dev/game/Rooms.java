package dev.game;

public class Rooms {
    public static Room getArenaRoom(){
        Room room = new Room();
        room.addEntity(new ZombieSpawner());
        return room;
    }
}
