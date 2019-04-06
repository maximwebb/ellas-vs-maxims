package dev.game.projectiles;

import dev.game.collision.CollisionHelper;
import dev.game.maths.Vector2D;
import dev.game.objects.GameObject;
import dev.game.objects.Zombie;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Bullet extends Projectile {
	
	private int damage;
	
    public Bullet(Vector2D pos, Vector2D velocity, int damage) {
		super(pos, velocity, Vector2D.zero);
		this.damage = damage;
	}

	@Override
    public void update()
    {
        super.update();
        
        for(GameObject object : ((GameRoom)Room.getRoom()).gameObjectsList) {
            if(object instanceof Zombie) {
                if(CollisionHelper.checkCollision(this.pos, ((Zombie)object).collider)) {
                    ((Zombie) object).damage(this.damage);
                    ((GameRoom)Room.getRoom()).removeGameObject(this);
                }
            }
        }
    }
}
