package com.sirma.itt.javacourse.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataClass {
	private static UserDefinedObject userObject;
	private static Path filePath;

	/**
	 * Serializes an object, on set path.
	 *
	 * @param path
	 *            path of the file
	 * @param o
	 *            object serialized
	 */
	public void saveObject(String path, UserDefinedObject o) {
		filePath = Paths.get(path);
		this.userObject = o;
		if (Files.notExists(filePath)) {
			new File(path);
		}
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	/**
	 * Gets serialized object.
	 *
	 * @param path
	 *            the file path
	 * @return deserialized object
	 * @throws IOException
	 */
	public UserDefinedObject getObject(String path) throws IOException {
		UserDefinedObject o = null;
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			o = (UserDefinedObject) in.readObject();
			in.close();
			fileIn.close();

		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
		// Shows that the file is deserialized
		o.print();
		return o;
	}

	public static void main(String args[]) {
		String fileName = "C:\\workspace jcourse\\Input-Output\\userdefinedobj2.ser";
		DataClass dClass = new DataClass();
		UserDefinedObject udo = new UserDefinedObject("Charlie", 21, "Chicago");
		dClass.saveObject(fileName, udo);
		try {
			dClass.getObject(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
