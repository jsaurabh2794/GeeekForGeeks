package Array_School;

import java.util.Scanner;

public class Pascal_Triangle {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		while (testCase > 0) {
			int row = input.nextInt();
			getKthRowOfPascalTriangle(row);
			System.out.println();
			testCase--;
		}
	}

	private static void getKthRowOfPascalTriangle(int row) {

		int c = 1; // first is always 1
		for(int i=1; i<=row;i++)
		{
			System.out.print(c+" ");
			c = (c * (row - i)) / i;
		}
	}

}
