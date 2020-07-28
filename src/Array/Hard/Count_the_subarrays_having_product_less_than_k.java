package Array.Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*Imp*/ /*Good Question*/
public class Count_the_subarrays_having_product_less_than_k {
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
            long k = input.nextLong();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            countNoOfSubArrayHavingProductLessThanK(arr, n, k);
            System.out.println();
        }
    }

    private static void countNoOfSubArrayHavingProductLessThanK(int[] arr, int n, long k) {
        int finalCount = 0;
        long product = 1;
        int l = 0, r = 0;
        while (r < n) {
            product *= arr[r];
            if (product < k) {
                finalCount += (1 + (r - l));

            } else {
                while (product >= k && l < r) {
                    product /= arr[l++];
                }
                if (product < k)
                    finalCount += (1 + (r - l)); // cant add blindly... need to check the product
            }
            r++;
        }
        System.out.print(finalCount);
    }

}
