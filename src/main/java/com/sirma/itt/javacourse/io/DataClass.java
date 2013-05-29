package com.sirma.itt.javacourse.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataClass {
	private Path filePath;

	public void saveObject(String path, UserDefinedObject o) {
		filePath = Paths.get(path);

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

	public UserDefinedObject getObject(String path) throws IOException, NoSuchFileException {
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
		return o;
	}

	public static void main(String args[]) {
		String fileName = "src\\test\\java\\com\\sirma\\itt\\javacourse\\io\\resources\\userdefinedobj2.ser";
		DataClass dClass = new DataClass();
		UserDefinedObject udo = new UserDefinedObject("Charlie", 21, "Chicago");
		dClass.saveObject(fileName, udo);
		try {
			System.out.println(dClass.getObject(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
