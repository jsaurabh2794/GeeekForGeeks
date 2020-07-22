package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Consecutive_1s_not_allowed {
    static final int OUTPUT = 1000000007;
    static BigInteger[] fib = new BigInteger[101];

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger c;
        for (int i = 1; i <= 100; i++) {
            c = a.add(b);
            fib[i] = (c.mod(BigInteger.valueOf(OUTPUT)));
            a = b;
            b = c;
        }
        while (testCase-- > 0) {
            int n = input.nextInt();
            getNumberOfStringWhichDoesNotHaveConsecutive1s(n);
            System.out.println();
        }
    }

    /*Imp*/
    private static void getNumberOfStringWhichDoesNotHaveConsecutive1s(int n) {
        System.out.print(fib[n]);
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

