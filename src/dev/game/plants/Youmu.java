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
	private int anim_step = -1;     //will be incremented to one
	private int anim_delay_timer = 0;

	private int anim_delay = 4;
	private double charge_time = 10;
	private int damage = 10;
	private int max_slashes = 10;

	boolean active = false;

	public Youmu(Vector2D pos, Vector2D velocity, int laneNum) {
		super(pos, velocity, laneNum, 400, 10, Assets.youmu[5]);
	}

	public void update() {
		if (!active) {
			if (charge < charge_time) {
				charge += Room.getRoom().getDeltaTime();
			} else {
				//show that it is ready
				this.sprite = Assets.youmu[0];
				//attack when there are enemies in front
				if (this.lane.getZombiesList().size() >= 1) {
					active = true;
				}
			}
		} else {
			anim_delay_timer += 1;
			if (anim_delay_timer > anim_delay) {
				anim_delay_timer = 0;

				anim_step += 1;

				//reset if loop done
				if (anim_step >= 6) {
					//reset after n slashes
					if (slash >= max_slashes) {
						active = false;
						charge = 0;
						slash = 0;
						this.sprite = Assets.youmu[5];
					}
					//ready for next loop
					else {
						anim_step = 0;
						this.sprite = Assets.youmu[0];
					}
				}
				//perform slash when he swings his sword
				else if (anim_step == 3) {
					this.sprite = Assets.youmu[3];
					((GameRoom) Room.getRoom()).addGameObject(new SlashHandler(damage, lane));
					slash += 1;
				}
				//update animation
				else {
					this.sprite = Assets.youmu[anim_step];
				}
			}
		}
	}
}

