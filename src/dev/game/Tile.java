package dev.game;

public class Tile {

    private int posX;
    private int posY;
    private int width;
    private int height;
    private boolean empty;
    private Plant plant;

    Tile(){
        empty = true;
    }

    public void setPosition(int x, int y){
        posX = x;
        posY = y;
    }

    public void setPlant(Plant p){
        plant = p;
    }

    public Plant getPlant(){
        return plant;
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public void setDimensions(int w, int h){
        width = w;
        height = h;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
