package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class First_and_last_occurrences_of_X {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String[] dataArray1;
		while (testCase > 0) {
			int noOfElements1 = Integer.parseInt(input.readLine().trim());
			dataArray1 = input.readLine().split(" ");
			int X = Integer.parseInt(input.readLine().trim());
			Integer[] dataArrayInteger = new Integer[noOfElements1];
			for (int i = 0; i < noOfElements1; i++) {
				dataArrayInteger[i] = Integer.parseInt(dataArray1[i]);
			}
			// need to paas total index not length
			findFirstAndLastOccurencesOfX(dataArrayInteger, 0, noOfElements1 - 1, X);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void findFirstAndLastOccurencesOfX(Integer[] dataArrayInteger, int strt, int end, int x) {
		int firstIndex = firstOccuranceOfX(dataArrayInteger, strt, end, x, end);
		int lastIndex = 0;
		if (firstIndex != -1) {
			lastIndex = lastOccuranceOfX(dataArrayInteger, strt, end, x, end);
		}

		System.out.print(firstIndex == -1 ? "-1":firstIndex + " " + lastIndex);
	}

	private static int lastOccuranceOfX(Integer[] dataArrayInteger, int strt, int end, int x, int total) {
		if (end >= strt) {
			int mid = strt + (end - strt) / 2;
			if (dataArrayInteger[mid] == x && ((mid == total) || (mid + 1 <= total && dataArrayInteger[mid + 1] > x))) {
				return mid;
			} else if (dataArrayInteger[mid] > x) {
				return lastOccuranceOfX(dataArrayInteger, strt, mid - 1, x, total);
			} else {
				return lastOccuranceOfX(dataArrayInteger, mid + 1, end, x, total);
			}
		}
		return -1;
	}

	private static int firstOccuranceOfX(Integer[] dataArrayInteger, int strt, int end, int x, int total) {

		if (end >= strt) {
			int mid = strt + (end - strt) / 2;
			if (dataArrayInteger[mid] == x && ((mid == 0) || (mid - 1 >= 0 && dataArrayInteger[mid - 1] < x))) {
				return mid;
			} else if (dataArrayInteger[mid] < x) {
				return firstOccuranceOfX(dataArrayInteger, mid + 1, end, x, total);
			} else {
				return firstOccuranceOfX(dataArrayInteger, strt, mid - 1, x, total);
			}
		}
		return -1;

	}

}
