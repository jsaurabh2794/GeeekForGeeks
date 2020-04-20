package Array.Basic;

import java.util.Scanner;

public class Max_value_after_m_range_operation {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		
		while (testCase > 0) {
			int n = input.nextInt();
			int m = input.nextInt();
			int[] initArray = new int[n];		
			for (int i = 0; i < m; i++) {
				int a = input.nextInt();
				int b = input.nextInt();
				int k = input.nextInt();
				doPerformMrangeOp(initArray,a,b,k);
			}
            getMaxElementAfterOp(initArray,n);
            System.out.println();
			testCase--;
		}
	}

	private static void getMaxElementAfterOp(int[] initArray, int n) {
		int maxVal=0;
		for(int i=0;i<n;i++)
		{
			if(maxVal < initArray[i])
			{
				maxVal=initArray[i];
			}
		}
		System.out.print(maxVal);
	}

	private static void doPerformMrangeOp(int[] initArray, int a, int b, int k) {
		for(int i=a;i<=b;i++)
		{
			initArray[i] = initArray[i]+k;
		}
	}

}
