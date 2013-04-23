package com.sirma.itt.javacourse.introd;

/**
 * Class used to determine the greatest common divisor(gcd) of two numbers.
 */
public class GreatestCommonDivisor {
	// first number
	private int a;
	// second number
	private int b;

	/**
	 * Determines the greatest common divisor
	 *
	 * @return returns the gcd of the two numbers
	 */

	public int findGcd(int a, int b) {
		this.a = a;
		this.b = b;
		// holds the gcd of the two numbers
		int result = 0;
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else if (a < b) {
				b = b - a;
			}
		}
		result = a;
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
