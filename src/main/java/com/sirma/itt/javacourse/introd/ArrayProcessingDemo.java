package com.sirma.itt.javacourse.introd;

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
		ArrayProcessing arrP = new ArrayProcessing();
		sum = arrP.getSum(array);
		System.out.println(sum);
		minElement = arrP.getMinElement(array);
		System.out.println(minElement);
		arrP.printArray(array);
	}
}
