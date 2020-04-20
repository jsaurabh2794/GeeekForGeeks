package Array.Basic;

import java.util.HashSet;
import java.util.Scanner;

public class Find_the_Odd_Occurence {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Integer[] dataArray;
		while (testCase > 0) {
			int noOfElements = input.nextInt();
			dataArray = new Integer[noOfElements];
			for (int i = 0; i < noOfElements; i++) {
				dataArray[i] = new Integer(input.nextInt());
			}
			findTheOddOccurence(dataArray, noOfElements);
			System.out.println();
			testCase--;
		}

		input.close();
	
	}

	private static void findTheOddOccurence(Integer[] dataArray, int noOfElements) {
		HashSet<Integer> data = new HashSet<Integer>();
		for(Integer temp: dataArray) {
			if(data.contains(temp)) {
				data.remove(temp);
			}else {
				data.add(temp);
			}
		}
		if(data.size() == 0) {
			System.out.print("0");
		}else {
			data.stream().forEach(a->{
				System.out.print(a);
			});
		}
	}

}
