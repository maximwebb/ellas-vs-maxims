package dev.game.ui;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.ClickAction;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UIButton extends UIObject {
    private ClickAction clickAction;

    public UIButton(Vector2D pos, int width, int height, ClickAction clickAction, BufferedImage sprite) {
        super(pos, width, height, sprite);
        this.clickAction = clickAction;
    }


    public ClickAction getClickAction() {
        return clickAction;
    }

    public void setClickAction(ClickAction clickAction) {
        this.clickAction = clickAction;
        // As an example, for PlayButton it might be setClickAction(() -> {MainMenuRoom.goLevelSelect});
    }

    public void mouseOver() {
        //Switch to sprite_mouseover
    }

    public void mouseOff() {
        //Switch to the default sprite
    }
}
