package dev.game.plants;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;
import dev.game.objects.SlashHandler;

public class Youmu extends Plant {

    private double charge = 0;
    private int slash = 0;
    //timer for sprite animation
    private int anim_step = 0;
    private int anim_delay_timer = 0;

    private int anim_delay = 4;
    private double charge_time = 5;
    private int damage = 50;
    private int max_slashes = 10;

    boolean has_exploded = false;

    public Youmu(Vector2D pos, Vector2D velocity, int laneNum) {
        super(pos, velocity, laneNum, 1000, 10, Assets.youmu[0]);
    }

    public void update() {
        if (charge < charge_time) {
            charge += Room.getRoom().getDeltaTime();
        }

        if(charge >= charge_time) {
            anim_delay_timer += 1;
            if (anim_delay_timer > anim_delay) {
                anim_delay_timer = 0;

                anim_step += 1;

                //reset if loop done
                if (anim_step >= 6) {
                    //remove after n slashes
                    if (slash >= max_slashes) {
                        ((GameRoom) Room.getRoom()).removeGameObject(this);
                    }
                    //reset for next loop
                    else {
                        anim_step = 0;
                        this.sprite = Assets.youmu[0];
                    }
                }
                //perform slash when he swings his sword
                else if (anim_step == 3) {
                    this.sprite = Assets.youmu[3];
                    ((GameRoom) Room.getRoom()).addGameObject(new SlashHandler(damage));
                    slash += 1;
                    if (slash >= max_slashes) {
                        has_exploded = true;
                        this.sprite = Assets.explosion;
                    }
                }
                //update animation
                else {
                    this.sprite = Assets.youmu[anim_step];
                    if (has_exploded) {
                        this.sprite = Assets.explosion;
                    }
                }
            }
        }
    }
}
