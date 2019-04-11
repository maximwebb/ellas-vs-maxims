package dev.game.objects;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Slash extends RenderedGameObject {

    private int cur_slash = 0;
    private int delay = 3;
    private int timer = 0;

    public Slash(Vector2D pos) {
        super(pos, Vector2D.zero, 20, 20, Assets.slashes[0]);
    }

    @Override
    public void update()
    {
        timer += 1;
        if (timer >= delay) {
            timer = 0;
            cur_slash += 1;
            if (cur_slash >= 7) {
                ((GameRoom) Room.getRoom()).removeGameObject(this);
            } else {
                this.sprite = Assets.slashes[cur_slash];
            }
        }
    }
}
