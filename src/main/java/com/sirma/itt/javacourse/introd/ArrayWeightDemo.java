package com.sirma.itt.javacourse.introd;

/**
 * Run class for {@link ArrayWeight} .
 *
 * @author Ventsislav Marinov
 */
public class ArrayWeightDemo {
	public static void main(String args []){
		ArrayWeight aw = new ArrayWeight();
		int [] array = {1,2,3,4,5};
		System.out.println(aw.findWeight(array));
		int [] array2 = {2,5,10,25,20,12,10,22};
		System.out.println(aw.findWeight(array2));
		int [] array3 = {5,4,3,2,1};
		System.out.println(aw.findWeight(array3));
		int [] array4 = {22,44,77,22,44,33,77};
		System.out.println(aw.findWeight(array4));
	}
}
