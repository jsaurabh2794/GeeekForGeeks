package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Minimize_the_heights {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int k = input.nextInt();
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            doMinimizeTheHeights(arr, n, k);
            System.out.println();
        }
    }

    private static void doMinimizeTheHeights(Integer[] arr, int n, int k) {
        //First Sort the Data
        Arrays.sort(arr);
        //Initialize the Data
        int big = arr[n - 1] - k;
        int small = arr[0] + k;
        // Handle Scenario if small is greater than big
        if (small > big) {
            int temp = big;
            big = small;
            small = temp;
        }
        int minimumHeight = arr[n - 1] - arr[0];

        // Now do for all elements
        for (int i = 1; i < n - 1; i++) {
            int tempSmall = arr[i] - k;
            int tempBig = arr[i] + k;

            // tempSmall is greater than small ignore, because Can't give Min || tempBig < big, ignore need to pick highest
            if (tempSmall >= small || big >= tempBig) {
                continue;
            }

            if (big - tempSmall <= tempBig - small) {
                small = tempSmall;
            } else {
                big = tempBig;
            }
        }
        System.out.print(Math.min(minimumHeight, big - small));
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
