package Array.Medium;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Max_sum_in_the_configuration {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int maxSum = maxSumInConfig(arr, n);
            System.out.println(maxSum);
        }
    }

    // 8 3 1 2
    private static int maxSumInConfig(Integer[] arr, int n) {
        int maxSum = 0;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += arr[i] * i;
            totalSum += arr[i];
        }
        int currSum = maxSum;
        for (int i = 0; i < n; i++) {
            // Send first element to last and shift all element to left
            // (arr[i] * n - 1) ---> First Element to last
            // (totalSum - arr[i]) ---> Shift All Element left will Decrease the sum
            currSum = (currSum + (arr[i] * (n - 1))) - (totalSum - arr[i]);
            maxSum = Math.max(currSum, maxSum);
        }


        return maxSum;
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
