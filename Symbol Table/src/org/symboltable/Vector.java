package org.symboltable;

import java.lang.Math;

/**
 * Java class to construct two-dimensional vectors.
 * 
 * @author shivam
 * 
 */
public class Vector {

	protected double dX;
	protected double dY;

	public Vector() {
		dX = dY = 0.0;
	}

	public Vector(double dX, double dY) {
		this.dX = dX;
		this.dY = dY;
	}

	/**
	 * Method to convert vector to a string.
	 * 
	 * @return Vector in string format.
	 */
	@Override
	public String toString() {
		return "Vector(" + dX + ", " + dY + ")";
	}

	/**
	 * Method to compute magnitude of the vector.
	 * 
	 * @return magnitude of the vector.
	 */
	public double length() {
		return Math.sqrt(dX * dX + dY * dY);
	}

	/**
	 * Method to compute sum of two vectors.
	 * 
	 * @param v1
	 *            Vector.
	 * @return Vector
	 */
	public Vector add(Vector v1) {
		Vector v2 = new Vector(this.dX + v1.dX, this.dY + v1.dY);
		return v2;
	}

	/**
	 * Method to subtract vector <i>v1</i> from <i>v</i>.
	 * 
	 * @param v1
	 *            Vector.
	 * @return Vector.
	 */
	public Vector sub(Vector v1) {
		Vector v2 = new Vector(this.dX - v1.dX, this.dY - v1.dY);
		return v2;
	}
}