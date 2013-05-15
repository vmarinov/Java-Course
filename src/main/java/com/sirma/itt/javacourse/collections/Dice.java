package com.sirma.itt.javacourse.collections;

/*
 * TODO cases of dice combinations, list for every combination
 */
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rolls two dice for N number of turns, stores the dice combination and the roll count. Puts up a
 * statistic of the rolls.
 * 
 * @author Ventsislav Marinov
 */
public class Dice {
	// holds the first die roll
	private static int dieOne = 0;
	// holds the second die roll
	private static int dieTwo = 0;
	/*
	 * Holds the count of the roll.
	 */
	private static int rollCount = 1;
	/*
	 * Statistic of dice rolls are kept in a HashMap.
	 */
	private static Map<String, List<Integer>> stats;

	/*
	 * roll11 - roll56 Holds the values of roll counts a specific dice combination has been thrown.
	 */
	private static List<Integer> roll11;
	private static List<Integer> roll22;
	private static List<Integer> roll33;
	private static List<Integer> roll44;
	private static List<Integer> roll55;
	private static List<Integer> roll66;
	private static List<Integer> roll12;
	private static List<Integer> roll13;
	private static List<Integer> roll14;
	private static List<Integer> roll15;
	private static List<Integer> roll16;
	private static List<Integer> roll23;
	private static List<Integer> roll24;
	private static List<Integer> roll25;
	private static List<Integer> roll26;
	private static List<Integer> roll34;
	private static List<Integer> roll35;
	private static List<Integer> roll36;
	private static List<Integer> roll45;
	private static List<Integer> roll46;
	private static List<Integer> roll56;

