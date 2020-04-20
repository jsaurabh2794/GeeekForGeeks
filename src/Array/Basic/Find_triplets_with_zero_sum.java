package Array.Basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Find_triplets_with_zero_sum {

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
			getTripletsIsAvailble(dataArray, noOfElements);
			System.out.println();
			testCase--;
		}

		input.close();

	}

	private static void getTripletsIsAvailble(Integer[] dataArray, int noOfElements) {

		boolean found = false;
		for (int i = 0; i < dataArray.length - 1; i++) {
			HashSet<Integer> previousData = new HashSet<>(); // storing previous traversed data
			for (int j = i + 1; j < dataArray.length; j++) {
				int x = -(dataArray[i] + dataArray[j]);
				if (previousData.contains(x)) { // checking some of both of negation is present in set
					found = true;
					break;
				} else {
					previousData.add(dataArray[j]); // otherwise adding it for future use
				}
			}

		}

		if (found) {
			System.out.print("1");
		} else {
			System.out.print("0");
		}

	}

	public boolean findTriplets(int arr[], int n) {
		// sort the elements
		Arrays.sort(arr);

		// traversing the array elements
		for (int i = 0; i < n - 2; i++) {
			int l = i + 1;
			int r = n - 1;
			int x = arr[i];

			// find the two elements which sum upto zero
			// with element at ith index
			while (l < r) {

				// check if the sum is equal to 0
				if (x + arr[l] + arr[r] == 0)
					return true;
				// else, if the sum is less than zero
				// then you need to take greater element
				else if (x + arr[l] + arr[r] < 0)
					l++;
				// If the sum is greater than 0
				// then you need to include some smaller elelment
				// instead of something greater
				else
					r--;
			}
		}
		return false;
	}
}
