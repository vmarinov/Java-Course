package com.sirma.itt.javacourse.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Instantiate {@link Hidden} and prints all methods and fields
 * 
 * @author Ventsislav Marinov
 */
public class Review {
	private static final Object[] EMPTY = {};

	public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Hidden hidden = new Hidden();
		Class hiddenClass = hidden.getClass();

		Method[] methods = hiddenClass.getDeclaredMethods();
		/**
		 * Prints all methods, their names and return type
		 */
		for (Method meths : methods) {
			System.out.println("Method name: " + meths.getName());
			System.out.println("Return type: " + meths.getReturnType());
			meths.setAccessible(true);
			System.out.println("Return value: " + meths.invoke(hidden, EMPTY) + "\n");

		}

		/**
		 * Prints all fields, their names,type and value
		 */
		Field[] fields = hiddenClass.getDeclaredFields();
		for (Field f : fields) {
			System.out.println("Field name: " + f.getName());
			System.out.println("Field type: " + f.getType());
			f.setAccessible(true);
			System.out.println("Value: " + f.get(hidden) + "\n");
		}
	}
}
