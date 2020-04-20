package Array.Basic;

import java.util.Scanner;

public class Rotate_Array {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int[] dataArray;
		long start = System.currentTimeMillis();
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			int clockwiseElements = input.nextInt();
			dataArray = new int[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = input.nextInt();
			}

			doRotateArray(dataArray, clockwiseElements, noOfElements);

			System.out.println();
			testCase--;
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");
	}

	private static void doRotateArray(int[] dataArray, int clockwiseElements, int noOfElements) {
		StringBuffer res = new StringBuffer("");
		for (int i = clockwiseElements; i < noOfElements; i++) {
			res.append(dataArray[i] + " ");
		}
		for (int i = 0; i < clockwiseElements; i++) {
			res.append(dataArray[i] + " ");
		}
		System.out.print(res.toString());
	}
}
