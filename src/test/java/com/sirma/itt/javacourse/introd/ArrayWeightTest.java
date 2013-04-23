package com.sirma.itt.javacourse.introd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayWeightTest {
	@Test
	public void findWeightTest() {
		ArrayWeight arrayW = new ArrayWeight();
		int[] array = { 1, 2, 3, 4, 5 };
		int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int[] array3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int arrayWeight = arrayW.findWeight(array);
		Assert.assertEquals(4, arrayWeight);
		arrayWeight = arrayW.findWeight(array2);
		Assert.assertEquals(11, arrayWeight);
		arrayWeight = arrayW.findWeight(array3);
		Assert.assertEquals(12, arrayWeight);

	}

}
