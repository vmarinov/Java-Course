package com.sirma.itt.javacourse.introd;

/**
 * Run class for {@link ReverseArray} .
 *
 * @author Ventsislav Marinov
 */
public class ReverseArrayDemo {

	public static void main(String args[]) {
		ReverseArray reverseArray = new ReverseArray();
		int[] array = { 1, 2, 3, 4, 5 };
		System.out.println("Array before:");
		for (int element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
		int[] reversedArray = reverseArray.reverse(array);
		System.out.println("Array after:");
		for (int element : reversedArray) {
			System.out.print(element + " ");
		}
		System.out.println();
		int[] array2 = { 2, 5, 8, 4 };
		System.out.println("Array before: ");
		for (int element : array2) {
			System.out.print(element + " ");
		}
		System.out.println();
		System.out.println("Array after:");
		reversedArray = reverseArray.reverse(array2);
		for (int element : reversedArray) {
			System.out.print(element + " ");
		}
	}
}
