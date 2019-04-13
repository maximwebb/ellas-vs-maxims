package dev.game.plants;

import dev.game.gfx.AnimationHandler;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;
import dev.game.objects.SlashHandler;

import java.awt.image.BufferedImage;

public class Youmu extends Plant {

    private double charge = 0;
    private int slash = 0;

    private double chargeTime = 10;
    private int damage = 10;
    private int maxSlashes = 10;

    boolean active = false;
    boolean hasSlashed = false;

    AnimationHandler anim =
            new AnimationHandler(Assets.youmuSprites,10.0, 1);

    public Youmu(Vector2D pos, Vector2D velocity, int laneNum) {
        super(pos, velocity, laneNum, 400, 100, Assets.EMPTY);
    }

    public void update() {
        if (!active) {
            if (charge < chargeTime) {
                charge += Room.getRoom().getDeltaTime();
                this.sprite = anim.getFrame(5);
            }
            else {
                //show that it is ready
                this.sprite = anim.getFrame(0);
                //attack when there are enemies in front
                if (this.lane.getZombiesList().size() >= 1) {
                    active = true;
                    anim.play();
                }
            }
        }
        else {
            //turn off animations when it exceeds max slashes
            if (slash >= maxSlashes) {
                //reset after n slashes
                active = false;
                charge = 0;
                slash = 0;
                this.sprite = anim.getFrame(5);
            }
            //else, continue updating the animation
            else {
                if (anim.done()) {
                    //reset after each animation cycle
                    anim.reset();
                    slash += 1;
                    this.hasSlashed = false;
                }
                //he swings his sword at this frame
                if (anim.getFrameNumber() == 3 && !this.hasSlashed) {
                    ((GameRoom) Room.getRoom()).addGameObject(new SlashHandler(damage, lane));
                    this.hasSlashed = true;
                }
                this.sprite = anim.updateSprite();
            }
        }
    }
}

