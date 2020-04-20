package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Count_triplets_with_sum_smaller_than_X {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String[] dataArray1;
		while (testCase > 0) {
			String[] n_a_b = input.readLine().split(" ");
			int noOfElements1 = Integer.parseInt(n_a_b[0]);
			int X = Integer.parseInt(n_a_b[1]);
			dataArray1 = input.readLine().split(" ");
			Integer[] dataArrayInteger = new Integer[noOfElements1];
			for (int i = 0; i < noOfElements1; i++) {
				dataArrayInteger[i] = Integer.parseInt(dataArray1[i]);
			}
			// need to paas total index not length
			countTripletsLessThanX(dataArrayInteger, noOfElements1, X);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void countTripletsLessThanX(Integer[] dataArrayInteger, int noOfElements1, int X) {

		int count = 0;
		List<Integer> list = Arrays.asList(dataArrayInteger);
		Collections.shuffle(list);
		list.toArray(dataArrayInteger);
		Arrays.sort(dataArrayInteger);

		for (int i = 0; i < noOfElements1 - 2; i++) {
			int j = i + 1;
			int k = noOfElements1 - 1;
			while (j < k) {
               if(dataArrayInteger[i] + dataArrayInteger[j] + dataArrayInteger[k] < X ) {
            	   count += (k-j); // all values less than index k will give sum less than x 
            	   j++;
               }else {
            	   k--;
               }
			}
		}
		
		System.out.print(count);

	}

}
