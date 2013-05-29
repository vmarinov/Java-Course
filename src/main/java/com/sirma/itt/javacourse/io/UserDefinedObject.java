package com.sirma.itt.javacourse.io;

import java.io.Serializable;

public class UserDefinedObject implements Serializable {
	private static final long serialVersionUID = 42L;
	private String name;
	private int age;
	private String city;


	public UserDefinedObject(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserDefinedObject [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

}
