package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Segregate_Even_and_Odd_numbers {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String[] dataArray1;
		while (testCase > 0) {
			String[] n_a_b = input.readLine().split(" ");
			int noOfElements1 = Integer.parseInt(n_a_b[0]);
			dataArray1 = input.readLine().split(" ");
			doSegregateEvenAndOdd(dataArray1, noOfElements1);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void doSegregateEvenAndOdd(String[] dataArray1, int noOfElements1) {

		Integer[] dataArrayInteger = new Integer[noOfElements1];
		for (int i = 0; i < noOfElements1; i++) {
			dataArrayInteger[i] = Integer.parseInt(dataArray1[i]);
		}
		List<Integer> dataArrayList = Arrays.asList(dataArrayInteger);
		Collections.shuffle(dataArrayList);
		dataArrayList.toArray(dataArrayInteger);

		Arrays.sort(dataArrayInteger);
		StringBuffer evens = new StringBuffer("");
		StringBuffer odds = new StringBuffer("");
		for (int i = 0; i < noOfElements1; i++) {
          if(dataArrayInteger[i]%2==0) {
        	  evens.append(dataArrayInteger[i]+" ");
          }else {
        	  odds.append(dataArrayInteger[i]+" ");
          }
		}
		
		System.out.print(evens.toString().concat(odds.toString()));
	}

}
