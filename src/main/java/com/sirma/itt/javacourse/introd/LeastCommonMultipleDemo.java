package com.sirma.itt.javacourse.introd;

/**
 * Run class for {@link LeastCommonMultiple} .
 * 
 * @author Ventsislav Marinov
 */
public class LeastCommonMultipleDemo {
	public static void main(String args[]) {
		LeastCommonMultiple leastCommonMultiple = new LeastCommonMultiple();
		int multiple;
		multiple = leastCommonMultiple.findLcm(27, 42);
		System.out.println(multiple);
	}
}
