package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stickler_Thief {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int maxmAmount = getMaxmAmount(arr, n);
            System.out.println(maxmAmount);
        }
    }

    private static int getMaxmAmount(Integer[] arr, int n) {
        int incl = arr[0], excl = 0;
        for (int i = 1; i < n; i++) {
            int tempExclThis = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = tempExclThis;
        }
        return Math.max(incl, excl);
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
                    st = new StringTokenizer(input.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
