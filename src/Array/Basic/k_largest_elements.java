package Array.Basic;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class k_largest_elements {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Integer[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			int k = input.nextInt();
			dataArray = new Integer[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = new Integer(input.nextInt());
			}
			printKlargestInDecendingOrder(dataArray, noOfElements, k);
			System.out.println();
			testCase--;
		}

		input.close();

	}

	private static void printKlargestInDecendingOrder(Integer[] dataArray, int noOfElements, int k) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>(); // Min Heap Creation
		
		//insert K elements
		for (int i = 0; i < noOfElements; i++) {
			if(k-- > 0)
			{
			  minHeap.add(dataArray[i]);
			}else if(minHeap.peek() < dataArray[i]) {
				minHeap.poll();
				minHeap.add(dataArray[i]);
			}
		}
		StringBuffer s = new StringBuffer("");
		while(!minHeap.isEmpty()) {
			s.insert(0, " "+minHeap.poll());
		}
 	   System.out.print(s.substring(1));
	}

}
