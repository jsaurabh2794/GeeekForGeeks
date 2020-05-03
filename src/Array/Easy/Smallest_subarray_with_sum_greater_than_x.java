package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Smallest_subarray_with_sum_greater_than_x {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[0]);
            int x = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(stringArrA[i]);
            }
            int len = getSmallestSubarraySumGreaterThanXV2(arrA, n, x);
            System.out.println(len);
            testCase--;
        }

        input.close();
    }

    /*Complexity= O(n^2)*/
    private static int getSmallestSubarraySumGreaterThanX(Integer[] arrA, int n, int x) {
        int minLength = n + 1;
        for (int i = 0; i < n; i++) {
            int currSum = arrA[i];
            if (currSum > x) {
                return 1;
            }
            for (int j = i + 1; j < n; j++) {
                currSum += arrA[j];
                if (currSum > x && minLength > (j - i + 1)) {
                    minLength = (j - i + 1);
                }
            }
        }
        return minLength;
    }

    /*Complexity = O(n)*/
    /*1, 4, 45, 6, 0, 19 -> 51*/
    /*Imp*/
    private static int getSmallestSubarraySumGreaterThanXV2(Integer[] arrA, int n, int x) {
        int minLength = n + 1;
        int currSum = 0;
        int strt = 0;
        int end = 0;
        while (end < n) {
            // Keep adding array elements while current sum
            // is smaller than x
            while (currSum <= x && end < n) {
                // Ignore subarrays with
                // negative sum if x is
                // positive.
                if (currSum <= 0 && x > 0) {
                    strt = end;
                    currSum = 0;
                }
                currSum += arrA[end++];
            }
            // If current sum becomes greater than x.
            while (currSum > x && strt < n) {
                if (end - strt < minLength) {
                    minLength = end - strt;
                }
                currSum -= arrA[strt++];
            }
        }
        return minLength;
    }
}
