package dev.game.projectiles;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.objects.RenderedGameObject;
import dev.game.rooms.Room;

public class Projectile extends RenderedGameObject {
	
	private Vector2D acceleration;
	
	public Projectile(Vector2D pos, Vector2D velocity, Vector2D acceleration) {
        super(pos, velocity, 20, 20, Assets.abhiBullet);
        this.acceleration = acceleration;
    }
	
	@Override
	public void update() {
		
		Vector2D newVelocity = this.velocity.add(this.acceleration.scale((float)Room.getRoom().getDeltaTime()));
		Vector2D displacement = this.velocity.add(newVelocity).scale((float)Room.getRoom().getDeltaTime()/2);
		
		this.velocity = newVelocity;
		this.pos = this.pos.add(displacement);
	}
}
