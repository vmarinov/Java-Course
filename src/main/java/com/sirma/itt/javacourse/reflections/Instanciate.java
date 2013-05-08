package com.sirma.itt.javacourse.reflections;

/**
 * Instanciates a class by it's name and shows the superclass and implemented interfaces.
 *
 * @author Ventsislav Marinov
 */
public class Instanciate extends Number implements Comparable<Number> {

	public static void main(String args[]) {
		Instanciate instanciate = new Instanciate();
		Class c = instanciate.getClass().getSuperclass();
		System.out.println("Superclass: " + c);
		Class[] c2;
		c2 = instanciate.getClass().getInterfaces();
		for (Class elem : c2) {
			System.out.println("Class implements: ");
			System.out.println(elem);
			System.out.println();
		}


	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Number o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
