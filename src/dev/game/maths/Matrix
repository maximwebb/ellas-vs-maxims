package dev.game.maths;

public class Matrix {
	
	private Vector2D v1;
	private Vector2D v2;
	
	//constructor with the two column vectors as arguments
	public Matrix(Vector2D v1, Vector2D v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
	
	//alternative constructor with 4 numbers as arguments
	public Matrix(float a, float b, float c, float d) {
		this(new Vector2D(a, c), new Vector2D(b, d));
	}
	
	//calculate determinant of a matrix
	public float determinant() {
		return this.v1.x() * this.v2.y() - this.v1.y() * this.v2.x();
	}
	
	//return inverse of a matrix
	public Matrix inverse() {
		return new Matrix(this.v2.y(), -this.v2.x(), -this.v1.y(), this.v1.x()).scale(1/this.determinant());
	}
	
	//multiply matrix by a scalar
	public Matrix scale(float scalar) {
		return new Matrix(this.v1.scale(scalar), this.v2.scale(scalar));
	}
	
	//transform vector with a matrix
	public Vector2D mult(Vector2D v) {
		return this.v1.scale(v.x()).add(this.v2.scale(v.y()));
	}
	
	//multiply two matrices together
	public Matrix mult(Matrix m) {
		return new Matrix(this.mult(m.v1), this.mult(m.v2));
	}
}
