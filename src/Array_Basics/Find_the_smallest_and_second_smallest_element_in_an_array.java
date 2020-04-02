package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class Find_the_smallest_and_second_smallest_element_in_an_array {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String[] dataArray1;
		while (testCase > 0) {
			String[] n_a_b = input.readLine().split(" ");
			int noOfElements1 = Integer.parseInt(n_a_b[0]);
			dataArray1 = input.readLine().split(" ");
			printSmallestAndSecondSmallest(dataArray1, noOfElements1);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void printSmallestAndSecondSmallest(String[] dataArray1, int noOfElements1) {
		TreeSet<Integer> dataSet = new TreeSet<Integer>();
		for (String d : dataArray1) {
			int temp = Integer.parseInt(d);
			dataSet.add(temp);
		}
		
		Iterator<Integer> datasetItr = dataSet.iterator();
		if(dataSet.size() >= 2) {
			System.out.print(datasetItr.next() + " "+ datasetItr.next());
		}else {
			System.out.print("-1");
		}
	}

}
