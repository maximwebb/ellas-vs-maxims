package dev.game.rendering;

import dev.game.objects.ClickAction;
import dev.game.objects.RenderedGameObject;

public class RenderObject extends RenderSprite {
    private RenderedGameObject gameObject;
    private ClickArea clickArea;

    public RenderObject(RenderedGameObject gameObject, int x, int y, int width, int height) {
        super(gameObject.getSprite(), x, y, width, height);
        this.gameObject=gameObject;
        clickArea = new ClickArea(getX(),getY(),getWidth(),getHeight(),gameObject.getClickAction());
    }

    public Boolean hasMouseAction(){
        return gameObject.getClickAction()!=null;
    }

    public ClickArea getClickArea(){
        return clickArea;
    }
}
