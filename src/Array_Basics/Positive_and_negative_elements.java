/**
 * 
 */
package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author SAURABH SINGH RAJPUT
 *
 */
public class Positive_and_negative_elements {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String[] dataArray1;
		while (testCase > 0) {
			int noOfElements1 = Integer.parseInt(input.readLine());
			dataArray1 =input.readLine().split(" ");
			getPositiveAndNegativeOrder(dataArray1, noOfElements1);
			System.out.println();
			testCase--;
		}

		input.close();
	}

	private static void getPositiveAndNegativeOrder(String[] dataArray1, int noOfElements1) {

		int[] newArray = new int[noOfElements1];
		int positivePointer = 0;
		int negativePointer = 1;
		
		for (int i = 0; i < noOfElements1; i++) {
			int data = Integer.parseInt(dataArray1[i]);
			if(data < 0 && (negativePointer) < noOfElements1) {
				newArray[negativePointer] = data;
				negativePointer = negativePointer + 2;
			}else if(data > 0 && (positivePointer) < noOfElements1) {
				newArray[positivePointer] = data;
				positivePointer = positivePointer+2;
			}
		}
	   for(int n: newArray) {
		   System.out.print(n+" ");
	   }
	}

}
