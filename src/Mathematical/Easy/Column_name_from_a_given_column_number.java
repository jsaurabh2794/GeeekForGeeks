package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Column_name_from_a_given_column_number {
    static char[] LETTERS = {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'};

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
            long n = input.nextLong();
            getColumnNameFromNumber(n);
            System.out.println();
        }
    }

    private static void getColumnNameFromNumber(long n) {
        String sb = new String("");
        while (n >= 1) {
            sb = String.valueOf(LETTERS[(int) n % 26]) + sb;
            if (n % 26 == 0) { //if divisible by 26,decereae n by 1 otherwise next n will be n/26 eg: 52 ANS-> AZ but without n-1, BZ which is wrong, second position is B;
                n = n - 1;
            }
            n /= 26;
        }
        System.out.print(sb);

    }
}
