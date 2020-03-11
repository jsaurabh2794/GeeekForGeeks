package Array_Basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sort_in_specific_order {

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
			sortTheArrayInSpeceficOrder(dataArray, noOfElements);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void sortTheArrayInSpeceficOrder(Integer[] dataArray, int noOfElements) {

		// Arrays.sort uses quick sort in behined the scene... so always try to shuffle
		// then sort otherwise
		// for sorted array it will give O(n^2).
		List<Integer> intListDataArray = Arrays.asList(dataArray);
		Collections.shuffle(intListDataArray);
		intListDataArray.toArray(dataArray);

		Arrays.sort(dataArray, Collections.reverseOrder());

		StringBuffer sbOdd = new StringBuffer("");
		StringBuffer sbeven = new StringBuffer("");

		for (int i = 0; i < noOfElements; i++) {
			if (dataArray[i] % 2 == 1) {
				sbOdd.append(dataArray[i] + " ");
			} else {
				sbeven.insert(0, " " + dataArray[i]);
			}
		}

		System.out.print(sbOdd.toString().concat(sbeven.toString()).toString().replaceFirst("  ", " "));

	}

}
