package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maximum_Index {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (input.nextInt());
            }
            getMaximumIndex(arr, n);
            System.out.println();
        }
    }

    private static void getMaximumIndex(int[] arr, int n) {
        int maxIndex = Integer.MIN_VALUE;
        int tempIndex = -1;
        int l = 0, r = 0;
        int[] RMax = new int[n];
        int[] LMin = new int[n];
        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (int i = 1; i < n; ++i)
            LMin[i] = Math.min(arr[i], LMin[i - 1]);
        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(arr[j], RMax[j + 1]);
        while (r < n && l < n) {
            if (LMin[l] <= RMax[r]) {
                maxIndex = Math.max(maxIndex, r - l);
                r++;
            } else {
                l++;
            }

        }
        System.out.print(maxIndex);
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
