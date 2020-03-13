package Array_Basics;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Index_of_first_1_in_a_sorted_array_of_0_nd_1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Integer[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			dataArray = new Integer[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = new Integer(input.nextInt());
			}
			getIndexOfFirstElement(dataArray, noOfElements);
			System.out.println();
			testCase--;
		}

		input.close();
	
	}

	private static void getIndexOfFirstElement(Integer[] dataArray, int noOfElements) {

		int index=0;
		
		index = IntStream.range(0,noOfElements).filter(t->1==dataArray[t]).findFirst().orElse(-1);
		System.out.print(index);
		
	}

}
