package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Find_all_pairs_with_a_given_sum {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int sum = input.nextInt();
            Integer[] arrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = input.nextInt();
            }
            Integer[] arrB = new Integer[m];
            for (int i = 0; i < m; i++) {
                arrB[i] = input.nextInt();
            }
            findAllPairOfGivenSum(arrA, arrB, n, m, sum);
            System.out.println();
        }
    }

    private static void findAllPairOfGivenSum(Integer[] arrA, Integer[] arrB, int n, int m, int sum) {
        Arrays.sort(arrA);
        HashSet<Integer> set = new HashSet<>();
        for (int t : arrB) {
            set.add(t);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int temp = sum - arrA[i];
            if (set.contains(temp)) {
                sb.append(arrA[i] + " " + temp + ", ");
            }
        }
        if (sb.length() > 0) {
            System.out.print(sb.substring(0, sb.lastIndexOf(",")));
        } else {
            System.out.print("-1");
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
