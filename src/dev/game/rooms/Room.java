package dev.game.rooms;

import dev.game.rendering.RenderCall;

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

    public abstract Iterable<RenderCall> render();
}
