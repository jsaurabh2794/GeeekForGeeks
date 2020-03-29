package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Check_if_two_arrays_are_equal_or_not {

	public static void main(String[] args) throws IOException {

		BufferedReader newInput = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(newInput.readLine());
		String[] dataArray1;
		String[] dataArray2;
		while (testCase > 0) {
			int noOfElements = Integer.parseInt	(newInput.readLine());
			dataArray1 =newInput.readLine().split(" ");
			dataArray2 = newInput.readLine().split(" ");
			checkIfTwoArrayAreEqualOrNot(dataArray1, dataArray2, noOfElements);
			System.out.println();
			testCase--;
		}

		newInput.close();

	}

	private static void checkIfTwoArrayAreEqualOrNot(String[] dataArray1, String[] dataArray2, int noOfElements) {
        boolean isEqual = true;
		HashMap<Long, Long> dataCount = new HashMap<Long, Long>();
		for (String key : dataArray1) {
			Long newKey = Long.parseLong(key);
			if(dataCount.containsKey(newKey)) {
				dataCount.put(newKey, dataCount.get(newKey) + 1);
			}else {
				dataCount.put(newKey,1L);
			}
		}
		
		for (String Key : dataArray2) {
			Long newKey = Long.parseLong(Key);
			if(dataCount.containsKey(newKey) && dataCount.get(newKey) >= 1) {
				dataCount.put(newKey, dataCount.get(newKey) - 1);
			}else {
				isEqual = false;
				break;
			}
		}
		
		System.out.print(isEqual ? "1":"0");
	}

}
