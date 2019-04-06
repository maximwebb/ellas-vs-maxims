package dev.game.collision;

import dev.game.maths.Vector2D;

public class CollisionInfo {
	
	public final float lambda1;
	public final float lambda2;
	
	public CollisionInfo(float lambda1, float lambda2) {
		this.lambda1 = lambda1;
		this.lambda2 = lambda2;
	}
}
