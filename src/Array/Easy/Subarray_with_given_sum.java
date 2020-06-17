package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Good*/
public class Subarray_with_given_sum {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            long reqSum = input.nextLong();
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextLong();
            }
            subArrayWithGivenSum(arr, n, reqSum);
            System.out.println();
        }
    }

    //1 2 3 7 5 ---> 12
    private static void subArrayWithGivenSum(Long[] arr, int n, long reqSum) {
        int strt = 0, end = 0;
        long sum = arr[0];
        boolean found = false;
        while (strt < n - 1 && end < n - 1) {
            if (sum == reqSum) {
                found = true;
                break;
            }
            end++;
            sum += arr[end];
            while (sum > reqSum && strt < end) {
                sum -= arr[strt++];
                if (sum == reqSum) {
                    found = true;
                    break;
                }
            }
             /*else {
                sum = arr[end];
                strt = end;
            }*/
        }
        if (found) {
            System.out.print((strt + 1) + " " + (end + 1));
        } else {
            System.out.print(-1);
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
