package com.sirma.itt.javacourse.intro;

/**
 * Class used to reverse arrays.
 *
 * @author Ventsislav Marinov
 */
public class ReverseArray {
	/**
	 * Used to reverse a given array.
	 * 
	 * @param array
	 *            The array to be reversed.
	 * @return Returns the array in back order.
	 */
	public static int[] reverse(int[] array) {
		int firstElement;
		int secondElement;
		int temp = 0;
		for (firstElement = 0, secondElement = array.length - 1; firstElement <= (secondElement - 1);) {
			temp = array[firstElement];
			array[firstElement] = array[secondElement];
			array[secondElement] = temp;
			firstElement++;
			secondElement--;
		}
		return array;
	}


}
