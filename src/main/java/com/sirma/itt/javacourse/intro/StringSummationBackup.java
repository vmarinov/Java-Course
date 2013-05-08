package com.sirma.itt.javacourse.intro;

public class StringSummationBackup {
	private String firstNum;
	private String secondNum;
	private boolean carriage = false;
	private String subString = null;
	private String tempSubString = "";

	public String getSubString() {
		return subString;
	}

	public void setSubString(String subString) {
		this.subString = subString;
	}

	public String getTempSubString() {
		return tempSubString;
	}

	public void setTempSubString(String tempSubString) {
		this.tempSubString = tempSubString;
	}

	public boolean isCarriage() {
		return carriage;
	}

	public void setCarriage(boolean carriage) {
		this.carriage = carriage;
	}

	public String getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}

	public String getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(String secondNum) {
		this.secondNum = secondNum;
	}

	public StringSummationBackup(String first, String second) {
		this.firstNum = first;
		this.secondNum = second;
	}

	/**
	 * Used to get a new string of a substring of the longer number
	 *
	 * @param firstNum
	 *            first number
	 * @param secondNum
	 *            second number
	 * @return substring of the longer number
	 */
	public String subStr(String firstNum, String secondNum) {
		String subStr = null;
		// substrings the first number if it is longer than the second
		if (firstNum.length() > secondNum.length()) {
			subStr = firstNum.substring(0, firstNum.length() - secondNum.length());
			// substrings second number if it is longer than the first
		} else if (firstNum.length() < secondNum.length()) {
			subStr = secondNum.substring(0, secondNum.length() - firstNum.length());

		}

		return subStr;
	}

	/**
	 * @param i
	 *            i-th char of the strings
	 * @param firstNum
	 *            first number
	 * @param secondNum
	 *            second number
	 * @param carriage
	 * @return temporary string of the sum of the i-th digits
	 */
	public String tempSum(int i, String firstNum, String secondNum, boolean carriage) {
		int j = i;
		// the digit of the first number
		int first = 0;
		// the digit of the second number
		int second = 0;
		// holds the sum of the two digits
		String temp = "";
		first = Integer.parseInt(Character.toString(firstNum.charAt(j)));
		second = Integer.parseInt(Character.toString(secondNum.charAt(j)));

		// if there is a carriage
		if (carriage) {

			temp = String.valueOf((first + second) + 1);

			if (Integer.parseInt(temp) >= 10) {
				temp = String.valueOf(Integer.parseInt(temp) - 10);

			} else {
				temp = String.valueOf(first + second);
				setCarriage(false);
			}
			// when there is no carriage
		} else {

			if ((first + second) >= 10) {
				temp = String.valueOf((first + second) - 10);

				setCarriage(true);

			} else {
				temp = String.valueOf(first + second);
			}

		}

		return temp;
	}

	/**
	 * Used to add the substring to the total sum of the equal length numbers.
	 *
	 * @param subStr
	 *            the substring of the longer number
	 * @param carries
	 * @param sum
	 *            the total sum of the equal length numbers
	 * @return the final sum of the two numbers
	 */
	public String addSubstr(String subStr, boolean carries, String sum) {
		String temp = "";
		if ((getSubString() != null) && !carriage) {
			temp = getSubString();
			sum = temp.concat(sum);
		}
		while ((getSubString() != null) && carriage) {
			if ((getSubString().length() == 1) && carriage) {
				temp = String.valueOf((Integer.parseInt(Character
						.toString(getSubString().charAt(0)))) + 1);
				if (Integer.parseInt(temp) == 10) {
					temp = "0";
					sum = temp.concat(sum);
					subStr = null;
					setCarriage(true);
				} else {
					sum = temp.concat(sum);
					temp = "";
					subStr = null;
					setCarriage(false);
				}

			} else if (getSubString().length() > 1) {
				setTempSubString(subStr(subStr, "1"));
				setSubString(trimNum(subStr, "1"));

				if (!getSubString().equals("9")) {
					temp = tempSum(0, getSubString(), "1", carriage);
				} else {
					temp = tempSum(0, getSubString(), "0", carriage);
				}
				sum = temp.concat(sum);
				temp = "";
				setSubString(getTempSubString());
				setTempSubString("");
			}
		}
		return sum;
	}

	/**
	 * Used to trim the longer number.
	 *
	 * @param firstNum
	 *            first number
	 * @param secondNum
	 *            second number
	 * @return an equal length number
	 */
	public String trimNum(String firstNum, String secondNum) {
		String trimmedNum = "";
		if (firstNum.length() > secondNum.length()) {
			trimmedNum = firstNum.substring((firstNum.length() - secondNum.length()),
					firstNum.length());
			// substrings second number if it is longer than the first
		} else if (firstNum.length() < secondNum.length()) {
			trimmedNum = secondNum.substring((secondNum.length() - firstNum.length()),
					secondNum.length());
		}
		return trimmedNum;
	}

	/**
	 * Used to find the sum of the numbers.
	 *
	 * @return the sum of the two numbers.
	 */
	public String getSum() {
		// holds the result of the sum
		String sum = "";
		// temporary string for the sum of two digits
		String temp = "";
		// holds the first digit of the sum
		int first = 0;
		// holds the second digit of the sum
		int second = 0;
		// substring used when one of the numbers is longer than the other
		String subStr = null;
		String tempSubStr = null;
		if (firstNum.length() != secondNum.length()) {
			subStr = subStr(firstNum, secondNum);
			// setSubString(subStr(firstNum, secondNum));
			if (firstNum.length() > secondNum.length()) {
				firstNum = trimNum(firstNum, secondNum);
			} else {
				secondNum = trimNum(firstNum, secondNum);
			}
		}

		for (int i = firstNum.length() - 1; i >= 0; i--) {
			temp = tempSum(i, firstNum, secondNum, carriage);
			sum = temp.concat(sum);
			temp = "";
		}

		while ((subStr != null) && carriage) {
			if ((subStr.length() == 1) && carriage) {
				temp = String.valueOf((Integer.parseInt(Character.toString(subStr.charAt(0)))) + 1);
				if (Integer.parseInt(temp) == 10) {
					temp = "0";
					sum = temp.concat(sum);
					subStr = null;
					setCarriage(true);
				} else {
					sum = temp.concat(sum);
					temp = "";
					subStr = null;
					setCarriage(false);
				}

			} else if (subStr.length() > 1) {
				tempSubStr = subStr(subStr, "1");
				subStr = trimNum(subStr, "1");
				if (!subStr.equals("9")) {
					temp = tempSum(0, subStr, "1", carriage);
				} else {
					temp = tempSum(0, subStr, "0", carriage);
				}
				sum = temp.concat(sum);
				temp = "";
				subStr = tempSubStr;
				tempSubStr = "";
			}
		}
		if ((subStr != null) && !carriage) {
			temp = subStr;
			sum = temp.concat(sum);
		}

		// addSubstr(getSubString(), carriage, sum);
		if ((subStr == null) && carriage) {
			temp = "1";
			sum = temp.concat(sum);
		}

		return sum;
	}

}
