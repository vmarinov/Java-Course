package com.sirma.itt.javacourse.intro;

/**
 * Run class for {@link Quicksort}
 *
 * @author Ventsislav Marinov
 */
public class QuicksortDemo {
	public static void main(String args[]) {
		Quicksort quicksort = new Quicksort();
		Integer[] unsortedArray = { 15, 23, 12, 34, 11 };
		System.out.println("Array before: ");
		for (Integer x : unsortedArray) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("Array after: ");
		quicksort.quicksort(unsortedArray);
		for (Integer x: unsortedArray){
			System.out.print(x + " ");

		}
	}
}
