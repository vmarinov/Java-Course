package com.sirma.itt.javacourse.introd;

/**
 * Class used to determine the greatest common divisor(gcd) of two numbers.
 */
public class GreatestCommonDivisor {
	/**
	 * Determines the greatest common divisor
	 *
	 * @return returns the gcd of the two numbers
	 */

	public static int findGcd(int a, int b) {

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


}
