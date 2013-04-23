package com.sirma.itt.javacourse.introd;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LeastCommonMultipleTest {
	@Test
	public void findLcmTest() {
		LeastCommonMultiple lcm = new LeastCommonMultiple();
		int multiple = lcm.findLcm(14, 21);
		Assert.assertEquals(42, multiple);
		multiple = lcm.findLcm(27, 42);
		Assert.assertEquals(378, multiple);
	}
}
