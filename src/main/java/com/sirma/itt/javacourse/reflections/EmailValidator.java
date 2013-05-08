package com.sirma.itt.javacourse.reflections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates if a string is an email.
 *
 * @author Ventsislav Marinov
 */
public class EmailValidator {
	/**
	 * Pattern used for validating the email.
	 */
	private static final Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"
			+ "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	/**
	 * Matches the inputed e-mail with the validation pattern.
	 */
	private static Matcher matcher;
	/**
	 * The inputed e-mail by the user that is validated.
	 */
	private static String inputedMail;

	public void init() {
		inputedMail = inputMail();
		validate(inputedMail);
	}

	/**
	 * Used to input an e-mail.
	 *
	 * @return the inputed e-mail
	 */
	private String inputMail() {
		String email = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input your email: ");
		try {
			email = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}

	/**
	 * Checks the validity of the inputed e-mail.
	 *
	 * @param mail
	 *            the inputed e-mail
	 */
	private static void validate(String mail) {
		matcher = pattern.matcher(mail);
		if (matcher.matches()) {
			System.out.println("That is a valid e-mail.");
		} else {
			System.out.println("This isn't a valid e-mail.");
		}

	}

	public static void main(String args[]) {
		EmailValidator eValidator = new EmailValidator();
		eValidator.init();
	}
}
