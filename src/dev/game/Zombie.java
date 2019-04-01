package dev.game;

import java.util.Vector;

import dev.game.collision.CircleCollider;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Zombie extends RenderedGameObject {

	int energyLevel;
	public CircleCollider collider;

	public Zombie(int posX, int posY, int velX, int velY) {
		super(posX, posY, velX, velY, Assets.zombie);
		energyLevel = 100;
		collider = new CircleCollider(new Vector2D(posX, posY), 50);
	}
	
	public void damage(int damage) {
		energyLevel -= damage;
	}
	
	@Override
	public void update() {
		
		super.update();
		
		collider.pos = new Vector2D(this.getPosX(), this.getPosY());
		if(energyLevel <= 0) {
			((GameRoom) Room.getRoom()).removeGameObject(this);
		}
	}
}
