package com.sirma.itt.javacourse.intro;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReverseArrayTest {
	@Test
	public void reverseTest() {
		ReverseArray reverseArray = new ReverseArray();
		int[] array = { 1, 2, 3, 4, 5 };
		int[] expected = { 5, 4, 3, 2, 1 };
		int[] actualArray = reverseArray.reverse(array);
		Assert.assertArrayEquals("Fail", expected, actualArray);
		int[] array2 = { 2, 5, 8, 4 };
		int[] expected2 = { 4, 8, 5, 2 };
		actualArray = reverseArray.reverse(array2);
		Assert.assertArrayEquals("Fail", expected2, actualArray);
	}
}
