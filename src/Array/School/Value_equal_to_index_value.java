package Array.School;

import java.util.Scanner;

public class Value_equal_to_index_value {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			dataArray = new int[noOfElements + 1];
			for (int i = 1; i <= noOfElements; i++) {
				dataArray[i] = input.nextInt();
			}
			getValueEqualToIndex(dataArray,noOfElements);
			System.out.println();
			testCase--;
		}
	}

	private static void getValueEqualToIndex(int[] dataArray,int length) {
		boolean isPresent = false;
		for(int i=1; i<= length; i++)
		{
			if(dataArray[i] == i)
			{
				isPresent = true;
				System.out.print(dataArray[i]+" ");
			}
		}
		
		if(!isPresent)
		{
			System.out.print("Not Found");
		}
	}

}
