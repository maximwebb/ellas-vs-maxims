package dev.game.maths;

public class VectorLine {
	
	public final Vector2D pos; //position vector
	public final Vector2D dirn; //direction vector
	//public float lambda; //lambda for an arbitrary point along the line
	
	public VectorLine(Vector2D pos, Vector2D dirn) {
		this.pos = pos;
		this.dirn = dirn;
	}
	
	public Vector2D getPosAt(float lambda) {
		return this.pos.add(dirn.scale(lambda));
	}
}
