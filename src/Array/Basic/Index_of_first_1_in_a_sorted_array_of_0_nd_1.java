package Array.Basic;

import java.util.Scanner;

public class Index_of_first_1_in_a_sorted_array_of_0_nd_1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Integer[] dataArray;
		while (testCase > 0) {
			int index = -1;
			boolean seen = false;
			int noOfElements = input.nextInt();
			dataArray = new Integer[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = new Integer(input.nextInt());
				if(dataArray[i] == 1 && !seen) {
					index = i;
					seen = true;
				}
			}
			
			System.out.println(index);
			testCase--;
		}

		input.close();

	}
	
}
