package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_of_two_large_numbers {
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
            String x = input.next();
            String y = input.next();
            String sum = doSum(x, y);
            System.out.println(sum);
        }
    }

    private static String doSum(String x, String y) {

        x = getStringAfterRemovalOfLeadingZeros(x);
        y = getStringAfterRemovalOfLeadingZeros(y);

        String res = "";
        int carry = 0;
        int xLen = x.length(), yLen = y.length(), i = xLen - 1, j = yLen - 1;
        while (i >= 0 && j >= 0) {
            int digitX = Character.getNumericValue(x.charAt(i));
            int digitY = Character.getNumericValue(y.charAt(j));
            int tempSum = digitX + digitY + carry;
            res = tempSum % 10 + res;
            carry = tempSum / 10;
            i--;
            j--;
        }

        while (i >= 0) {
            int digitX = Character.getNumericValue(x.charAt(i));
            int tempSum = digitX + carry;
            res = tempSum % 10 + res;
            carry = tempSum / 10;
            i--;
        }
        while (j >= 0) {
            int digitY = Character.getNumericValue(y.charAt(j));
            int tempSum = digitY + carry;
            res = tempSum % 10 + res;
            carry = tempSum / 10;
            j--;
        }

        if (carry != 0) {
            res = carry + res;
        }
        return res;
    }

    private static String getStringAfterRemovalOfLeadingZeros(String str) {
        char[] resArray = str.toCharArray();
        int p = 0,k;
        for (k = 0; k < resArray.length; k++) {
            if (resArray[k] == '0') {
                continue;
            } else {
                break;
            }
        }
        p = k;
        String strnew = str.substring(p);
        return strnew.equals("") ? "0" : strnew;
    }

}
