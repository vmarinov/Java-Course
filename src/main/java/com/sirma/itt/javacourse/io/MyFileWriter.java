package com.sirma.itt.javacourse.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Writes input from the console into a text file.
 *
 * @author Ventsislav Marinov
 */
public class MyFileWriter {
	private static File file;
	private static BufferedWriter filewriter;

	/**
	 * Creates a new file.
	 */
	private static void createFile() {
		file = new File("test.txt");
	}

	/**
	 * Writes to file.
	 *
	 * @throws IOException
	 */
	private static void writeToFile() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		filewriter = new BufferedWriter(new FileWriter(file));

		try {
			String line = "";
			do {
				line = reader.readLine();
				filewriter.write(line);
				filewriter.newLine();
			} while (!line.equals("."));
			reader.close();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the program.
	 */
	public static void init() {
		createFile();
		try {
			writeToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		MyFileWriter.init();
	}
}
