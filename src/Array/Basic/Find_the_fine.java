package Array.Basic;

import java.util.Scanner;

public class Find_the_fine {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int[] carsNosArray;
		int[] pennaltiesArray;
		while (testCase > 0) {
			int n = input.nextInt();
			int d =input.nextInt(); //given date...if even collect fine from oddNo cars and vice versa
			carsNosArray = new int[n];
			pennaltiesArray = new int[n];
			for (int i = 0; i < n; i++) {
				carsNosArray[i] = input.nextInt();
			}
			for (int i = 0; i < n; i++) {
				pennaltiesArray[i] = input.nextInt();
			}
			findPenalitiesBasedOnDate(carsNosArray,pennaltiesArray,n,d);
			System.out.println();
			testCase--;
		}

	}

	private static void findPenalitiesBasedOnDate(int[] carsNosArray, int[] pennaltiesArray, int n, int d) {
        int penalities = 0;
		if(d %2 == 0)
		{
			for(int i=0;i<n;i++)
			{
				if(carsNosArray[i] %2 == 1)
				{
					penalities+=pennaltiesArray[i];
				}
			}
			
		}else {
			for(int i=0;i<n;i++)
			{
				if(carsNosArray[i] %2 == 0)
				{
					penalities+=pennaltiesArray[i];
				}
			}
		}
		System.out.print(penalities);
		
	}

}
