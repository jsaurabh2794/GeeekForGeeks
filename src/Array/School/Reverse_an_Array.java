package Array.School;

import java.util.Scanner;

public class Reverse_an_Array {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			dataArray = new int[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = input.nextInt();
			}
			doReverseAnArray(dataArray);
			System.out.println();
			testCase--;
		}
	}

	private static void doReverseAnArray(int[] dataArray) {
		for(int i=dataArray.length -1 ; i>=0; i--)
		{
			System.out.print(dataArray[i] + " ");
		}
	}

}
