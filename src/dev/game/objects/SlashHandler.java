package dev.game.objects;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.rooms.Lane;
import dev.game.zombies.Zombie;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

//deals damage to every zombie on the map
public class SlashHandler extends RenderedGameObject {

	int damage;
	Lane lane;

	public SlashHandler(int damage, Lane lane) {
		super(Vector2D.zero, Vector2D.zero, 0, 0, Assets.ella);
		this.damage = damage;
		this.lane = lane;
	}

	@Override
	public void update() {
		//damage all zombies in lane
		for (Zombie zombie : lane.getZombiesList()) {
			//damage
			((Zombie) zombie).damage(this.damage);
			//display wacky slash animation
			((GameRoom) Room.getRoom()).addGameObject(new Slash(((Zombie) zombie).pos));
		}
		((GameRoom) Room.getRoom()).removeGameObject(this);
	}

	public int getDamage() {
		return this.damage;
	}
}