package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_Missing_And_Repeating {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            findMissingAndRepeatingNumber(arr, n + 1);
            System.out.println();
        }
    }

    // 2 2
    private static void findMissingAndRepeatingNumber(Integer[] arr, int n) {
        int A = 0, B = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[(arr[i] % n) - 1] += n;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] / n == 0) {
                A = i + 1;
            }
            if (arr[i] / n >= 2) {
                B = i + 1;
            }
            if (A > 0 && B > 0) {
                break;
            }
        }
        System.out.print(B + " " + A);
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
