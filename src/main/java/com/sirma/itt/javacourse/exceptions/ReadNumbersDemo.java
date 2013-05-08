package com.sirma.itt.javacourse.exceptions;

import com.sirma.itt.javacourse.exceptions.ReadNumbers.MyException;

/**
 * Run class for {@link ReadNumbers}
 *
 * @author Ventsislav Marinov
 */
public class ReadNumbersDemo {
	public static void main(String args[]) throws MyException {
		ReadNumbers readNumbers = new ReadNumbers();
		int result;
		result = readNumbers.inputNumber();
		System.out.println("You've inputed the number: " + result);
	}
}
