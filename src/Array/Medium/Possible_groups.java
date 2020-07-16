package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Possible_groups {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            long grpCount = getPossibleGroups(arr, n);
            System.out.println(grpCount);
        }
    }

    private static long getPossibleGroups(int[] arr, int n) {
        int[] remainder = new int[3];
        for (int i = 0; i < n; i++) {
            remainder[arr[i] % 3]++;
        }
        long remainder_zero_count = remainder[0], remainder_one_count = remainder[1], remainder_two_count = remainder[2];
        // Group of 2 nos, both with remainder 0 will pick 2 ie nc2
        long pair = ((remainder_zero_count) * (remainder_zero_count - 1)) / 2 + (remainder_one_count * remainder_two_count);
        // Group of 3 nos, All three can be of ramainder 0, 1 or 2 (nc3 = n!/ r! (n-r)!)
        long tri = ((remainder_zero_count) * (remainder_zero_count - 1) * (remainder_zero_count - 2)) / 6 + ((remainder_one_count) * (remainder_one_count - 1) * (remainder_one_count - 2)) / 6 + ((remainder_two_count) * (remainder_two_count - 1) * (remainder_two_count - 2)) / 6 + (remainder_one_count * remainder_two_count * remainder_zero_count);
        return pair + tri;
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
