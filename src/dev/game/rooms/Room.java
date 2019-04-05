package dev.game.rooms;

import dev.game.rendering.RenderCall;

public abstract class Room {
	
	private double deltaTime;
	
	private static Room currentRoom = null;

	public static void setRoom(Room room) {
		currentRoom = room;
	}

	public static Room getRoom() {
		return currentRoom;
	}

	public abstract void init();
	
    public void tick(double deltaTime) {
    	this.deltaTime = deltaTime;
    }
    
    public double getDeltaTime() {
    	return this.deltaTime;
    }

    public abstract Iterable<RenderCall> render();
}
