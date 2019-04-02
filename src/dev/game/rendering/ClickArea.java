package dev.game.rendering;

import dev.game.objects.ClickAction;

public class ClickArea {
    private int x;
    private int y;
    private int w;
    private int h;
    private ClickAction clickAction;

    public ClickArea(int x, int y, int w, int h, ClickAction clickAction) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.clickAction = clickAction;
    }

    public boolean contains(int x, int y){
        return this.x<x && this.x+w>x && this.y<y && this.y+h>y;
    }

    public void click(){
        clickAction.run();
    }
}
