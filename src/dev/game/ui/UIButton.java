package dev.game.ui;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.ClickAction;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UIButton {
    protected Vector2D pos;
    private BufferedImage sprite, sprite_mouseover;
    private int width, height;
    private ClickAction clickAction;

    public UIButton(Vector2D pos, BufferedImage sprite, BufferedImage sprite_mouseover, int width, int height) {
        this.pos = pos;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        this.sprite_mouseover = sprite_mouseover;
        this.clickAction = null;
    }

    public Vector2D getPos() {
        return pos;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
