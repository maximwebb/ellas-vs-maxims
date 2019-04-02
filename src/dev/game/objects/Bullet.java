package dev.game.objects;

import dev.game.collision.CollisionHelper;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

//To-do: Abhi sprite instead of Ella
public class Bullet extends RenderedGameObject {
    
	public Bullet(float posX, float posY) {
        super(posX, posY, 10, 10, 10,0, Assets.ella);
    }
    
    @Override
    public void update()
    {
    	super.update();
    	
    	for(GameObject object : ((GameRoom)Room.getRoom()).gameObjectsList) {
			if(object instanceof Zombie) {
				if(CollisionHelper.checkCollision(new Vector2D(this.getPosX(), this.getPosY()), ((Zombie)object).collider)) {
					System.out.println("hit registered: " + this.getPosY());
					((Zombie) object).damage(25);
					((GameRoom)Room.getRoom()).removeGameObject(this);
				}
			}
    	}
    }
}
