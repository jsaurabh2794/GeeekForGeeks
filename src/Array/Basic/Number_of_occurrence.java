package Array.Basic;

import java.util.Scanner;

public class Number_of_occurrence {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Integer[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			int x = input.nextInt();
			dataArray = new Integer[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = new Integer(input.nextInt());
			}
			getNoOfOccourancesOfX(dataArray, noOfElements,x);
			System.out.println();
			testCase--;
		}

		input.close();
	
	}

	private static void getNoOfOccourancesOfX(Integer[] dataArray, int noOfElements, int x) {

		int c=0;
		for(int i=0;i<noOfElements;i++) {
			if(dataArray[i]==x) {
				c++;
			}
		}
		if(c==0)
		{
			System.out.print("-1");
		}else {
			System.out.print(c);
		}
	}

}
