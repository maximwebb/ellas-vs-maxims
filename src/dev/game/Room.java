package dev.game;

import java.util.ArrayList;
import java.util.List;

public class Room {
    List<Entity> entities;

    public Room() {
        entities=new ArrayList<>();
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }
}
