package dev.game.ui;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.ClickAction;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class UIButton extends UIObject implements MouseListener {
	private ClickAction clickAction;
	private BufferedImage sprite_mouseover;
	private MouseListener mouseListener;

	public UIButton(Vector2D pos, int width, int height, ClickAction clickAction, BufferedImage sprite, BufferedImage sprite_mouseover) {
		super(pos, width, height, sprite);
		this.clickAction = clickAction;
		this.sprite_mouseover = sprite_mouseover;
	}

	public ClickAction getClickAction() {
		return clickAction;
	}

	public void setClickAction(ClickAction clickAction) {
		this.clickAction = clickAction;
		// As an example, for PlayButton it might be setClickAction(() -> {MainMenuRoom.goLevelSelect});
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		if (contains(mouseEvent.getX(), mouseEvent.getY())) {
			mouseOver();
		}
	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {
		if (contains(mouseEvent.getX(), mouseEvent.getY())) {
			mouseOff();
		}
	}

	public void mouseOver() {
		//Switch to the mouse-overed sprite
		BufferedImage spare = sprite;
		sprite = sprite_mouseover;
		sprite_mouseover = spare;
	}

	public void mouseOff() {
		//Switch back to the mouse-off sprite
		BufferedImage spare = sprite;
		sprite = sprite_mouseover;
		sprite_mouseover = spare;
	}
}
