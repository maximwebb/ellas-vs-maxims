package dev.game.collision;

import dev.game.maths.Vector2D;

public class CircleCollider {

	public Vector2D pos; //position vector of circle centre
	public float radius; //radius of circle collider

	public CircleCollider(Vector2D pos, float radius) {
		this.pos = pos;
		this.radius = radius;
	}
}
