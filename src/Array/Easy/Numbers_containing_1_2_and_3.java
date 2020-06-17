package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Numbers_containing_1_2_and_3 {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            printNumberContaining123(arr, n);
            System.out.println();
        }
    }

    private static void printNumberContaining123(Integer[] arr, int n) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0 && isContainingOneTwoAndThree(arr[i])) {
                sb.append(arr[i] + " ");
            }
        }
        if (sb.length() == 0) {
            System.out.print("-1");
        } else {
            System.out.print(sb);
        }
    }

    private static boolean isContainingOneTwoAndThree(Integer n) {
        while (n > 0) {
            int mod = n % 10;
            if (mod != 1 && mod != 2 && mod != 3) {
                return false;
            }
            n = n / 10;
        }
        return true;
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
