package com.sirma.itt.javacourse.intro;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GreatestCommonDivisorTest {
	@Test
	public void findGcdTest() {
		int commonDivisor = GreatestCommonDivisor.findGcd(5, 20);
		Assert.assertEquals(5, commonDivisor);
		commonDivisor = GreatestCommonDivisor.findGcd(10, 20);
		Assert.assertEquals(10, commonDivisor);

	}
}
