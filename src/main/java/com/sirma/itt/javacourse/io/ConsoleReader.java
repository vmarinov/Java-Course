package com.sirma.itt.javacourse.io;

import java.util.Scanner;

/**
 * Reads input from the console.
 *
 * @author Ventsislav Marinov
 */
public class ConsoleReader {
	private static Scanner sc;

	/**
	 * Reads strings from the console and returns the inputed value.
	 *
	 * @return inputed string
	 */
	public static String readString() {
		String str = "";
		sc = new Scanner(System.in);
		str = sc.next();
		return str;
	}

	/**
	 * Reads integer from the console and returns the inputed value.
	 *
	 * @return inputed integer
	 */
	public static int readInt() {
		int i = 0;
		sc = new Scanner(System.in);
		i = sc.nextInt();
		return i;
	}

	public static char readChar() {
		char c = 0;
		return c;
	}

	/**
	 * Reads floating point number from the console and returns inputed value.
	 *
	 * @return inputed float number
	 */
	public static float readFloat() {
		float f;
		sc = new Scanner(System.in);
		f = sc.nextFloat();
		return f;
	}

	public static void main(String args[]) {
		System.out.println("Input a String: ");
		String s = ConsoleReader.readString();
		System.out.println("Your string is: " + s);
		System.out.println("Input an integer: ");
		int i = ConsoleReader.readInt();
		System.out.println("Your int is: " + i);
		System.out.println("Input a char: ");
		char c = ConsoleReader.readChar();
		System.out.println("Your char is: " + c);
		System.out.println("Input a floating point number: ");
		float f = ConsoleReader.readFloat();
		System.out.println("Your float is: " + f);
	}

}
