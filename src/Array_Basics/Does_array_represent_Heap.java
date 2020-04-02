package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Does_array_represent_Heap {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String[] dataArray1;
		while (testCase > 0) {
			String[] n_a_b = input.readLine().split(" ");
			int noOfElements1 = Integer.parseInt(n_a_b[0]);
			dataArray1 = input.readLine().split(" ");
			Integer[] dataArrayInteger = new Integer[noOfElements1];
			for (int i = 0; i < noOfElements1; i++) {
				dataArrayInteger[i] = Integer.parseInt(dataArray1[i]);
			}
			// need to paas total index not length
			boolean isMaxHeap = doesArrayRepresentAHeap(dataArrayInteger, noOfElements1 - 1, 0);
			System.out.println(isMaxHeap ? "1" : "0");
			testCase--;
		}

		input.close();
	}

	private static boolean doesArrayRepresentAHeap(Integer[] dataArray1, int noOfElements1, int index) {
		// if leaf node then return true
		// if(2 *index + 1 > noOfElements1 && 2*index + 2 > noOfElements1) equals
		// if(index>(noOfElements1 - 2)/2)
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;

		// check is leaf Node
		if (leftIndex > noOfElements1 || (leftIndex == noOfElements1 && dataArray1[index] >= dataArray1[leftIndex])) {
			return true;
		} else if (leftIndex == noOfElements1 && dataArray1[index] < dataArray1[leftIndex]) {
			return false;
		}

		if (dataArray1[index] >= dataArray1[leftIndex] && dataArray1[index] >= dataArray1[rightIndex]
				&& doesArrayRepresentAHeap(dataArray1, noOfElements1, leftIndex)
				&& doesArrayRepresentAHeap(dataArray1, noOfElements1, rightIndex)) {
			return true;
		}

		return false;
	}

}
