package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pair_with_given_sum_in_a_sorted_array {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int givenSum = input.nextInt();
            printSumPair(arr, n, givenSum);
        }
    }

    private static void printSumPair(int[] arr, int n, int givenSum) {
        int l = 0, r = n - 1;
        StringBuilder sb = new StringBuilder();
        while (l < r) {
            if (arr[l] + arr[r] == givenSum) {
                sb.append(arr[l] + " " + arr[r] + " " + givenSum + "\n");
                l++;
                r--;
            } else if (arr[l] + arr[r] > givenSum) {
                r--;
            } else {
                l++;
            }
        }
        if (sb.length() == 0) {
            System.out.println("-1");
        } else {
            System.out.println(sb.toString().trim());
        }
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

        private String next() {
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
