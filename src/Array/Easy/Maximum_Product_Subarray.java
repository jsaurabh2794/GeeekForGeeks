package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maximum_Product_Subarray {

    private static final long val = 1000000007;

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
            maximumProductSubarray(arr, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    /*Imp*/
    private static void maximumProductSubarray(Integer[] arr, int n) {
        long maxmProduct = Long.MIN_VALUE;
        long tempMaxValue = 1;
        long tempMinValue = 1;
        n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                tempMaxValue *= arr[i];
                tempMinValue = Math.min(1, tempMinValue * arr[i]); // always be 1 or negative
            } else if (arr[i] == 0) { //Reset
                tempMaxValue = 0;
                tempMinValue = 1;
            } else {
                // When negative sign will come Max and Min will be swiped
                long temp = tempMaxValue;
                tempMaxValue = tempMinValue * arr[i];
                tempMinValue = temp * arr[i];
            }
            maxmProduct = Math.max(tempMaxValue, maxmProduct);
            if (tempMaxValue <= 0) { // So next iteration it will do product. when less than next iteration,it will be swiped with min value
                tempMaxValue = 1;
            }
        }
        System.out.print(maxmProduct % val);
    }
}
