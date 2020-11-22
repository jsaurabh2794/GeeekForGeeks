package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Factorials_of_large_numbers {
    static class MyReader {
        BufferedReader input;
        StringTokenizer stringTokenizer;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }
    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            String factorial = factorial(n);
            System.out.println(factorial);
        }
    }

    private static String factorial(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = doMultiply(res, String.valueOf(i));
        }
        return res;
    }

    /*Will perform school time multiplication
     *  111 <-- Multiplicand
     *  *11 <--Multiplier
     * --------
     * 111
     * 11
     * -------
     * 221
     * */
    private static String doMultiply(String multiplicand, String multiplier) {
        String res = "";
        int multiplicandPos = 0, multiplierPos = 0; // where result get added
        int multiplicandLength = multiplicand.length();
        int multiplierLength = multiplier.length();
        int[] result = new int[multiplicandLength + multiplierLength];
        int carry;
        for (int i = multiplierLength - 1; i >= 0; i--) {
            int mutliplierdigit = multiplier.charAt(i) - '0';
            carry = 0;
            multiplicandPos = 0;
            for (int j = multiplicandLength - 1; j >= 0; j--) {
                int multiplicandDigit = multiplicand.charAt(j) - '0';
                int sum = multiplicandDigit * mutliplierdigit + carry + result[multiplierPos + multiplicandPos]; // result[i+multiplicandPos] represents for Ith multiplier the sum will get added
                result[multiplierPos + multiplicandPos] = sum % 10;
                carry = sum / 10;
                multiplicandPos++; // to pick next digit
            }
            // if still carry is there
            if (carry > 0) {
                result[multiplierPos + multiplicandPos] += carry;
            }
            multiplierPos++;
        }


        //Skip zero on right side
        int len = result.length - 1;
        while (len >= 0 && result[len] == 0) {
            len--;
        }

        //Print res from len
        while (len >= 0) {
            res = res + result[len];
            len--;
        }
        return res;
    }


}
