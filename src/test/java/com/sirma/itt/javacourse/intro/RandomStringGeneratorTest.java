package com.sirma.itt.javacourse.intro;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RandomStringGeneratorTest {
	@Test
	public void generateStringTest() {
		RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
		String s = randomStringGenerator.generateString(5);
		Assert.assertEquals(5, s.length());
	}

}
