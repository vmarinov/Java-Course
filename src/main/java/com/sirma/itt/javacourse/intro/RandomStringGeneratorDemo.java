package com.sirma.itt.javacourse.intro;

/**
 * Run class for {@link RandomStringGenerator}
 *
 * @author Ventsislav Marinov
 */
public class RandomStringGeneratorDemo {
	public static void main(String args[]) {
		RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
		String randomString;
		randomString = randomStringGenerator.generateString(15);
		System.out.println(randomString);
		RandomStringGenerator randomStringGenerator2 = new RandomStringGenerator();
		randomString = randomStringGenerator2.generateString(5);
		System.out.println(randomString);
	}
}
