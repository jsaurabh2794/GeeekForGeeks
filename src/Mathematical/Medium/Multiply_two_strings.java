package Mathematical.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiply_two_strings {
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
        Maximum_Profit.MyReader input = new Maximum_Profit.MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String a = input.next();
            String b = input.next();
            String s = doMultiply(a, b);
            System.out.println(s);
        }
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
    private static String doMultiply(String a, String b) {

        int aLength = a.length();
        int bLength = b.length();
        int[] result = new int[aLength + bLength];
        int carry = 0;
        // If any of the number is zero.
        /*if (Integer.parseInt(a) == 0 || Integer.parseInt(b) == 0) {
            return "0";
        } --Cant check like this, number can be very large*/
        //shifting position for a and b
        int aPos = 0;
        int bPos = 0;

        // do Multiplication
        for (int i = a.length() - 1; i >= 0 && a.charAt(i) != '-'; i--) {
            int digitOfMultiplier = a.charAt(i) - '0';
            carry = 0;
            bPos = 0;
            for (int j = b.length() - 1; j >= 0 && b.charAt(j) != '-'; j--) {
                int digitOfMultiplicand = b.charAt(j) - '0';
                //result[aPos + bPos] decides where it will get added
                int sum = (digitOfMultiplicand * digitOfMultiplier) + result[aPos + bPos] + carry;
                carry = sum / 10;
                result[aPos + bPos] = sum % 10;
                bPos++; // to pick next digit from multiplicand
            }
            if (carry > 0) {
                result[aPos + bPos] += carry; // if in last digit, carry is there
            }
            aPos++; //// to pick next digit from multiplicand
        }
        boolean isNegative = false;
        if ((a.charAt(0) == '-' && b.charAt(0) == '-') || (a.charAt(0) != '-' && b.charAt(0) != '-')) {
            isNegative = false;
        } else {
            isNegative = true;
        }

        String res = "";

        //Skip zero on right side
        int len = result.length - 1;
        while (len >= 0 && result[len] == 0){
            len--;
        }

        // if len == -1, means all are zero in result array, means any one or both was zero
        if (len == -1){
            return "0";
        }


        //Print res from len
        while (len >= 0){
            res = res + result[len];
            len--;
        }

        return (isNegative ? "-":"") + res;
    }
}
