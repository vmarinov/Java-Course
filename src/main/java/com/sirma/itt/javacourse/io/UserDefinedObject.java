package com.sirma.itt.javacourse.io;

import java.io.Serializable;

public class UserDefinedObject implements Serializable {
	private final String name;
	private final int age;
	private final String city;

	public void print() {
		System.out.println("Name: " + name + " Age: " + age + " City: " + city);
	}

	public UserDefinedObject(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

}
