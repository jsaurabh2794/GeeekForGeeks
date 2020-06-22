package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/
//Note: Expected solution in O(n) time using constant extra space (don't use hash maps or sorting algorithms in your solution).
public class Smallest_Positive_missing_number {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int res = smallestPositiveMissingNumber(arr, n);
            System.out.println(res);
        }
    }

    private static int smallestPositiveMissingNumber(Integer[] arr, int n) {
        // segregate all positive and negative together
        int index = shiftPostiveAndNegative(arr, n); // give first positive or zero 's index
        int[] positiveArray = new int[n - index];
        int j = 0;
        for (int i = index; i < n; i++) {
            positiveArray[j++] = arr[i]; // create new Array with all +ve value
        }
        return findMissingPositiveValue(positiveArray, positiveArray.length);
    }

    //Positive means > 0
    // Smallest means from 1 to ...
    private static int findMissingPositiveValue(int[] positiveArray, int length) {
        for (int i = 0; i < length; i++) {
            int x = Math.abs(positiveArray[i]); // the number which already converted to negative
            if (x - 1 < length && positiveArray[x - 1] > 0) {
                positiveArray[x - 1] = -positiveArray[x - 1];
            }
        }

        for (int i = 0; i < length; i++) {
            if (positiveArray[i] > 0) {
                return i + 1;// because of zero index
            }
        }
        return length + 1;
    }

    private static int shiftPostiveAndNegative(Integer[] arr, int n) {
        int negativePointer = 0;
        // All positive on right and negative and Zero on left side
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[negativePointer];
                arr[negativePointer] = temp;
                negativePointer++;
            }
        }
        // return count of negative nos
        return negativePointer;
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
