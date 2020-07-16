package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Longest_subarray_with_sum_divisible_by_K {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (input.nextInt());
            }
            int len = getLongestSubarrayWithSumDivisibleByK(arr, n, k);
            System.out.println(len);
        }
    }

    private static int getLongestSubarrayWithSumDivisibleByK(int[] arr, int n, int k) {
        int len = 0;
        int sum = 0;
        //Key = element % k, value = index
        HashMap<Integer, Integer> elementOfMod = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum % k == 0) {
                len = i + 1;
            }
            // Mode of that element is present in Map or not
            int modeValue = ((sum % k) + k) % k;
            if (!elementOfMod.containsKey(modeValue)) { // To handle negative Mode
                elementOfMod.put(modeValue, i);
            }

            if (elementOfMod.containsKey(modeValue)) {
                int index = elementOfMod.get(modeValue);
                len = Math.max(len, i - index);
            }
        }
        return len;
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
