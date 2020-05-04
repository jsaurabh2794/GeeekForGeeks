package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Largest_subarray_with_0_sum {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split(" ");
            Integer[] intArrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            int singleNumber = getMaxmLength(intArrA, n);
            System.out.println(singleNumber);
            testCase--;
        }

        input.close();
    }

    /*Imp*/
    private static int getMaxmLength(Integer[] arrA, int n) {
        int maxmLength = Integer.MIN_VALUE;
        int sum = 0;
        HashMap<Integer, Integer> prevSum = new HashMap<>(); /*Sum with index*/
        for (int i = 0; i < n; i++) {
            sum += arrA[i];
            if (arrA[i] == 0 && maxmLength == Integer.MIN_VALUE) {
                maxmLength = 1;
            }
            if (sum == 0) {
                maxmLength = i + 1; /*We follow Zero Index*/
            }
            Integer previousSum = prevSum.get(sum); // get the prev index  if sum is stored earlier also.
            if (previousSum != null) {
                maxmLength = Math.max(maxmLength, i - previousSum);
            } else {
                prevSum.put(sum, i); /* Storing Index in Zero Based*/
            }
        }
        return maxmLength;
    }
}
