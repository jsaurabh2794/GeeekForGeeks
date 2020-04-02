package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Elements_in_the_Range {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String[] dataArray1;
		while (testCase > 0) {
			String[] n_a_b = input.readLine().split(" ");
			int noOfElements1 = Integer.parseInt(n_a_b[0]); 
			int a =  Integer.parseInt(n_a_b[1]);
			int b =  Integer.parseInt(n_a_b[2]);
			dataArray1 =input.readLine().split(" ");
			boolean isInrange = isElementsInTheRange(dataArray1, noOfElements1,a,b);
			System.out.println(isInrange ? "Yes":"No");
			testCase--;
		}

		input.close();
	}

	private static boolean isElementsInTheRange(String[] dataArray1, int noOfElements1, int a, int b) {
        boolean result = true;
		HashSet<Integer> arraydata = new HashSet<Integer>();
		for (String string : dataArray1) {
			Integer temp = Integer.valueOf(string);
			arraydata.add(temp);
		}
		
		for(int i=a;i<=b;i++) {
			if(!arraydata.contains(i)) {
				result = false;
				break;
			}
		}
		
		return result;
	}

}
