package dev.game.rendering;

import dev.game.objects.GameObject;
import dev.game.objects.RenderedGameObject;

import java.awt.*;

public class Camera {
    private RenderSpace renderSpace;
    private Canvas canvas;

    public Camera(RenderSpace renderSpace, Canvas canvas) {
        this.renderSpace = renderSpace;
        this.canvas = canvas;
    }

    public RenderCall translate(GameObject gameObject){
        if (gameObject instanceof RenderedGameObject){

            RenderedGameObject renderedObject = (RenderedGameObject) gameObject;

            //Maybe someone less lazy than me can make this be done using floating point arithmetic
            float x = (renderedObject.getPos().x*canvas.getWidth())/renderSpace.getWidth();
            float y = (renderedObject.getPos().y*canvas.getHeight())/renderSpace.getHeight();

            int w = (renderedObject.getWidth() * canvas.getWidth()) / renderSpace.getWidth();
            int h = (renderedObject.getHeight() * canvas.getHeight()) / renderSpace.getHeight();

            return new RenderObject(renderedObject,(int)x,(int)y,w,h);
        }

        return null;
    }

}
