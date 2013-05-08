package com.sirma.itt.javacourse.intro;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QuicksortTest {
	@Test
	public void quickSortTest() {
		Quicksort quicksortTest = new Quicksort();
		Integer[] array = { 5, 4, 2, 1, 3 };
		Integer[] expected = { 1, 2, 3, 4, 5 };
		quicksortTest.quicksort(array);
		Assert.assertArrayEquals(expected, array);
		Integer[] array2 = { 4, 2, 5, 6, 7, 1, 9 };
		Integer[] expected2 = { 1, 2, 4, 5, 6, 7, 9 };
		quicksortTest.quicksort(array2);
		Assert.assertArrayEquals(expected2, array2);

	}
}
