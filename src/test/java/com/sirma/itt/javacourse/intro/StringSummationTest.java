package com.sirma.itt.javacourse.intro;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StringSummationTest {
	@Test
	public void subStrTest() {
		StringSummation stringSummationV2 = new StringSummation("12333", "444");
		String expected = "12";
		String actual = stringSummationV2.subStr(stringSummationV2.getFirstNum(),
				stringSummationV2.getSecondNum());
		Assert.assertEquals(expected, actual);
		stringSummationV2 = new StringSummation("522333", "444");
		expected = "522";
		actual = stringSummationV2.subStr(stringSummationV2.getFirstNum(),
				stringSummationV2.getSecondNum());
		Assert.assertEquals(expected, actual);
		stringSummationV2 = new StringSummation("572", "1999569");
		expected = "1999";
		actual = stringSummationV2.subStr(stringSummationV2.getFirstNum(),
				stringSummationV2.getSecondNum());
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void trimNumTest() {
		StringSummation stringSummationV2 = new StringSummation("12333", "444");
		String expected = "333";
		String actual = stringSummationV2.trimNum(stringSummationV2.getFirstNum(),
				stringSummationV2.getSecondNum());
		Assert.assertEquals(expected, actual);
		stringSummationV2 = new StringSummation("3412333", "444");
		expected = "333";
		actual = stringSummationV2.trimNum(stringSummationV2.getFirstNum(),
				stringSummationV2.getSecondNum());
		Assert.assertEquals(expected, actual);
		stringSummationV2 = new StringSummation("11111", "911");
		expected = "111";
		actual = stringSummationV2.trimNum(stringSummationV2.getFirstNum(),
				stringSummationV2.getSecondNum());
		Assert.assertEquals(expected, actual);
	}



	@Test
	public void tempSumTest() {
		StringSummation stringSummationV2 = new StringSummation("555", "333");
		String expected = "8";
		String actual = stringSummationV2.tempSum(2, stringSummationV2.getFirstNum(),
				stringSummationV2.getSecondNum(), false);
		Assert.assertEquals(expected, actual);
		stringSummationV2 = new StringSummation("579", "333");
		expected = "1";
		actual = stringSummationV2.tempSum(1, stringSummationV2.getFirstNum(),
				stringSummationV2.getSecondNum(), true);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void getSumTest() {
		StringSummation stringSummation = new StringSummation("2345", "999");
		String expected = "3344";
		String actual = stringSummation.getSum();
		Assert.assertEquals(expected, actual);
		stringSummation = new StringSummation("572", "199569");
		expected = "200141";
		actual = stringSummation.getSum();
		Assert.assertEquals(expected, actual);
	}
}
