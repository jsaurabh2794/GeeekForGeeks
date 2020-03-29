package Array_Basics;

import java.util.Scanner;

public class Find_duplicates_under_given_constraints {

	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int[] dataArray;
		while (testCase > 0) {
			int noOfElements = 10;
			dataArray = new int[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = input.nextInt();
			}
			getDuplicatesInTwoComparison(dataArray, noOfElements);
			System.out.println();
			testCase--;
		}

	
	}

	private static void getDuplicatesInTwoComparison(int[] dataArray, int noOfElements) {

		if(dataArray[5] == dataArray[6]) {
			System.out.print(dataArray[5]);
		}else {
			System.out.print(dataArray[4]);
		}
	}

}
