package com.sirma.itt.javacourse.intro;

/**
 * Class used to determine the least common multiple(lcm) of two numbers.
 *
 * @author Ventsislav Marinov
 */
public class LeastCommonMultiple {

	/**
	 * Used to determine the least common multiple of two numbers.
	 *
	 * @param a
	 *            - First number.
	 * @param b
	 *            - Second number.
	 * @return returns the lcm of the two numbers
	 */
	public static int findLcm(int a, int b) {

		GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
		// holds the lcm of the two numbers
		int result = 0;
		// holds the greatest common divisor
		int gcd = greatestCommonDivisor.findGcd(a, b);
		result = (a * b) / gcd;
		return result;
	}


}
