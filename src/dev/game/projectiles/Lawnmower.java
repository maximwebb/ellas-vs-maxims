package dev.game.projectiles;

import dev.game.Game;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;
import dev.game.rendering.RenderSpace;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Lane;
import dev.game.rooms.Room;
import dev.game.zombies.Zombie;

public class Lawnmower extends RenderedGameObject {
	private int laneNumber;
	protected Lane lane;
	protected boolean launched = false;

	public Lawnmower(Vector2D pos, int laneNum) {
		super(pos, Vector2D.zero, 23, 18, Assets.lawnmower);
		this.lane = ((GameRoom)Game.getInstance().gameRoom).getLanesList()[laneNum];
	}

	public void update() {
		super.update();
		for (Zombie zombie : this.lane.getZombiesList()) {
			if (zombie.getPos().x < this.getPos().x + this.getWidth()) {
				if (!launched) {
					launched = true;
					launch();
				}
				zombie.damage(4000);
			}
			if (launched) {
				if (this.getPos().x > RenderSpace.getStandard().getWidth()) {
					this.lane.removeLawnmower(this);
				}
			}
		}
	}

	public void launch() {
		this.velocity = new Vector2D(60f, 0);
	}

	public int getLaneNumber() { return this.laneNumber; }
}
