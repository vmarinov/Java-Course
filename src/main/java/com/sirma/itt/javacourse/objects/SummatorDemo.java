package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SummatorDemo {
	public static void main(String args[]) {
		Summator summator = new Summator();
		System.out.println("The sum of the int a and b is " + summator.sum(10, 5));
		System.out.println("The sum of the floating point a and b is " + summator.sum(2.0, 3.0));
		System.out.println("The sum of a and b represented " + "by strings is "
				+ summator.sum("6", "4"));
		BigInteger firstBigInt = new BigInteger("288444");
		BigInteger secondBigInt = new BigInteger("334353");
		System.out.println("The sum of the BigIntegers a and b is "
				+ summator.sum(firstBigInt, secondBigInt));
		BigDecimal firstBigDecimal = new BigDecimal("546464747472");
		BigDecimal secondBigDecimal = new BigDecimal("53536536536");
		System.out.println("The sum of the BigDecimals a and b is "
				+ summator.sum(firstBigDecimal, secondBigDecimal));
	}
}
