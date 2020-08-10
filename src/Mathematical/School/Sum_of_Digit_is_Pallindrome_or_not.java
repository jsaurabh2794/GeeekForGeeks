package Mathematical.School;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_of_Digit_is_Pallindrome_or_not {
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
            boolean res = sumOfDigitIsPalindromeOrNot(a);
            System.out.println(res ? "YES" : "NO");
        }
    }

    private static boolean sumOfDigitIsPalindromeOrNot(int a) {
        int sumOfDigit = 0;
        while (a > 0) {
            sumOfDigit += a % 10;
            a = a / 10;
        }
        if (!String.valueOf(sumOfDigit).equals(new StringBuffer(sumOfDigit+"").reverse().toString())) {
            return false;
        }
        return true;
    }
}
