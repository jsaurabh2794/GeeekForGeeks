package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*Imp*/
public class Remove_minimum_elements {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int count = getCountOfRemovalOfMinimumElements(arr, n);
            System.out.println(count);
        }
    }

    private static int getCountOfRemovalOfMinimumElements(Integer[] arr, int n) {
        Arrays.sort(arr);
        int countOfRemovalOfElements = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int upperBound = getUpperLimitIndex(arr, 2 * arr[i]);
            countOfRemovalOfElements = Math.min(countOfRemovalOfElements, n - (upperBound - i));
            // 4 5 9 10 11 12 15 100 200 , i = 0, n = 9, upperbound = 1
        }

        return countOfRemovalOfElements;
    }

    private static int getUpperLimitIndex(Integer[] arr, int number) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= number) {
                l = mid + 1; // if Equals then next will be upper bond index
            } else {
                r = mid;
            }
        }
        return l;
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
