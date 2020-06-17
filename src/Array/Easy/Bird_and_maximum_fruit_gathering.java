package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bird_and_maximum_fruit_gathering {
    private static final int MAX_VAL = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextLong();
            }
            long sum = birdAndMaxmFruitGathering(arr, n, m);
            System.out.println(sum);
        }
    }

    private static long birdAndMaxmFruitGathering(long[] arr, int n, int m) {
        long sum = 0l;
        for (int i = 0; i < Math.min(n, m); i++) {
            sum += arr[i];
        }

        if (m >= n) {
            return sum;
        }

        int l = 1, r = m % n;
        long currSum = sum;
        while (l < n) {
            currSum = currSum - arr[l - 1] + arr[r];
            l++;
            r = (r == n - 1 ? 0 : r + 1);
            sum = Math.max(sum, currSum);
        }
        return sum % MAX_VAL;
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
