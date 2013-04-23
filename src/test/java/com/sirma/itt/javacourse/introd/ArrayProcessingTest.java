package com.sirma.itt.javacourse.introd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class ArrayProcessingTest {

	@Test
	public void getMinElementTest() {
		ArrayProcessing arrayProcessing = new ArrayProcessing();

		int[] array = new int[] { 3, 5, 3, 7, 8, 9, 1 };
		int minElement = arrayProcessing.getMinElement(array);
		Assert.assertEquals(1, minElement);

	}

	@Test
	public void getSumTest() {
		ArrayProcessing arrayProcessing = new ArrayProcessing();
		int[] array = { 1, 2, 3, 4 };
		int sum = arrayProcessing.getSum(array);
		Assert.assertEquals(10, sum);
		Assert.assertEquals(11, sum);
	}

}
