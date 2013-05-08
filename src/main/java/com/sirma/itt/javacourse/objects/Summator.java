package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Class used to determine the sum of two numbers.
 *
 * @author Ventsislav Marinov
 */
public class Summator {
	/**
	 * Method used to sum two integers.
	 *
	 * @param a
	 *            first integer
	 * @param b
	 *            second integer
	 * @return returns the sum
	 */
	public int sum(int a, int b) {
		int sum = a + b;
		return sum;
	}

	/**
	 * Method used to sum two floating point numbers.
	 *
	 * @param a
	 *            first number
	 * @param b
	 *            second number
	 * @return returns the sum
	 */

	public double sum(double a, double b) {
		double sum = a + b;
		return sum;
	}

	/**
	 * Method used to find the sum of two numbers.
	 *
	 * @param a
	 *            first number
	 * @param b
	 *            second number
	 * @return returns the sum
	 */
	public int sum(String a, String b) {
		int sum = Integer.parseInt(a) + Integer.parseInt(b);
		return sum;
	}

	/**
	 * Method used to find the sum of two Objects (BigInteger)
	 *
	 * @param a
	 *            first BigInteger value
	 * @param b
	 *            second BigInteger value
	 * @return returns the sum
	 */
	public BigInteger sum(BigInteger a, BigInteger b) {
		BigInteger sum = a.add(b);
		return sum;
	}

	/**
	 * Method used to find the sum of two Objects (BigDecimal)
	 *
	 * @param a
	 *            first BigDecimal value
	 * @param b
	 *            second BigDecimal value
	 * @return returns the sum
	 */
	public BigDecimal sum(BigDecimal a, BigDecimal b) {
		BigDecimal sum = a.add(b);
		return sum;
	}
}
