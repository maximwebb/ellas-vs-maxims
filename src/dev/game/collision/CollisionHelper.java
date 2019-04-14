package dev.game.collision;

import dev.game.maths.*;

public class CollisionHelper {

	//simple collision detector to test if a point is within a circular region
	public static boolean checkCollision(Vector2D point, CircleCollider region) {

		//return true if the length of the vector between point & region.pos is less that region.radius
		return point.scale(-1).add(region.pos).length() <= region.radius;
	}

	//same as previous method except now the point is a circle with a specified radius
	//public static boolean checkCollision(Vector2D point, float radius, CircleCollider region) {
	//	return checkCollision(point, new CircleCollider(region.pos, region.radius + radius));
	//}

	//complex collision detector which checks if a point moving along a vector (defined by a VectorLine) will intersect a circular region.
	//returns information about the collision in a CollisionInfo object
	//if two objects have a constant relative velocity, this method can be used to check if and when they will collide
	//has uses for solving other simultaneous equations involving vectors and their magnitudes
	public static CollisionInfo findIntersection(VectorLine ray, CircleCollider region) {

		//perpendicular ray with position vector at centre of circle collider
		VectorLine perpRay = new VectorLine(region.pos, ray.dirn.unitVector().perp());

		//using matrix multiplication to solve simultaneous equations to obtain lambdas for collision point of rays
		Vector2D result = ray.pos.towards(perpRay.pos).transform(new Matrix(ray.dirn, perpRay.dirn).inverse());

		float minDistance = Math.abs(result.y);
		float lambda = result.x;

		//sets lambda value at both collision points if they exist - if ray.dirn() is a velocity, this is equal to time until collision
		if (minDistance == region.radius) {

			return new CollisionInfo(lambda, lambda);

		} else if (minDistance < region.radius) {

			float lambdaOffset = (float) Math.sqrt(Math.pow(region.radius, 2) - Math.pow(minDistance, 2)) / ray.dirn.length();
			return new CollisionInfo(lambda - lambdaOffset, lambda + lambdaOffset);
		}

		return null;
	}

	//same as previous method except now the moving point is a circle with a specified radius
	//public static boolean checkCollision(VectorLine ray, float radius, CircleCollider region) {
	//	return checkCollision(ray, new CircleCollider(region.pos, region.radius + radius));
	//}
}
