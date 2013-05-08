package com.sirma.itt.javacourse.exceptions;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.sirma.itt.javacourse.exceptions.ReadNumbers.MyException;

@RunWith(JUnit4.class)
public class ReadNumbersTest {
	@Test
	public void inputNumberTest() {
		ReadNumbers rNumbers = new ReadNumbers();
		int actual = 0;
		try {
			actual = rNumbers.inputNumber();
		} catch (MyException e) {
			e.printStackTrace();
		}
		int expected = 5;
		Assert.assertEquals(expected, actual);

	}
}
