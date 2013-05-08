package com.sirma.itt.javacourse.intro;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringBuilderSample {
	String wordToGuess = null;
	boolean flag = false;
	String word = null;

	public String getWordToGuess() {
		return wordToGuess;
	}

	public void setWordToGuess(String wordToGuess) {
		this.wordToGuess = wordToGuess;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}



	public void checkLetter(StringBuilder o, StringBuilder o2, String letter, int i) {
		while (i < (wordToGuess.length())) {
			if (String.valueOf(wordToGuess.charAt(i)).equals(letter)) {
				setWord(o2.replace(i, i + 1, String.valueOf(o.charAt(i))).toString());
				System.out.println("There is a letter \"" + letter + "\" in the word.");
			}
			i++;
		}
	}

	public boolean wordGuessed(String word, String wordToGuess) {
		return word.equals(wordToGuess);
	}

	public static void main(String args[]) {
		StringBuilder sBuilder = new StringBuilder();
		StringBuilderSample sbs = new StringBuilderSample();
		sBuilder.append("Bikini");

		String letter = "B";
		int i = 0;

		sbs.setWordToGuess(sBuilder.toString());
		StringBuilder sBuilder2 = new StringBuilder();
		sBuilder2.setLength(sBuilder.length());
		for (int j = 0; j < sBuilder2.length(); j++) {
			sBuilder2.setCharAt(j, '_');
		}
		sbs.setWord(sBuilder2.toString());

		letter = "i";
		sbs.checkLetter(sBuilder, sBuilder2, letter, 0);
		letter = "s";
		sbs.checkLetter(sBuilder, sBuilder2, letter, 0);
		System.out.println(sbs.getWordToGuess());
		System.out.println(sbs.getWord());
		Set<String> guessedLetters = new HashSet<String>();
		guessedLetters.add("a");
		guessedLetters.add("a");
		guessedLetters.add("b");
		guessedLetters.add("b");
		guessedLetters.add("c");
		if (guessedLetters.contains("a")) {
			System.out.println("aha");
		}
		Iterator<String> it = guessedLetters.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}

	}
}
