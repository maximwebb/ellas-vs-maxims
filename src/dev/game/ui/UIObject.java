package dev.game.ui;

import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;
import dev.game.rooms.Room;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public abstract class UIObject extends RenderedGameObject {
	protected boolean hovering = false;
	public int x, y, width, height;

	public UIObject(Vector2D pos, int width, int height, BufferedImage sprite) {
		super(pos, Vector2D.zero, width, height, sprite);
	}

	public boolean contains(int x, int y){
		return this.x<x && this.x+width>x && this.y<y && this.y+height>y;
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}
