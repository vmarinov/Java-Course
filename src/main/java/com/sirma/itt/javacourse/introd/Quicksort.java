package com.sirma.itt.javacourse.introd;

/**
 * Class that implements quicksort.
 * 
 * @author Ventsislav Marinov
 */
public class Quicksort implements Comparable<Integer> {

	static void quicksort(Integer[] array) {
		quicksort(array, 0, array.length - 1);
	}

	static void quicksort(Integer[] array, Integer left0, Integer right0) {
		Integer left = left0;
		Integer right = right0 + 1;
		Integer pivot, temp;

		pivot = array[left0];

		do {

			do {
				left++;
			} while ((left <= right0) && (array[left].compareTo(pivot) < 0));

			do {
				right--;
			} while (array[right].compareTo(pivot) > 0);

			if (left < right) {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		} while (left <= right);

		temp = array[left0];
		array[left0] = array[right];
		array[right] = temp;

		if (left0 < right) {
			quicksort(array, left0, right);
		}
		if (left < right0) {
			quicksort(array, left, right0);
		}
	}

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
