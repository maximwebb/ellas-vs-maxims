package dev.game;

import java.util.ArrayList;
import java.util.List;

public class Room {
    //List<RenderedGameObject> entities;
    List<GameObject> objects;

    public Room() {
        objects=new ArrayList<>();
    }

    public List<GameObject> getGameObjects() {
        return objects;
    }

    public void addGameObject(GameObject gameObject){
        objects.add(gameObject);
    }

}
