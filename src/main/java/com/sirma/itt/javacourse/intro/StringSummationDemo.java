package com.sirma.itt.javacourse.intro;

/**
 * Run class for {@link StringSummation}
 * 
 * @author Ventsislav Marinov
 */
public class StringSummationDemo {
	public static void main(String args[]) {
		StringSummation stringSummation = new StringSummation("911", "11111");
		System.out.println("The sum of " + stringSummation.getFirstNum() + " and "
				+ stringSummation.getSecondNum()
				+ " is: "
 + stringSummation.getSum());
		stringSummation = new StringSummation("378", "17659");
		System.out.println("The sum of " + stringSummation.getFirstNum() + " and "
				+ stringSummation.getSecondNum() + " is: " + stringSummation.getSum());
		stringSummation = new StringSummation("572", "199569");
		System.out.println("The sum of " + stringSummation.getFirstNum() + " and "
				+ stringSummation.getSecondNum() + " is: " + stringSummation.getSum());
		stringSummation = new StringSummation("199357", "999");
		System.out.println("The sum of " + stringSummation.getFirstNum() + " and "
				+ stringSummation.getSecondNum() + " is: " + stringSummation.getSum());
		stringSummation = new StringSummation("333", "999");
		System.out.println("The sum of " + stringSummation.getFirstNum() + " and "
				+ stringSummation.getSecondNum() + " is: " + stringSummation.getSum());

		stringSummation = new StringSummation("33", "999");
		System.out.println("The sum of " + stringSummation.getFirstNum() + " and "
				+ stringSummation.getSecondNum() + " is: " + stringSummation.getSum());
		stringSummation = new StringSummation("9", "9");
		System.out.println("The sum of " + stringSummation.getFirstNum() + " and "
				+ stringSummation.getSecondNum() + " is: " + stringSummation.getSum());
		stringSummation = new StringSummation("99999", "9999");
		System.out.println("The sum of " + stringSummation.getFirstNum() + " and "
				+ stringSummation.getSecondNum()
				+ " is: "
 + stringSummation.getSum());
		stringSummation = new StringSummation("2", "998");
		System.out.println("The sum of " + stringSummation.getFirstNum() + " and "
				+ stringSummation.getSecondNum() + " is: " + stringSummation.getSum());


	}
}
