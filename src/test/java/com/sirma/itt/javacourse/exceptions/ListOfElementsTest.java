package com.sirma.itt.javacourse.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ListOfElementsTest {

	@Test
	public void addTest() {
		ListOfElements listOfElements = new ListOfElements();
		listOfElements.add(5);
		Object[] expected = { 5, null, null, null, null };
		Object[] actual = listOfElements.getArray();
		org.junit.Assert.assertArrayEquals(expected, actual);
		listOfElements.add("Hello");
		Object[] expected2 = { 5, "Hello", null, null, null };
		actual = listOfElements.getArray();
		org.junit.Assert.assertArrayEquals(expected2, actual);
	}

	@Test
	public void removeTest() {
		ListOfElements listOfElements = new ListOfElements();
		Object[] expected = { 1, 5, "Hello", "next", null };
		listOfElements.add(1);
		listOfElements.add(5);
		listOfElements.add("Hello");
		listOfElements.add("next");
		listOfElements.add("this is going to be deleted");
		listOfElements.remove();
		Object[] actual = listOfElements.getArray();
		org.junit.Assert.assertArrayEquals(expected, actual);
	}

}
