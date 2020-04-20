package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Absolute_Difference_of_1 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String[] dataArray;
		while (testCase > 0) {
			String[] secondLine = input.readLine().split(" ");
			int noOfElements = Integer.parseInt(secondLine[0]);
			Long k = Long.parseLong(secondLine[1]);
			dataArray = input.readLine().split(" ");
			Long[] dataArrayInteger = new Long[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArrayInteger[i] = Long.parseLong(dataArray[i]);
			}
			findAbsoluteDefferenceOfOne(dataArrayInteger, noOfElements, k);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void findAbsoluteDefferenceOfOne(Long[] dataArrayInteger, int noOfElements, Long k) {

		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < noOfElements; i++) {
			if (dataArrayInteger[i] < k && isAdjacentDigitDiffOne(dataArrayInteger[i])) {
				buffer.append(dataArrayInteger[i] + " ");
			}
		}
		System.out.print(buffer.toString().length() == 0 ? "-1" : buffer.toString());
	}

	private static boolean isAdjacentDigitDiffOne(Long data) {
		boolean result = true;
		long currDigit = data % 10;
		long nextDigit = 0;

		if (data.toString().length() == 1) {
			return false;
		}

		while (data > 0 && data.toString().length() > 1) {
			data = data / 10;
			nextDigit = data % 10;
			if (Math.abs(currDigit - nextDigit) == 1) {
				currDigit = nextDigit;
			} else {
				result = false;
				break;
			}
		}

		return result;
	}

}
