package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Nth_catalan_number {
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

    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            getNthCatalanNumber(n);
            System.out.println();
        }
    }

    private static void getNthCatalanNumber(int n) {
        //Formula to get Catalan Number
        /*
         *  = 1/(n+1) * 2ncn
         * */
        BigInteger twoNcN = calculateNcR(2 * n, n);
        System.out.print(twoNcN.divide(BigInteger.valueOf(n + 1)));
    }

    private static BigInteger calculateNcR(int n, int r) {
        BigInteger res = new BigInteger("1");
        for (int i = 0; i < r; i++) {
            res = res.multiply(BigInteger.valueOf(n - i));
            res = res.divide(BigInteger.valueOf(i + 1));
        }
        return res;
    }
}
