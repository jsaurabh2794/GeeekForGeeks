package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Longest_Sub_Array_with_Sum_K {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int length = getLongestSubarrayWithSumK(arr, k);
            System.out.println(length);
        }
    }

    private static int getLongestSubarrayWithSumK(int[] arr, int k) {
        // HashMap to Store Accumulative Sum
        long sum = 0;
        int longestSubarrayLen = 0;
        HashMap<Long, Integer> elementWithIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                longestSubarrayLen = i + 1;
            }
            // if sum is not present in hashmap then add it, so will use in future to get max length
            if (!elementWithIndex.containsKey(sum)) {
                elementWithIndex.put(sum, i);
            }

            if (elementWithIndex.containsKey(sum - k)) {
                int index = elementWithIndex.get(sum - k);
                if (longestSubarrayLen < (i - index)) {
                    longestSubarrayLen = i - index;
                }
            }

        }
        return longestSubarrayLen;
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
