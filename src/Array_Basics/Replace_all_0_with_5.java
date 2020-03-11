package Array_Basics;

import java.util.Scanner;

public class Replace_all_0_with_5 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		while (testCase > 0) {
			int Element = input.nextInt();
			doReplace0with5(Element);
			System.out.println();
			testCase--;
		}

	}

	private static void doReplace0with5(int Element) {
	
		String s=new String("");
		while(Element>0)
		{
			if(Element%10 == 0)
			{
				s = "5".concat(s);
			}else
			{
				s =String.valueOf((Element%10)).concat(s);
			}
			Element=Element/10;
		}
		System.out.print(s);
	}

}
