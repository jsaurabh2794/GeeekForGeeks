package Array.Basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Third_largest_element {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Long[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			dataArray = new Long[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = new Long(input.nextLong());
			}

			long n = printThirdLargestElement(dataArray);
			System.out.println(n);
			testCase--;
		}

		input.close();

	}

	private static Long printThirdLargestElement(Long[] a) {

		/*
		 * int noOfElements = dataArray.length; long third = -1; if (noOfElements < 3) {
		 * return third; } Arrays.sort(dataArray, Collections.reverseOrder()); return
		 * dataArray[2];
		 */


		Long first = Long.MIN_VALUE;
		Long second = Long.MIN_VALUE;
		Long third = Long.MIN_VALUE;
		
		if(a.length < 3) {
			return -1L;
		}
		
		for (int i = 0; i < a.length; i++) {
			if(first < a[i]) {
				third = second;
				second = first;
				first = a[i];
			}else if(second < a[i]) {
				third = second;
				second = a[i];
			}else if(third < a[i]) {
				third = a[i];
			}
		}
		
		
		
		return third;
	
	}

}
