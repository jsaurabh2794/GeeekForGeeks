package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pairs_with_Positive_Negative_values {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            getPairWithPositiveNegative(arr, n);
            System.out.println();
        }
    }

    private static void getPairWithPositiveNegative(Integer[] arr, int n) {
        Arrays.sort(arr);
        int positiveValuePointer = 0, negativeValuePointer = 0;
        while (positiveValuePointer < n && arr[positiveValuePointer] < 0) {
            positiveValuePointer++;
        }
        negativeValuePointer = positiveValuePointer - 1; // First Positive Value, and -1 will be last negative value

        if (positiveValuePointer == n || negativeValuePointer == n - 1) {
            System.out.print(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (negativeValuePointer >= 0 && positiveValuePointer < n) {
            if (Math.abs(arr[negativeValuePointer]) == arr[positiveValuePointer]) {
                sb.append(arr[negativeValuePointer] + " " + arr[positiveValuePointer]);
                negativeValuePointer--;
                positiveValuePointer++;
            } else if (Math.abs(arr[negativeValuePointer]) > arr[positiveValuePointer]) {
                positiveValuePointer++;
            } else {
                negativeValuePointer--;
            }
        }
        System.out.print(sb.length() == 0 ? "0" : sb.toString().trim());
    }

    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
