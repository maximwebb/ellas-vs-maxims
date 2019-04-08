package dev.game.ui;

import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;
import dev.game.rooms.Room;

import java.awt.image.BufferedImage;

public abstract class UIObject extends RenderedGameObject {
	protected boolean hovering = false;

	public UIObject(Vector2D pos, int width, int height, BufferedImage sprite) {
		super(pos, Vector2D.zero, width, height, sprite);
	}

}
