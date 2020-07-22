package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/
public class Kadanes_Algorithm {
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

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (input.nextInt());
            }
            getContigousMaxSum(arr, n);
            System.out.println();
        }
    }

    private static void getContigousMaxSum(int[] arr, int n) {
        long finalMaxSum = Long.MIN_VALUE;
        long sumTillNow = 0;
        for (int i = 0; i < n; i++) {
            sumTillNow += arr[i];
            if (finalMaxSum < sumTillNow) {
                finalMaxSum = sumTillNow;
            }
            if (sumTillNow < 0) {
                sumTillNow = 0;
            }

        }
        System.out.print(finalMaxSum);
    }

}
