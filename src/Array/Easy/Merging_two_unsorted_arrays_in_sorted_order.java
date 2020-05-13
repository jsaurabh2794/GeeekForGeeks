package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Merging_two_unsorted_arrays_in_sorted_order {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        String[] stringArrB;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[0]);
            int m = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            stringArrB = input.readLine().trim().split("\\s+");
            Integer[] arrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(stringArrA[i]);
            }
            Integer[] arrB = new Integer[m];
            for (int i = 0; i < m; i++) {
                arrB[i] = Integer.parseInt(stringArrB[i]);
            }
            mergeTwoUnsortedIntoSorted(arrA, arrB, n, m);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void mergeTwoUnsortedIntoSorted(Integer[] arrA, Integer[] arrB, int n, int m) {
        Integer[] arrC = new Integer[n + m];
        int aPointer = 0;
        int bPointer = 0;
        int cPointer = 0;
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        while (aPointer < n && bPointer < m) {
            if (arrA[aPointer] > arrB[bPointer]) {
                arrC[cPointer++] = arrB[bPointer++];
            } else if (arrA[aPointer] <= arrB[bPointer]) {
                arrC[cPointer++] = arrA[aPointer++];
            }
        }

        if (aPointer == n) {
            while (bPointer < m) {
                arrC[cPointer++] = arrB[bPointer++];
            }
        } else if (bPointer == m) {
            while (aPointer < n) {
                arrC[cPointer++] = arrA[aPointer++];
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrC.length; i++) {
            sb.append(arrC[i] + " ");
        }
        System.out.print(sb.toString().trim());
    }
}
