package dev.game.objects;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.zombies.Zombie;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

//deals damage to every zombie on the map
public class SlashHandler extends RenderedGameObject {

    int damage;

    public SlashHandler(int damage) {
        super(Vector2D.zero, Vector2D.zero, 0, 0, Assets.ella);
        this.damage = damage;
    }

    @Override
    public void update()
    {
        //damage all zombies
        for(GameObject object : ((GameRoom)Room.getRoom()).gameObjectsList) {
            if(object instanceof Zombie) {
                //damage
                ((Zombie) object).damage(this.damage);
                //display wacky slash animation
                ((GameRoom) Room.getRoom()).addGameObject(new Slash(((Zombie) object).pos));
            }
        }
        ((GameRoom) Room.getRoom()).removeGameObject(this);
    }

    public int getDamage() {
        return this.damage;
    }
}
