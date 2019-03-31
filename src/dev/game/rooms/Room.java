package dev.game.rooms;

import dev.game.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Room {

	private static Room currentRoom = null;

//    List<GameObject> objects;
//
//    public Room() {
//        objects=new ArrayList<>();
//    }
//
//    public List<GameObject> getGameObjects() {
//        return objects;
//    }
//
//    public void addGameObject(GameObject gameObject){
//        objects.add(gameObject);
//    }

	/* Possibly move this to separate class? */
	public static void setRoom(Room room) {
		currentRoom = room;
	}

	public static Room getRoom() {
		return currentRoom;
	}

	public abstract void init();
    public abstract void tick();
    public abstract void render(Graphics g);


}
