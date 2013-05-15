package com.sirma.itt.javacourse.collections;

/**
 * Gets statistics from {@link Dice} . Shows how many times a combination has been thrown, and on
 * which turns.
 * 
 * @author Ventsislav Marinov
 */
public class TestDice {
	public static void main(String args[]) {
		Dice.initRoll(100);
		Dice.getCombination(2, 3);
		Dice.getCombination(4, 5);
		Dice.getCombination(5, 4);
		Dice.getCombination(6, 4);

	}

}
