package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Largest_Sum_Subarray_of_Size_at_least_K {

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (input.nextInt());
            }
            int k = input.nextInt();
            getLargestSumSubarrayOfSizeAtleastK(arr, n, k);
            System.out.println();
        }
    }

    private static void getLargestSumSubarrayOfSizeAtleastK(int[] arr, int n, int k) {
        int[] maxSum = new int[n];
        maxSum[0] = arr[0];
        int currMax = arr[0];
        for (int i = 1; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSum[i] = currMax;
        }
        //Calculate K sum
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int result = sum;
        //Sliding Window Protocol
        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k]; // check in all K sized window
            result = Math.max(result, sum);  //checking if this is max or not
            // Include maximum sum till [i-k] also
            // if it increases overall max.
            result = Math.max(result, sum + maxSum[i - k]);
        }
        System.out.print(result);
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
