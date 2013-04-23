package com.sirma.itt.javacourse.introd;

/**
 * Class used to determine the least common multiple(lcm) of two numbers.
 * 
 * @author Ventsislav Marinov
 */
public class LeastCommonMultiple {
	private int a;
	private int b;

	/**
	 * Used to determine the least common multiple of two numbers.
	 *
	 * @param a
	 *            - First number.
	 * @param b
	 *            - Second number.
	 * @return returns the lcm of the two numbers
	 */
	public int findLcm(int a, int b) {
		this.a = a;
		this.b = b;
		GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
		// holds the lcm of the two numbers
		int result = 0;
		// holds the greatest common divisor
		int gcd = greatestCommonDivisor.findGcd(this.a, this.b);
		result = (a * b) / gcd;
		return result;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}
