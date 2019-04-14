package dev.game.rendering;

import java.awt.image.BufferedImage;

public class RenderText extends RenderCall {
	private String text;

	public RenderText(String text, int x, int y) {
		super(x, y);
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
