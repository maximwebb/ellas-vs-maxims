package dev.game.ui;

import dev.game.gfx.ImageLoader;
import dev.game.maths.Vector2D;
import dev.game.objects.ClickAction;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class UIManager {

	public ArrayList<UIObject> uiObjectsList;

    public UIManager() {
    	uiObjectsList = new ArrayList<>();
    }

    public void addButton(Vector2D pos, int width, int height, ClickAction clickAction, BufferedImage sprite, BufferedImage sprite_mouseover) {
		uiObjectsList.add(new UIButton(pos, width, height, clickAction, sprite, sprite_mouseover));
    }
}