	/**
	 * Determines the dice combination, and saves the roll.
	 * 
	 * @param dieOne
	 *            number rolled on first die
	 * @param dieTwo
	 *            number rolled on second die
	 */
	private static void checkCombination(int dieOne, int dieTwo) {
		/*
		 * If both dice rolled equal
		 */
		if (dieOne == dieTwo) {
			if (dieOne == 1) {
				roll11.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll11);
			}
			if (dieOne == 2) {
				roll22.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll22);
			}
			if (dieOne == 3) {
				roll33.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll33);
			}
			if (dieOne == 4) {
				roll44.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll44);
			}
			if (dieOne == 5) {
				roll55.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll55);
			}
			if (dieOne == 6) {
				roll66.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll66);
			}
			/*
			 * When the dice rolled different. Treats 1,2 the same as 2,1 etc.
			 */
		} else {
			if ((dieOne == 1 && dieTwo == 2) || (dieOne == 2 && dieTwo == 1)) {
				roll12.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll12);
			}
			if ((dieOne == 1 && dieTwo == 3) || (dieOne == 3 && dieTwo == 1)) {
				roll13.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll13);
			}
			if ((dieOne == 1 && dieTwo == 4) || (dieOne == 4 && dieTwo == 1)) {
				roll14.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll14);
			}
			if ((dieOne == 1 && dieTwo == 5) || (dieOne == 5 && dieTwo == 1)) {
				roll15.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll15);
			}
			if ((dieOne == 1 && dieTwo == 6) || (dieOne == 6 && dieTwo == 1)) {
				roll16.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll16);
			}
			if ((dieOne == 2 && dieTwo == 3) || (dieOne == 3 && dieTwo == 2)) {
				roll23.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll23);
			}
			if ((dieOne == 2 && dieTwo == 4) || (dieOne == 4 && dieTwo == 2)) {
				roll24.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll24);
			}
			if ((dieOne == 2 && dieTwo == 5) || (dieOne == 5 && dieTwo == 2)) {
				roll25.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll25);
			}
			if ((dieOne == 2 && dieTwo == 6) || (dieOne == 6 && dieTwo == 2)) {
				roll26.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll26);
			}
			if ((dieOne == 3 && dieTwo == 4) || (dieOne == 4 && dieTwo == 3)) {
				roll34.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll34);
			}
			if ((dieOne == 3 && dieTwo == 5) || (dieOne == 5 && dieTwo == 3)) {
				roll35.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll35);
			}
			if ((dieOne == 3 && dieTwo == 6) || (dieOne == 6 && dieTwo == 3)) {
				roll36.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll36);
			}
			if ((dieOne == 4 && dieTwo == 5) || (dieOne == 5 && dieTwo == 4)) {
				roll45.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll45);
			}
			if ((dieOne == 4 && dieTwo == 6) || (dieOne == 6 && dieTwo == 4)) {
				roll46.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll46);
			}
			if ((dieOne == 5 && dieTwo == 6) || (dieOne == 6 && dieTwo == 5)) {
				roll56.add(rollCount);
				stats.put(dieOne + "," + dieTwo, roll56);
			}
		}

	}

	/**
	 * Rolls one die.
	 * 
	 * @return the number rolled
	 */
	private static int rollDie() {
		int roll = (int) Math.round(Math.random() * 5.0) + 1;
		return roll;
	}

	/**
	 * Stores the dice combination and the roll count into a HashMap.
	 */
	private static void storeRoll() {
		dieOne = rollDie();
		dieTwo = rollDie();
		checkCombination(dieOne, dieTwo);
		rollCount++;
	}

	/**
	 * Throws the dices N times, and stores the rolls.
	 * 
	 * @param numberOfThrows
	 *            how many times the dice to be thrown
	 * @exception InvalidParameterException
	 *                thrown if number of throws is set to 0 or a negative value
	 */
	public static void initRoll(int numberOfThrows) {
		if (numberOfThrows <= 0) {
			throw new InvalidParameterException("Number of rolls must be higher then zero!");
		}
		stats = new HashMap<String, List<Integer>>();
		roll11 = new ArrayList<Integer>();
		roll22 = new ArrayList<Integer>();
		roll33 = new ArrayList<Integer>();
		roll44 = new ArrayList<Integer>();
		roll55 = new ArrayList<Integer>();
		roll66 = new ArrayList<Integer>();
		roll12 = new ArrayList<Integer>();
		roll13 = new ArrayList<Integer>();
		roll14 = new ArrayList<Integer>();
		roll15 = new ArrayList<Integer>();
		roll16 = new ArrayList<Integer>();
		roll23 = new ArrayList<Integer>();
		roll24 = new ArrayList<Integer>();
		roll25 = new ArrayList<Integer>();
		roll26 = new ArrayList<Integer>();
		roll34 = new ArrayList<Integer>();
		roll35 = new ArrayList<Integer>();
		roll36 = new ArrayList<Integer>();
		roll45 = new ArrayList<Integer>();
		roll46 = new ArrayList<Integer>();
		roll56 = new ArrayList<Integer>();
		while (rollCount <= numberOfThrows) {
			storeRoll();
		}
	}

	/**
	 * Prints how many times a set combination has been thrown, and at which position.
	 * 
	 * @param dieOne
	 *            first die roll
	 * @param dieTwo
	 *            second die roll
	 * @exception InvalidParameterException
	 *                thrown when one of the die roll is set to less than 0 or higher than 6
	 */

	public static void getCombination(int dieOne, int dieTwo) {
		if ((dieOne > 6 || dieOne <= 0) || (dieTwo > 6 || dieTwo <= 0)) {
			throw new InvalidParameterException("Dice can't roll less than 0 or greater than 6");
		}
		/*
		 * Checks if there is such key in the HashMap, if it is present shows values, else returns
		 * message that this combination was not thrown. Treats combinations 1,2 the same as 2,1
		 * etc.
		 */
		if (stats.containsKey(dieOne + "," + dieTwo)) {
			System.out.println("Combination(" + dieOne + "," + dieTwo + ")"
					+ " thrown at positions" + stats.get(dieOne + "," + dieTwo));
			System.out.println("Number of rolls: "
 + stats.get(dieOne + "," + dieTwo).size());
		} else if (stats.containsKey(dieTwo + "," + dieOne)) {
			System.out.println("Combination(" + dieOne + "," + dieTwo + ")"
					+ " thrown at positions" + stats.get(dieTwo + "," + dieOne));
			System.out.println("Number of rolls: "
 + stats.get(dieTwo + "," + dieOne).size());
		} else {
			System.out.println("Combination(" + dieOne + "," + dieTwo + ")" + " was not thrown.");
		}

	}
}
