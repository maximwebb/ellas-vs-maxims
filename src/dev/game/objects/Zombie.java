package dev.game.objects;

import dev.game.collision.CircleCollider;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Zombie extends RenderedGameObject {

	private int health;
	public CircleCollider collider;

	public Zombie(Vector2D pos, Vector2D velocity) {
		super(pos, velocity, 18, 32, Assets.zombie);
		health = 100;
		setClickAction(() ->  ((GameRoom) Room.getRoom()).removeGameObject(this) );
		collider = new CircleCollider(this.pos, 10);
	}
	
	public void damage(int damage) {
		health -= damage;
	}
	
	@Override
	public void update() {
		
		super.update();
		
		collider.pos = this.pos;
		
		if(health <= 0) {
			((GameRoom) Room.getRoom()).removeGameObject(this);
		}
	}
}
