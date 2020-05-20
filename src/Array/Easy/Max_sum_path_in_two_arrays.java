package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Max_sum_path_in_two_arrays {
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
            int sum = getMaxSubPathInTwoSortedArray(arrA, arrB, n, m);
            System.out.println(sum);
            testCase--;
        }

        input.close();
    }

    private static int getMaxSubPathInTwoSortedArray(Integer[] arrA, Integer[] arrB, int n, int m) {
        int i = 0, j = 0;
        int maxSum = 0;
        int sumForArrayA = 0, sumForArrayB = 0;

        while (i < n && j < m) {
            if (arrA[i] > arrB[j]) {
                sumForArrayB += arrB[j++];
            } else if (arrA[i] < arrB[j]) {
                sumForArrayA += arrA[i++];
            } else {
                // When see first Common point
                maxSum += Math.max(sumForArrayA, sumForArrayB);
                sumForArrayA = 0;
                sumForArrayB = 0;

                // check till all common point
                while (i < n && j < m && arrA[i] == arrB[j]) {
                    maxSum += arrA[i]; // can add one because both are same;
                    i++;
                    j++;
                }
            }
        }
        // if arrA is remaining
        while (i < n) {
            sumForArrayA += arrA[i++];
        }
        // if arrB is remaining
        while (j < m) {
            sumForArrayB += arrB[j++];
        }
        maxSum += Math.max(sumForArrayA, sumForArrayB);


        return maxSum;
    }
}
