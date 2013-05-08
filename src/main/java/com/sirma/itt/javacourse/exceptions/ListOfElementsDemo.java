package com.sirma.itt.javacourse.exceptions;

/**
 * Run class for {@link ListOfElements}
 *
 * @author Ventsislav Marinov
 */
public class ListOfElementsDemo {
	public static void main(String args[]) {
		ListOfElements listOfElements = new ListOfElements();
		// listOfElements.remove();
		listOfElements.add("hello");
		listOfElements.remove();
		listOfElements.add(2);
		listOfElements.add("how");
		listOfElements.add("are");
		listOfElements.add("you");
		listOfElements.remove();
		listOfElements.add(555);
		listOfElements.remove();
		listOfElements.add(444);
		listOfElements.add(555);
		listOfElements.remove();
		listOfElements.printAllElements(listOfElements.getArray());

	}
}
