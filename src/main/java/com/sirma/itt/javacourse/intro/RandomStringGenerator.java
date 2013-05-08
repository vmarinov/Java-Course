package com.sirma.itt.javacourse.intro;

/**
 * Class used for generating random string with set length.
 *
 * @author Ventsislav Marinov
 */
public class RandomStringGenerator {

	/**
	 * Generates a random string with set length.
	 *
	 * @param stringLength
	 *            the length of the string
	 * @return returns the generated string
	 */
	public String generateString(int stringLength) {
		String generatedString = "";
		char generatedletter = 0;
		int generatedNumber = 0;
		int charType;
		for (int i = 1; i <= stringLength; i++) {
			charType = (int) Math.round(Math.random());

			// if charType = 1 generates a letter
			if (charType == 1) {
				generatedletter = generateLetter();
				generatedString = generatedString.concat(String.valueOf(generatedletter));

				// else generates a number
			} else {
				generatedNumber = generateNumber();
				generatedString = generatedString.concat(String.valueOf(generatedNumber));
			}

		}

		return generatedString;
	}

	/**
	 * Generates a random letter.
	 *
	 * @return random letter
	 */
	private char generateLetter() {
		int rnd = (int) (Math.random() * 52);
		char base = (rnd < 26) ? 'A' : 'a';
		return (char) (base + (rnd % 26));
	}

	/**
	 * Generates a random number.
	 *
	 * @return random number
	 */
	private int generateNumber() {
		int rndNum = (int) Math.round(Math.random() * 9);
		return rndNum;
	}

}
