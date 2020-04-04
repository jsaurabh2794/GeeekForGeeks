package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Immediate_Smaller_Element {

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
			immediateSmallerElement(dataArrayInteger, noOfElements1 - 1);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void immediateSmallerElement(Integer[] dataArrayInteger, int noOfElements) {
        
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i <= noOfElements; i++) {
			if (i + 1 <= noOfElements && dataArrayInteger[i] > dataArrayInteger[i + 1]) {
				sb.append(dataArrayInteger[i + 1] + " ");
			} else {
				sb.append("-1 ");
			}
		}
		
		System.out.print(sb.toString());
	}

}
