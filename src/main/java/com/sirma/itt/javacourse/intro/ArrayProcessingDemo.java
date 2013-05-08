package com.sirma.itt.javacourse.intro;

/**
 * Run class for {@link ArrayProcessing}
 *
 * @author Ventsislav Marinov
 */
public class ArrayProcessingDemo {
	public static void main(String args[]) {
		int[] array = { 4, 5, 6, 2, 0 };
		int sum;
		int minElement;
		sum = ArrayProcessing.getSum(array);
		System.out.println(sum);
		minElement = ArrayProcessing.getMinElement(array);
		System.out.println(minElement);
		ArrayProcessing.printArray(array);
	}
}
