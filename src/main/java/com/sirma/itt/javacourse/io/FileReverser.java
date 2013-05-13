package com.sirma.itt.javacourse.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Writes the contents of a file to a new one in reverse order.
 *
 * @author Ventsislav Marinov
 */
public class FileReverser {
	/*
	 * The path of the file that is reversed.
	 */
	private static final Path filePath = Paths
			.get("C:\\workspace jcourse\\Input-Output\\reverse-me.txt");

	/*
	 * The file which will hold the contents in reverse order.
	 */
	private static File reversed;
	private static BufferedReader reader;
	private static BufferedWriter filewriter;
	private static InputStream in;
	private static ArrayList<String> buffer;

	/**
	 * Reads every line of the file and saves it in a list. After that the contents of the list are
	 * iterated backwards and written to the "reversed" file.
	 *
	 * @throws IOException
	 */
	public static void reverse() throws IOException {
		/*
		 * Stores every line of the file to be reversed.
		 */
		buffer = new ArrayList<String>();
		/*
		 * Creating a new text file called "reversed"
		 */
		reversed = new File("C:\\workspace jcourse\\Input-Output\\reversed.txt");
		in = Files.newInputStream(filePath);
		reader = new BufferedReader(new InputStreamReader(in));
		filewriter = new BufferedWriter(new FileWriter(reversed));
		String line = null;
		while ((line = reader.readLine()) != null) {
			buffer.add(line);
		}
		reader.close();
		ListIterator<String> it = buffer.listIterator(buffer.size());
		while (it.hasPrevious()) {
			filewriter.write(it.previous());
			filewriter.newLine();
		}
		filewriter.close();
	}

	public static void main(String args[]) {
		try {
			FileReverser.reverse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
