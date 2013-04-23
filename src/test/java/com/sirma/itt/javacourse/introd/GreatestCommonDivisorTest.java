package com.sirma.itt.javacourse.introd;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GreatestCommonDivisorTest {
	@Test
	public void findGcdTest() {
		GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
		int commonDivisor = greatestCommonDivisor.findGcd(5, 20);
		Assert.assertEquals(5, commonDivisor);
		greatestCommonDivisor = new GreatestCommonDivisor();
		commonDivisor = greatestCommonDivisor.findGcd(10, 20);
		Assert.assertEquals(10, commonDivisor);

	}
}
