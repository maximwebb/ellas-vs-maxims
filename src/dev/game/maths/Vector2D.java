package dev.game.maths;

public class Vector2D
{
	public static final Vector2D i = new Vector2D(1f, 0f);
	public static final Vector2D j = new Vector2D(0f, 1f);
	
	private float x;
	private float y;
	private float r; //vector length
	
	//constructor
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	//alternative constructor with length and angle (measured from +ve x-axis) as arguments
	public Vector2D(float r, double angle) {
		this((float)(r * Math.cos(angle)), (float)(r * Math.sin(angle)));
	}
	
	//get x
	public float x() {
		return this.x;
	}
	
	//get y
	public float y() {
		return this.y;
	}
	
	//return length of a vector
	public float length() {
		return (float)Math.sqrt(this.dot(this));
	}
	
	//return unit vector of this
	public Vector2D unitVector() {
		return this.scale(1/this.length());
	}
	
	//add two vectors
	public Vector2D add(Vector2D v) {
		return new Vector2D(this.x + v.x, this.y + v.y);
	}
	
	//multiply a vector by a scalar
	public Vector2D scale(float scalar) {
		return new Vector2D(this.x * scalar, this.y * scalar);
	}
	
	//dot product two vectors
	public float dot(Vector2D v) {
		return this.x * v.x + this.y * v.y;
	}
	
	//multiply vector by a matrix
	public Vector2D transform(Matrix m) {
		return m.mult(this);
	}
}
