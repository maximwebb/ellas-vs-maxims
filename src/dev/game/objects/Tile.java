package dev.game.objects;

import dev.game.maths.Vector2D;
import dev.game.plants.Plant;

public class Tile extends RenderedGameObject {

    private boolean empty;
    private Plant plant;

    public Tile(Vector2D vector, int width, int height){
        super(vector, new Vector2D(0f, 0f), width, height, null);
        empty = true;
    }

    public void setPosition(int x, int y){

    }

    public void setPlant(Plant p){
        plant = p;
    }

    public Plant getPlant(){
        return plant;
    }

    public boolean isEmpty(){ return empty; }

    public void setEmpty(boolean empty){ this.empty = empty; }

}
