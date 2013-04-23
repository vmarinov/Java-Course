package com.sirma.itt.javacourse.introd;

/**
 * Run class for {@link GreatestCommonDivisor} .
 *
 * @author Ventsislav Marinov
 */
public class GreatestCommonDivisorDemo {
	public static void main(String args[]) {
		GreatestCommonDivisor gcd = new GreatestCommonDivisor();
		int result;
		result = gcd.findGcd(18, 36);
		System.out.println(result);
	}
}
