package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mountain_Subarray_Problem {
    /*Imp*/
    public static void main(String[] args) {
        Stickler_Thief.FastReader input = new Stickler_Thief.FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            Integer[] lastIncrementIndexBeforeThis = new Integer[n];
            Integer[] firstDecrementIndexAfterThis = new Integer[n];
            doInit(arr, lastIncrementIndexBeforeThis, firstDecrementIndexAfterThis, n);
            int noOfQuery = input.nextInt();
            while (noOfQuery-- > 0) {
                int l = input.nextInt();
                int r = input.nextInt();
                if (firstDecrementIndexAfterThis[l] >= lastIncrementIndexBeforeThis[r]) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static void doInit(Integer[] arr, Integer[] lastIncrementIndexBeforeThis, Integer[] firstDecrementIndexAfterThis, int totalLength) {
        int lastPtr = 0;
        lastIncrementIndexBeforeThis[0] = 0;
        for (int i = 1; i < totalLength; i++) {
            if (arr[i] > arr[i - 1]) {
                lastPtr = i;
            }
            lastIncrementIndexBeforeThis[i] = lastPtr;
        }
        lastPtr = totalLength - 1;
        firstDecrementIndexAfterThis[lastPtr] = totalLength - 1;

        for (int i = totalLength - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                lastPtr = i;
            }
            firstDecrementIndexAfterThis[i] = lastPtr;
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
                    st = new StringTokenizer(input.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
