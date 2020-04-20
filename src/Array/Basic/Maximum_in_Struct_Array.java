package Array.Basic;

import java.util.Scanner;

class Height {
	int feet;
	int inches;

	public Height(int feet, int inches) {
		this.feet = feet;
		this.inches = inches;
	}

}

public class Maximum_in_Struct_Array {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Height[] Height;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			Height = new Height[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				int feet = input.nextInt();
				int inches = input.nextInt();
				Height[i] = new Height(feet, inches);
			}

			int max = findMax(Height, noOfElements);

			System.out.println(max);
			testCase--;
		}
	}

	private static int findMax(Height[] height, int noOfElements) {
		int max = Integer.MIN_VALUE;
		for (Height h : height) {
			int MaxHeight = h.feet * 12 + h.inches;
			if (max < MaxHeight) {
				max = MaxHeight;
			}
		}
		return max;

	}
}
