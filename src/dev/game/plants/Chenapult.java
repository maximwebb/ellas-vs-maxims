package dev.game.plants;

import java.awt.image.BufferedImage;

import dev.game.collision.*;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.maths.VectorLine;
import dev.game.projectiles.Bullet;
import dev.game.projectiles.Projectile;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Chenapult extends Plant {

	private float shootingSpeed = 75;

	public Chenapult(Vector2D pos, Vector2D velocity, int laneNum) {
		super(pos, velocity, laneNum, 100, 100, Assets.chenapult);
	}

	public void shoot(Vector2D targetPos, Vector2D targetVelocity) {

		Vector2D initialDisplacement = this.pos.towards(targetPos);

		CollisionInfo solution = CollisionHelper.findIntersection(new VectorLine(targetVelocity, initialDisplacement), new CircleCollider(Vector2D.zero, shootingSpeed));

		if (solution != null && solution.lambda2 > 0) {

			float time = 1 / solution.lambda2;

			Vector2D gravity = new Vector2D(0, -20);

			Vector2D launchVelocity = initialDisplacement.scale(1 / time).add(targetVelocity).add(gravity.scale(-time / 2));

			//temporarily using Projectile class - this type of projectile should be its own class (which extends Projectile) so it can detect collisions
			((GameRoom) Room.getRoom()).addGameObject(new Projectile(this.pos, launchVelocity, gravity));
		}
	}
}
