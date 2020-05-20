package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chocolate_Station {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            int p = Integer.parseInt(input.readLine().trim());
            long maxSum = getMinimumCostToReachLastChoclateStation(arr, n, p);
            System.out.println(maxSum);
            testCase--;
        }

        input.close();
    }

    private static long getMinimumCostToReachLastChoclateStation(Integer[] arr, int n, int p) {
        int totalChoclateBought = arr[0]; /*Required to go first station*/
        int choclateBalance = 0;
        for (int i = 0; i < n - 1; i++) {
            choclateBalance += arr[i] - arr[i + 1];
            if (choclateBalance < 0) {
                totalChoclateBought += Math.abs(choclateBalance);
                choclateBalance = 0;
            }
        }
        return totalChoclateBought * p;
    }
}
