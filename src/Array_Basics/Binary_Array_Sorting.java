package Array_Basics;

import java.util.Scanner;

public class Binary_Array_Sorting {

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
			sortTheArray(dataArray, noOfElements);
			System.out.println();
			testCase--;
		}

	}

	private static void sortTheArray(int[] dataArray, int noOfElements) {

		StringBuffer sbfor0 =new StringBuffer("");
		StringBuffer sbfor1 =new StringBuffer("");
		for (int d : dataArray) {
			if (d == 0) {
				sbfor0.append("0 ");
			} else {
				sbfor1.append("1 ");
			}
		}
		
		System.out.print(sbfor0.toString().concat(sbfor1.toString()));

	}

}
