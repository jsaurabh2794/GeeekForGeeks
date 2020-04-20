package Array.Basic;

import java.util.Scanner;

public class Greater_on_right_side {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			dataArray = new int[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = input.nextInt();
			}
			findGreaterOnRightSide(dataArray, noOfElements);
			System.out.println();
			testCase--;
		}

	}

	private static void findGreaterOnRightSide(int[] dataArray, int noOfElements) {
		int max = dataArray[noOfElements - 1];
		dataArray[noOfElements - 1] = -1;
		for(int i=noOfElements-2;i>=0;i--)
		{
			int temp = dataArray[i];
			dataArray[i] = max;
			if (max < temp) {
				max = temp;
			}
		}
		for(int i=0;i<noOfElements;i++)
		{
			System.out.print(dataArray[i]+" ");
		}
	}

}
