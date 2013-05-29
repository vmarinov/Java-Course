package com.sirma.itt.javacourse.io.dataclasstest;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.sirma.itt.javacourse.io.DataClass;
import com.sirma.itt.javacourse.io.UserDefinedObject;

@RunWith(JUnit4.class)
public class DataClassTest {

	@Test
	public void saveObject() {

	}

	@Test
	public void getObject() throws IOException {
		String filePath = "src\\test\\java\\com\\sirma\\itt\\javacourse\\io\\resources\\userdefinedobj.ser";
		DataClass dataClass = new DataClass();
		UserDefinedObject expected = new UserDefinedObject("John", 24, "NYC");
		dataClass.saveObject(filePath, expected);
		UserDefinedObject actual = null;
		UserDefinedObject temp = dataClass.getObject(filePath);
		actual = temp;
		Assert.assertSame(expected, actual);
	}

}
