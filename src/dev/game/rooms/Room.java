package dev.game.rooms;

import dev.game.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Room {

	private static Room currentRoom = null;

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
