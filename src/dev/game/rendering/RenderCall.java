package dev.game.rendering;

public abstract class RenderCall {
	private int x;
	private int y;

	public RenderCall(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
