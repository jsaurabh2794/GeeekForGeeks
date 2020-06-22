package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stock_span_problem {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            printStockSpan(arr, n);
            System.out.println();
        }
    }

    private static void printStockSpan(Integer[] arr, int n) {
        int[] span = new int[n];
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            int spanCounter = 1;
            int j = i - 1;
            while (j >= 0 && arr[j] <= arr[i]) {
                spanCounter++;
                j--;
            }
            span[i] = spanCounter;
        }
        StringBuilder sb = new StringBuilder();
        for (int t : span) {
            sb.append(t + " ");
        }
        System.out.print(sb);
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
