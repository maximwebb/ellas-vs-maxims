package dev.game.rooms;

import dev.game.rendering.RenderCall;
import dev.game.ui.UIManager;

import java.awt.image.BufferedImage;

public abstract class Room {
	private UIManager uiManager = new UIManager();
	
	private double deltaTime;
	
	private static Room currentRoom = null;

	private BufferedImage background;

	public Room(BufferedImage background) {
		this.background = background;
	}

	public BufferedImage getBackground() {
		return background;
	}

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

    public UIManager getUiManager() {
    	return uiManager;
	}
}
