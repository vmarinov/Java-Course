package com.sirma.itt.javacourse.intro;

/**
 * Class used for processing arrays.
 *
 * @author Ventsislav Marinov
 */
public class ArrayProcessing {

	/**
	 * Determines the minimum element in the array.
	 *
	 * @param array
	 *            to be processed
	 * @return returns the minimum element of the array
	 */
	public static int getMinElement(int[] array) {
		// used to store the minimum element
		int minElement = array[0];

		// checks every element of the array and determines the minimum
		for (int x : array) {
			if (x < minElement) {
				minElement = x;
			}
		}
		return minElement;
	}

	/**
	 * Determines the sum of the elements in the array.
	 *
	 * @param array
	 *            to be summed.
	 * @return Returns the sum of the elements in the array.
	 */
	public static int getSum(int[] array) {
		int sum = 0;
		for (int x : array) {
			sum += x;
		}
		return sum;
	}

	/**
	 * Prints the array
	 *
	 * @param array
	 *            to be printed
	 */

	public static void printArray(int[] array) {
		for (int x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

}
