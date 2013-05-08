package com.sirma.itt.javacourse.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Shows information about a class.
 *
 * @author Ventsislav Marinov
 */
public class ClassInfo {
	/**
	 * Simple field of primitive type integer with private access.
	 */
	private final int myInt = 0;
	/**
	 * Simple field of String with public access.
	 */
	public String hello = "Hello";
	/**
	 * An integer array with private access.
	 */
	private int[] array;


	/**
	 * A method with private access, returning string .
	 *
	 * @param s
	 * @return
	 */
	private String methodTwo() {
		return hello;
	}

	/**
	 * A method with protected access, returning integer.
	 *
	 * @param i
	 * @return
	 */
	protected int methodThree() {
		return myInt;
	}

	public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		final Object[] EMPTY = {};
		ClassInfo cinfo = new ClassInfo();
		Class c = cinfo.getClass();
		System.out.println("Superclass: " + c.getSuperclass());
		System.out.println("Declaring class: " + c.getDeclaringClass() + "\n");

		/**
		 * Prints all fields of the class.
		 */
		Field[] f = c.getFields();
		for (Field cf : f) {
			System.out.println("Field name: " + cf.getName());
			System.out.println("Field type: " + cf.getType());
			System.out.println("Declaring class: " + cf.getDeclaringClass());
			System.out.println(cf);
			System.out.println("Value: " + cf.get(cinfo) + "\n");

		}
		/**
		 * Prints all methods of the class.
		 */
		Method[] arrayOfMethods = c.getDeclaredMethods();
		for (Method m : arrayOfMethods) {
			System.out.println("Method name: " + m.getName());
			System.out.println("Return type: " + m.getReturnType());
			System.out.println(m);
			System.out.println();
		}

	}

}
