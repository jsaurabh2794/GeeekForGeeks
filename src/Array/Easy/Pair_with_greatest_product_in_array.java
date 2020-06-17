package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pair_with_greatest_product_in_array {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextLong();
            }
            long res = pairWithGreatestProduct(arr, n);
            //long res = pairWithGreatestProductV1(arr, n);
            System.out.println(res);
        }
    }

    private static long pairWithGreatestProduct(Long[] arr, int n) {
        HashMap<Long, Integer> elementWithFreq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (elementWithFreq.containsKey(arr[i])) {
                int temp = elementWithFreq.get(arr[i]);
                elementWithFreq.put(arr[i], temp + 1);
            } else {
                elementWithFreq.put(arr[i], 1);
            }
        }

        Arrays.sort(arr); // sorted to get greatest product, and will traverse from end

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i && arr[j] <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % arr[j] == 0) {
                    long result = arr[i] / arr[j]; /* result * arr[j] == hashed data means its there*/
                    // pair must be from different indices
                    if (result != arr[j] && result != arr[i] && elementWithFreq.containsKey(result)) {
                        return arr[i];
                    } else if (result == arr[j] && elementWithFreq.containsKey(result) && elementWithFreq.get(result) > 1) { // if more than number is there with same no, 4/2=2 then both 2 shd be different
                        return arr[i];
                    }
                }
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

        Long nextLong() {
            return Long.parseLong(next());
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
