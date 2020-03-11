package Array_Basics;

import java.util.Scanner;

public class Convert_array_into_Zig_Zag_fashion {

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
			convertIntoZigZagArray(dataArray, noOfElements);
			System.out.println();
			testCase--;
		}

	}

	private static void convertIntoZigZagArray(int[] dataArray, int noOfElements) {
		for(int i=1; i< noOfElements; i++) {
			int temp;
			if(i%2 == 1) {
				if(dataArray[i-1] > dataArray[i])
				{
					temp = dataArray[i - 1];
					dataArray[i-1] = dataArray[i];
					dataArray[i] = temp;
				}
			}else {
				if(dataArray[i-1] < dataArray[i])
				{
					temp = dataArray[i];
					dataArray[i] = dataArray[i -1];
					dataArray[i - 1] = temp;
				}
			}
		}
		
		for(int i:dataArray) {
			System.out.print(i+" ");
		}
	}

}
