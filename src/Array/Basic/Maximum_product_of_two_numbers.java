package Array.Basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Maximum_product_of_two_numbers {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Integer[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			dataArray = new Integer[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = new Integer(input.nextInt());
			}
			getMaximumProductOfArray(dataArray, noOfElements);
			System.out.println();
			testCase--;
		}

		input.close();
	
	}

	private static void getMaximumProductOfArray(Integer[] dataArray, int noOfElements) {

		
		int first_max=0;
		int secondMax = 0;
		int currentIndex = 0;
		for (int i = 0; i < noOfElements; i++) {
			if(dataArray[i] > first_max)
			{
				first_max = dataArray[i];
				currentIndex = i;
			}
		}
		for (int i = 0; i < noOfElements; i++) {
			if(dataArray[i] > secondMax && i != currentIndex)
			{
				secondMax = dataArray[i];
			}
		}
		System.out.print(first_max*secondMax);
	}

}
