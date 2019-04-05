package dev.game.objects;
import dev.game.collision.CollisionHelper;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.GameObject;
import dev.game.objects.Zombie;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Bullet extends RenderedGameObject {

    public Bullet(Vector2D pos, Vector2D velocity) {
        super(pos, velocity, 20, 20, Assets.abhiBullet);
    }

    @Override
    public void update()
    {
        super.update();

        for(GameObject object : ((GameRoom)Room.getRoom()).gameObjectsList) {
            if(object instanceof Zombie) {
                if(CollisionHelper.checkCollision(this.pos, ((Zombie)object).collider)) {
                    ((Zombie) object).damage(25);
                    ((GameRoom)Room.getRoom()).removeGameObject(this);
                }
            }
        }
    }
}
