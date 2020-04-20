/**
 * 
 */
package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author SAURABH SINGH RAJPUT
 *
 */
public class Product_of_maximum_in_first_array_and_minimum_in_second {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String[] dataArray1;
		String[] dataArray2;
		while (testCase > 0) {
			Long noOfElements1 = Long.parseLong(input.readLine());
			dataArray1 =input.readLine().split(" ");
			Long noOfElements2 = Long.parseLong(input.readLine());
			dataArray2 = input.readLine().split(" ");
			getProductOfArray(dataArray1, dataArray2, noOfElements1,noOfElements2);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void getProductOfArray(String[] dataArray1, String[] dataArray2, Long noOfElements1,
			Long noOfElements2) {

		Long max = Long.MIN_VALUE;
		Long min = Long.MAX_VALUE;
		for (String temp : dataArray1) {
			Long element = Long.parseLong(temp);
			if(max < element) {
				max = element;
			}
		}
		
		for (String temp: dataArray2) {
			Long element  = Long.parseLong(temp);
			if(min > element) {
				min = element;
			}
		}
		
		System.out.print(max*min);
	}

}
