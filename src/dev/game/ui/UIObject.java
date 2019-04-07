package dev.game.ui;

import dev.game.maths.Vector2D;
import dev.game.rooms.Room;

public abstract class UIObject {
	protected Vector2D pos;
	protected int width, height;
	protected boolean hovering = false;

	public UIObject(Vector2D pos, int width, int height) {
		this.pos = pos;
		this.width = width;
		this.height = height;
	}

	public void setPos(Vector2D newPos) {
		pos = newPos;
	}

	public Vector2D getPos() {
		return pos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public abstract void update();
}
