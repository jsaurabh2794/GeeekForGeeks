package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Count_the_elements {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        while (testCase-- > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            String[] arrA = input.readLine().trim().split("\\s+");
            String[] arrB = input.readLine().trim().split("\\s+");
            Integer[] intArrA = new Integer[n];
            Integer[] intArrB = new Integer[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(arrA[i]);
            }
            for (int i = 0; i < n; i++) {
                intArrB[i] = Integer.parseInt(arrB[i]);
            }
            Arrays.sort(intArrB);
            int noOfQuery = Integer.parseInt(input.readLine().trim());
            while (noOfQuery-- > 0) {
                int indexOfA = Integer.parseInt(input.readLine().trim());
                System.out.println(getTheCountOfTotalElement(intArrA[indexOfA], intArrB, n));
            }
        }
    }

    private static int getTheCountOfTotalElement(Integer k, Integer[] arrB, int total) {
        return getTheCountOfTotalElement(k, arrB, 0, total - 1, total);
    }

    private static int getTheCountOfTotalElement(Integer k, Integer[] arr, int l, int r, int total) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid < total - 1 && arr[mid] == k && arr[mid] < arr[mid + 1]) || mid == total - 1 && arr[mid] <= k) {
                return mid + 1;
            } else if (arr[mid] > k) {
                return getTheCountOfTotalElement(k, arr, l, mid - 1, total);
            } else {
                return getTheCountOfTotalElement(k, arr, mid + 1, r, total);
            }
        }
        return 0;
    }

}
