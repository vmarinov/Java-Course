package com.sirma.itt.javacourse.introd;
/**
 * Class used to determine the center weight of an array.
 *
 * @author Ventsislav Marinov
 */
public class ArrayWeight {

	/**
	 * @param array
	 *            that is processed.
	 * @return Returns the center weight of the array.
	 */
	public static int findWeight(int [] array){
		// holds the value of the center weight
		int arrayWeight = 0;
		// first index of the array
		int firstIndex;
		// last index of the array
		int lastIndex;
		// sum before the center weight
		int sum1=0;
		// sum after the center weight
		int sum2=0;
		// compares the sums of elements from firstIndex to lastIndex
		for(firstIndex = 0, lastIndex = array.length-1;firstIndex < lastIndex ;)
		{
			if(sum1 < sum2)
			{
				sum1 += array[firstIndex++];
			} else {
				sum2 += array[lastIndex--];
			}

		}

		arrayWeight = array[firstIndex];
		return arrayWeight;
	}

}
