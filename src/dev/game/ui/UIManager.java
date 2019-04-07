package dev.game.ui;

import dev.game.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIManager {
    BufferedImage background;
    String text;
    Button button;
    Button button2;
    Button button3;

    public UIManager() {

    }

    public void init() {

    }

    public void goMainMenu() {
        background = ImageLoader.loadImage("/backgrounds/lawn.png");
    }

    public void goLevelSelect() {

    }

    public void goGame() {

    }

    /* To add:
    createPlantMenu()

     */
}
