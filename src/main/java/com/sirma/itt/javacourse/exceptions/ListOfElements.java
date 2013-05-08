package com.sirma.itt.javacourse.exceptions;

/**
 * Creates a list of elements. Elements can be added, removed and printed.
 *
 * @author Ventsislav Marinov
 */
public class ListOfElements {
	// holds the set length for the array
	private final int ARRAY_LENGTH = 5;
	// array to hold our elements
	private final Object[] array;
	/**
	 * Holds the count of inputed elements. If it exceeds the array length, exception is thrown.
	 */
	private int elementCount = 0;
	private boolean removed = false;
	/**
	 * Temporary array used to copy the elements of the initial array.
	 */
	private Object temp[];

	/**
	 * Constructs a new array with set length.
	 */
	public ListOfElements() {
		array = new Object[ARRAY_LENGTH];
	}

	/**
	 * Adds a new element into the array.
	 *
	 * @param obj
	 *            the passed element.
	 */
	public void add(Object obj) {
		if (isRemoved()) {
			array[array.length - 1] = obj;
			removed = false;
			elementCount++;
			return;
		} else {
			if (elementCount > (array.length - 1)) {
				// exception goes here (custom)
				throw new ArrayIndexOutOfBoundsException();
			} else {
				array[elementCount] = obj;

			}

		}
		elementCount++;
	}

	/**
	 * Removes an element in the end of the array. If the array is empty throws an exception.
	 */
	public void remove() {
		if (elementCount == 0) {
			throw new NullPointerException();
		} else {
			removed = true;
			array[array.length - 1] = null;
			elementCount--;
		}
	}

	/**
	 * Returns all elements in the array.
	 * 
	 * @param array
	 */
	public void printAllElements(Object[] array) {
		for (Object x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public Object[] getArray() {
		return array;
	}

	public int getElement() {
		return elementCount;
	}


	public boolean isRemoved() {
		return removed;
	}


}
