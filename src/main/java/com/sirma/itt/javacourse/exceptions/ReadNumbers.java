package com.sirma.itt.javacourse.exceptions;
import java.util.Scanner;

/**
 * Reads input numbers and throws exception of the number isn't in the range of 0-100
 *
 * @author Ventsislav Marinov
 */
public class ReadNumbers {
	private int number;

	/**
	 * Used for inputting numbers.
	 *
	 * @throws MyException
	 *             - when the input number is out of range
	 */
	public int inputNumber() throws MyException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your number: ");
		number = sc.nextInt();
		if ((number < 0) || (number > 100)) {
			throw new MyException("Your number isn't in the range of 0-100");
		} else {
			return number;
		}
	}

	/**
	 * Throws a custom exception
	 *
	 * @author Ventsislav Marinov
	 */
	public class MyException extends Exception {
		public MyException(String message) {
			super(message);
		}

		public MyException(String message, Throwable cause) {
			super(message, cause);
		}
	}

}
