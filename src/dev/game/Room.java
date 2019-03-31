package dev.game;

import java.util.ArrayList;
import java.util.List;

public class Room {
    List<RenderedGameObject> entities;


    public Room() {
        entities=new ArrayList<>();
    }

    public List<RenderedGameObject> getEntities() {
        return entities;
    }

    public void addEntity(RenderedGameObject renderedGameObject){
        entities.add(renderedGameObject);
    }



}
