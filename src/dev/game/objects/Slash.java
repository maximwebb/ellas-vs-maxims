package dev.game.objects;

import dev.game.gfx.AnimationHandler;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.gfx.AnimationHandler;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Slash extends RenderedGameObject {
animation-handler
    public Slash(Vector2D pos) {
        super(pos, Vector2D.zero, 20, 20, Assets.EMPTY);
    }

    private AnimationHandler anim =
            new AnimationHandler(Assets.slashSprites, 20.0, 1);

    @Override
    public void update()
    {
        this.sprite = anim.updateSprite();
        if (anim.done()) {
            ((GameRoom) Room.getRoom()).removeGameObject(this);
        }
    }
}
