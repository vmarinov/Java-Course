package com.sirma.itt.javacourse.introd;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Class representing a game of hangman.
 *
 * @author Ventsislav Marinov
 */
public class Hangman {
	// number of guesses allowed
	private final int GUESSES_LIMIT = 5;
	// the secret word
	private String wordToGuess = null;
	// guessed so far
	private String currentWord = "";
	// holds the letters guessed so far
	private Set<String> guessedLetters;
	// number of guesses left
	private int guessesLeft;
	private StringBuilder sBuilder1;
	private StringBuilder sBuilder2;
	// a list of words used for generating the secret word
	private final String[] secretWords = { "football", "school", "movie", "plane", "crocodile" };


	/**
	 * Starts the game.
	 */
	public void startGame() {
		initiateGame();
		System.out.println("The lenght of the word is: " + wordToGuess.length() + " letters");
		while (playOn()) {
			playTurn();
		}
		newGame();
	}

	/**
	 * Sets the fields for a new game.
	 *
	 * @param wordToGuess
	 *            the word to guess
	 */
	public void initiateGame() {
		generateSecretWord();
		guessedLetters = new HashSet<String>();
		sBuilder1 = new StringBuilder();
		sBuilder1.append(getWordToGuess());
		sBuilder2 = new StringBuilder();
		setCurrentWord(hideWord(sBuilder1, sBuilder2));
		guessesLeft = GUESSES_LIMIT;
	}

	/**
	 * Transforms every letter of the secret word into '_'
	 *
	 * @param o
	 *            StringBuilder object
	 * @param o2
	 *            Second StringBuilder object
	 * @return transformed word
	 */
	public String hideWord(StringBuilder o, StringBuilder o2) {
		o2.setLength(o.length());
		for (int i = 0; i < o2.length(); i++) {
			o2.setCharAt(i, '_');
		}
		return o2.toString();
	}

	/**
	 * Checks does the secret word contain the input letter.
	 *
	 * @param o
	 *            StringBuilder object
	 * @param o2
	 *            Second StringBuilder object
	 * @param letter
	 *            input letter
	 * @param i
	 */
	public void checkLetter(StringBuilder o, StringBuilder o2, String letter) {
		boolean found = false;
		if (!guessedLetters.contains(letter)) {
			// compares the input letter with every letter in the secret word
			for (int i = 0; i < (wordToGuess.length()); i++) {
				// if there is such a letter it replaces the '_' letters in the current word
				if (String.valueOf(wordToGuess.charAt(i)).equals(letter)) {
					setCurrentWord(o2.replace(i, i + 1, String.valueOf(o.charAt(i))).toString());
					found = true;
				}
			}
			// if the letter is found it prints in the console a positive result
			if (found) {
				System.out.println("There is a letter \"" + letter + "\" in the word.");

				/**
				 * if the letter is not found it prints in the console a negative result and
				 * decrements the number of guesses left
				 */
			} else {
				System.out.println("The word doesn't contain the letter \"" + letter);
				setGuessesLeft(guessesLeft - 1);
			}
			// prints in the console if the letter has already been guessed
		} else {
			System.out.println("You have guessed the letter: \"" + letter + "\"already.");
		}
		guessedLetters.add(letter);
	}

	/**
	 * Prints the letters guessed so far.
	 *
	 * @return string of the letters.
	 */
	public String showGuessedLetters() {
		String contains = "";
		Iterator<String> it = guessedLetters.iterator();
		while (it.hasNext()) {
			contains = contains.concat(" " + it.next());
		}
		return contains;
	}

	/**
	 * Used for inputting letters.
	 *
	 * @return the input letter
	 */
	public String inputLetter() {
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		Character ch = 0;
		try {
			System.out.println("Please input a letter: ");
			line = br.readLine();
			while ((line.length() != 1) || !Character.isLetter(line.charAt(0))) {
				System.out.println("Your input is incorrect.");
				System.out.println("You have to input one letter.");
				line = br.readLine();
			}

		} catch (Exception e) {
		}
		return line.toLowerCase();
	}

	/**
	 * Starts a new turn in the game.
	 */
	public void playTurn() {
		String letter = null;
		System.out.println("Guessed letters so far are: " + showGuessedLetters());
		System.out.println("Guesses left: " + getGuessesLeft());
		System.out.println("Your current word is: " + getCurrentWord());
		letter = inputLetter();
		checkLetter(getsBuilder1(), getSBuilder2(), letter);

	}

	/**
	 * Checks if there are more turns to be played.
	 *
	 * @return
	 */
	public boolean playOn() {
		if (guessesLeft == 0) {
			System.out.println("You have no more guesses left.");
			System.out.println("You lose!");
			System.out.println("The secret word was: " + getWordToGuess());
			return false;
		} else if (currentWord.equals(wordToGuess)) {
			System.out.println("You have guessed the word.");
			System.out.println("You win!");
			System.out.println("The word is: " + wordToGuess);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Randomly picks a word from the secretWord array;
	 */
	public void generateSecretWord() {
		int i = (int) Math.round(((Math.random() * (secretWords.length - 1))));
		setWordToGuess(secretWords[i].toLowerCase());
	}

	/**
	 * Asks the user for a new game. If he inputs Y/y it starts a new game.
	 */
	public void newGame() {
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		Character ch = 0;
		try {
			System.out.println("Would you like to start a new game? Y/N");
			line = br.readLine();
			while ((line.length() != 1) || !Character.isLetter(line.charAt(0))) {
				System.out.println("Your input is incorrect.");
				System.out.println("Would you like to start a new game? Y/N");
				line = br.readLine();
				line.toLowerCase();
			}
			if (line.equals("y")) {
				startGame();
			}

		} catch (Exception e) {

		}

	}

	public String getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(String currentWord) {
		this.currentWord = currentWord;
	}

	public int getGuessesLeft() {
		return guessesLeft;
	}

	public void setGuessesLeft(int guessesLeft) {
		this.guessesLeft = guessesLeft;
	}

	public StringBuilder getsBuilder1() {
		return sBuilder1;
	}

	public void setsBuilder1(StringBuilder sBuilder1) {
		this.sBuilder1 = sBuilder1;
	}

	public StringBuilder getSBuilder2() {
		return sBuilder2;
	}

	public void setSBuilder2(StringBuilder sbuilder2) {
		this.sBuilder2 = sbuilder2;
	}

	public String getWordToGuess() {
		return wordToGuess;
	}

	public void setWordToGuess(String wordToGuess) {
		this.wordToGuess = wordToGuess;
	}

}
