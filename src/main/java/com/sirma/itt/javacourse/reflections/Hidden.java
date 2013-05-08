package com.sirma.itt.javacourse.reflections;

/**
 * Class with private fields and methods
 *
 * @author Ventsislav Marinov
 */
public class Hidden {
	private final int number = 5;
	private final String word = "hello";

	private int squareNumber() {
		return number * number;
	}
	private String sayHello() {
		return word;
	}


}
