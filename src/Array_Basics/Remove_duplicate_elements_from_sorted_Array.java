package Array_Basics;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Remove_duplicate_elements_from_sorted_Array {

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
			int n = sizeOfNewArrayAfterRemovingDuplicates(dataArray);
			
			for (int i = 0; i < n; i++) {
				System.out.print(dataArray[i]+" ");
			}
			
			System.out.println();
			testCase--;
		}

		input.close();
	
	}

	private static int sizeOfNewArrayAfterRemovingDuplicates(Integer[] a) {
		int size = 0;
		LinkedHashSet<Integer> data = new LinkedHashSet<Integer>();
		for (Integer integer : a) {
			data.add(integer);
		}
		size = data.size();
		Object[] dataNewArray = data.toArray();
		for (int i = 0; i < size; i++) {
			a[i] = (Integer)dataNewArray[i];
		}
		return size;
	}

}
