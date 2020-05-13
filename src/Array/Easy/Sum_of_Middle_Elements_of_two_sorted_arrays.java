package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum_of_Middle_Elements_of_two_sorted_arrays {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        String[] stringArrB;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[0]);
            stringArrA = input.readLine().trim().split("\\s+");
            stringArrB = input.readLine().trim().split("\\s+");
            Integer[] arrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(stringArrA[i]);
            }
            Integer[] arrB = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrB[i] = Integer.parseInt(stringArrB[i]);
            }
            int res = getSumOfMiddleOfTwoSortedArray(arrA, arrB, n);
            System.out.println(res);
            testCase--;
        }

        input.close();
    }

    private static int getSumOfMiddleOfTwoSortedArray(Integer[] arrA, Integer[] arrB, int n) {
        int sum = 0;
        Integer[] arrC = new Integer[n + n];
        int aPointer = 0;
        int bPointer = 0;
        int cPointer = 0;
        while (aPointer < n && bPointer < n) {
            if (arrA[aPointer] > arrB[bPointer]) {
                arrC[cPointer++] = arrB[bPointer++];
            } else if (arrA[aPointer] <= arrB[bPointer]) {
                arrC[cPointer++] = arrA[aPointer++];
            }
        }

        if (aPointer == n) {
            while (bPointer < n) {
                arrC[cPointer++] = arrB[bPointer++];
            }
        } else if (bPointer == n) {
            while (aPointer < n) {
                arrC[cPointer++] = arrA[aPointer++];
            }
        }
        sum = arrC[n] + arrC[n - 1];
        return sum;
    }
}

