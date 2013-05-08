package com.sirma.itt.javacourse.intro;

/**
 * Run class for {@link LeastCommonMultiple} .
 *
 * @author Ventsislav Marinov
 */
public class LeastCommonMultipleDemo {
	public static void main(String args[]) {

		int multiple;
		multiple = LeastCommonMultiple.findLcm(27, 42);
		System.out.println(multiple);
	}
}
