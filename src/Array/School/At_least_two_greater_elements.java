package Array.School;

import java.util.Arrays;
import java.util.Scanner;

public class At_least_two_greater_elements {

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
			getAtleaseTwoGreaterElements(dataArray);
			System.out.println();
			testCase--;
		}
	}

	private static void getAtleaseTwoGreaterElements(int[] dataArray) {
		Arrays.sort(dataArray);
		for(int i=0; i< dataArray.length - 2; i++)
		{
			System.out.print(dataArray[i]);
			if(i <= dataArray.length - 3)
			{
				System.out.print(" ");
			}
		}
	}

}
