package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Print_the_Kth_Digit {
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
            int a = input.nextInt();
            int b = input.nextInt();
            int n = input.nextInt();
            findKthDigit(a, b, n);
            System.out.println();
        }
    }

    private static void findKthDigit(int a, int b, int n) {
        long pow = (long) Math.pow(a, b);
        int count = 0;
        long digit = 0;
        while (pow > 0 && n > count) {
            count++;
            digit = pow % 10;
            if (count == n) {
                break;
            }
            pow = pow / 10;
        }
        System.out.print(digit);
    }
}
