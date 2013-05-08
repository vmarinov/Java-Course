package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SummatorTest {
	@Test
	public void intSumTest() {
		Summator summator = new Summator();
		int expected = 4;
		int actual = summator.sum(2, 2);
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void doubleSumTest() {
		Summator summator = new Summator();
		double expected = 2.5;
		double actual = summator.sum(1.5, 1.0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void stringSumTest() {
		Summator summator = new Summator();
		int expected = 10;
		int actual = summator.sum("6", "4");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void bigIntSumTest() {
		Summator summator = new Summator();
		BigInteger a = new BigInteger("255000");
		BigInteger b = new BigInteger("245000");
		BigInteger actual = summator.sum(a, b);
		BigInteger expected = new BigInteger("500000");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void bigDecimalSumTest() {
		Summator summator = new Summator();
		BigDecimal expected = new BigDecimal("1000000");
		BigDecimal a = new BigDecimal("500000");
		BigDecimal b = new BigDecimal("500000");
		BigDecimal actual = summator.sum(a, b);
		Assert.assertEquals(expected, actual);
	}

}
