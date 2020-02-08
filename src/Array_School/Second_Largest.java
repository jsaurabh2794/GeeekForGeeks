package Array_School;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Second_Largest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		TreeSet<Integer> dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			dataArray = new TreeSet<Integer>();
			for(int i=0;i<noOfElements;i++)
			{
				dataArray.add(input.nextInt());
			}
			getSecondHighest(dataArray);
			dataArray.clear();
			testCase--;
		}
	}

	private static void getSecondHighest(TreeSet dataArray) {
		//Collections.sort(dataArray);
		/*
		 * if(dataArray.size() >=2) { System.out.println(dataArray.get(dataArray.size()
		 * - 2)); }else { System.out.println(dataArray.get(0)); }
		 */
		Iterator<Integer> data = dataArray.iterator();
		int size = dataArray.size();
		while(data.hasNext())
		{
			if(size == 2)
			{
			System.out.println(data.next());
			break;
			}
			data.next();
			size--;
		}
	}

}
