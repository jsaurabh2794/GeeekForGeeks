package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Magic_Number {
    public static long MOD = 1000000007;

    static class MyReader {
        BufferedReader input = null;
        StringTokenizer st = null;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            long n = input.nextLong();
            getNthMagicNumber(n);
            System.out.println();
        }
    }

    private static void getNthMagicNumber(long n) {
        long number = 0;
        int pow = 1;
        while (n >= 1) {
            long bit = n % 2;
            number += bit * Math.pow(5, pow);
            pow++;
            n /= 2;
        }
        System.out.print(number % MOD);
    }
}
