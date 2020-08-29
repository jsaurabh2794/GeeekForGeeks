package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reverse_Bits {
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
            doReverseBit(n);
            System.out.println();
        }
    }

    private static void doReverseBit(int n) {
        long s = 0;
        int bitPosition = 31;
        StringBuilder sb = new StringBuilder("");
        while (n >= 1) {
            sb.append(n % 2);
            n /= 2;
        }
        for (int i = 0; i < sb.length(); i++) {
            s += Character.getNumericValue(sb.charAt(i)) * Math.pow(2, bitPosition--);
        }
        System.out.print(s);
    }
}
