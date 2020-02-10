package Array_School;

import java.util.Arrays;
import java.util.Scanner;

public class Swap_Kth_Elememt {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			int k = input.nextInt();
			dataArray = new int[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = input.nextInt();
			}
			doSwapKthElemFromBegAndEnd(dataArray, k);
			testCase--;
		}
	}

	private static void doSwapKthElemFromBegAndEnd(int[] dataArray, int k) {

		int length = dataArray.length;
		int temp = dataArray[length - k];
		dataArray[length - k] = dataArray[k - 1];
		dataArray[k - 1] = temp;
		
	   Arrays.stream(dataArray).forEach(i ->{
		   System.out.print(i+" ");
	   });
	}
}
