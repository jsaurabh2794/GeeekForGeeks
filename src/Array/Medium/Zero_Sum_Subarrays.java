package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Zero_Sum_Subarrays {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int count = countZeroSumSubArray(arr, n);
            System.out.println(count);
        }
    }

    private static int countZeroSumSubArray(Integer[] arr, int n) {
        int count = 0;
        HashMap<Integer, Integer> sum = new HashMap<>(); // Same Sum We can get at multiple place
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if (currSum == 0) {
                count++;
            }
            if (sum.containsKey(currSum)) {
                count += sum.get(currSum);
            }
            sum.put(currSum, sum.get(currSum) == null ? 1 : sum.get(currSum) + 1);
        }
        return count;
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
