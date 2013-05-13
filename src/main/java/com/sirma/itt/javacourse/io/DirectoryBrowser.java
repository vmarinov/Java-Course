package com.sirma.itt.javacourse.io;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Browses directories.
 *
 * @author Ventsislav Marinov
 */
public class DirectoryBrowser {
	private static Path resolvePath;

	/**
	 * Prints the contents of a directory or returns a message in the case of file path.
	 *
	 * @param path
	 *            inputed path to a directory or file
	 */
	public static void listContent(String path) {
		resolvePath = Paths.get(path);
		if (Files.exists(resolvePath)) {
			if (Files.isRegularFile(resolvePath)) {
				System.out.println("This is a file.");
			} else {
				/*
				 * If it is a directory prints its contents.
				 */
				try (DirectoryStream<Path> stream = Files.newDirectoryStream(resolvePath)) {
					System.out.print(path + " contains: ");
					for (Path file : stream) {
						System.out.print(" " + file.getFileName() + ",");
					}
					System.out.println();
				} catch (IOException | DirectoryIteratorException x) {

					System.err.println(x);
				}
			}
		} else {
			System.out.println("There is no such file/directory");
		}
	}

	public static void main(String args[]) {
		DirectoryBrowser.listContent("C:\\workspace jcourse\\Input-Output\\monkey.jpg");
		System.out.println();
		DirectoryBrowser.listContent("C:\\workspace jcourse\\Input-Output\\");
	}
}
