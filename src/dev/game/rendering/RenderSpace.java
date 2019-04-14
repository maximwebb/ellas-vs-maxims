package dev.game.rendering;

//Poorly named
public class RenderSpace {
	private int width;
	private int height;

	private RenderSpace(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	static public RenderSpace getStandard() {
		RenderSpace renderSpace = new RenderSpace(240, 160);
		return renderSpace;
	}
}
