package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Max_Sum_without_Adjacents {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            long maxSum = maxSumWithoutAdjacent(arr, N);
            System.out.println(maxSum);
            testCase--;
        }

        input.close();
    }

    private static long maxSumWithoutAdjacent(Integer[] arr, int n) {
        long includingThis = arr[0]; /*Initially included first Element*/
        long excludingThis = 0;      /*Initially Excluded first element*/
        for (int i = 1; i < n; i++) {
            long maxTillHereExcludingThis = Math.max(includingThis, excludingThis);
            includingThis = (excludingThis + arr[i]); /*Consider ith item then ignore prev item*/
            excludingThis = maxTillHereExcludingThis; /*Exclude ith item then see max of prev including i-1 or excluding i-1*/
        }
        return Math.max(includingThis, excludingThis);
    }
}
