package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Majority_Element {

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
			findMajorityElement(dataArrayInteger, noOfElements1);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void findMajorityElement(Integer[] dataArrayInteger, int noOfElements1) {

		int size = noOfElements1/2;
		int majorityElement = -1;
		HashMap<Integer, Integer> countOfElements = new HashMap<Integer, Integer>();
		for (int i = 0; i < noOfElements1; i++) {
			if(countOfElements.containsKey(dataArrayInteger[i])) {
				int currCount = countOfElements.get(dataArrayInteger[i]) + 1;
				countOfElements.put(dataArrayInteger[i], currCount);
				if(currCount > size) {
					majorityElement = dataArrayInteger[i];
					break;
				}
			}else {
				countOfElements.put(dataArrayInteger[i], 1);
			}
		}
		System.out.print(majorityElement);
	}

}
