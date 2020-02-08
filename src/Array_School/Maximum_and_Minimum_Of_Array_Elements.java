package Array_School;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Maximum_and_Minimum_Of_Array_Elements {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		ArrayList<Integer> dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			dataArray = new ArrayList<Integer>();
			for(int i=0;i<noOfElements;i++)
			{
				dataArray.add(input.nextInt());
			}
			getMaxAndMinElememts(dataArray);
			testCase--;
		}
	}

	private static void getMaxAndMinElememts(ArrayList<Integer> dataArray) {

		Collections.sort(dataArray);
		if(dataArray.size() >=2)
		{
			System.out.println(dataArray.get(dataArray.size() - 1)+" "+dataArray.get(0));
		}else
		{
			System.out.println(dataArray.get(0)+" "+dataArray.get(0));

		}
	}

}
