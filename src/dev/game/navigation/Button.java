package dev.game.navigation;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.ClickAction;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

import java.awt.image.BufferedImage;

public class Button {
    protected Vector2D pos;
    private BufferedImage sprite;
    private int width;
    private int height;
    private ClickAction clickAction;

    public Button(Vector2D pos, BufferedImage sprite, int width, int height) {
        this.pos = pos;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
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
}
