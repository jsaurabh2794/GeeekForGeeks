package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Element_with_left_side_smaller_and_right_side_greater {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int reqElement = elementWithLeftSideAndRight(arr, n);
            System.out.println(reqElement);
        }
    }

    private static int elementWithLeftSideAndRight(Integer[] arr, int n) {
        int[] left = new int[n];
        int[] right = new int[n];

        int tempMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (tempMax < arr[i]) {
                tempMax = arr[i];
            }
            left[i] = tempMax;
        }

        int tempMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (tempMin > arr[i]) {
                tempMin = arr[i];
            }
            right[i] = tempMin;
        }

        for (int i = 1; i < n - 1; i++) {
            if (left[i] == right[i]) {
                return left[i]; // Both are equal, can send anyone.
            }
        }
        return -1;
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
