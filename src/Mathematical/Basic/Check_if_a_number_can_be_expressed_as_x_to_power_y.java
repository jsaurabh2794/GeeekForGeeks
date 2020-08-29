package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Check_if_a_number_can_be_expressed_as_x_to_power_y {
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
            int res = checkNumber(n);
            System.out.println(res);
        }
    }

    private static int checkNumber(int n) {
        double powerOf2 = Math.log10(n) / Math.log10(2);
        double powerOf3 = Math.log10(n) / Math.log10(3);
        double powerOf5 = Math.log10(n) / Math.log10(5);
        double powerOf6 = Math.log10(n) / Math.log10(6);
        double powerOf10 = Math.log10(n) / Math.log10(10);
        double powerOf7 = Math.log10(n) / Math.log10(7);
        if ((powerOf2 > 1 && powerOf2 == (int) powerOf2) ||
                (powerOf3 > 1 && powerOf3 == (int) powerOf3) ||
                (powerOf5 > 1 && powerOf5 == (int) powerOf5) ||
                (powerOf7 > 1 && powerOf7 == (int) powerOf7) ||
                (powerOf6 > 1 && powerOf6 == (int) powerOf6) ||
                (powerOf10 > 1 && powerOf10 == (int) powerOf10)) {
            return 1;
        }
        return 0;
    }
}
