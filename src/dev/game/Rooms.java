package dev.game;

public class Rooms {
    public static Room getArenaRoom(){
        Room room = new Room();
        room.addEntity(new Plant(125,25,0,0));
        room.addEntity(new ZombieSpawner());
        return room;
    }
}
