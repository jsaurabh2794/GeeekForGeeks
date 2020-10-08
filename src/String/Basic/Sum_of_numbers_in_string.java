package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_of_numbers_in_string {
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
            String str = input.next();
            long sum = doSumOfNumbersInString(str);
            System.out.println(sum);
        }
    }

    private static long doSumOfNumbersInString(String str) {
        long sum = 0;
        int i = 0;
        for (; i < str.length(); ) {
            int t = str.charAt(i);
            long tempSum = 0;
            while (i < str.length() && (t >= 65 && t <= 90) || (t >= 97 && t <= 122)) { //if Character is there will skip it
                i++;
                if (i < str.length()) {
                    t = str.charAt(i);
                } else {
                    break;
                }
            }

            while (i < str.length() && (t >= 48 && t <= 57)) {
                int digit = Character.getNumericValue(str.charAt(i));
                tempSum = tempSum * 10 + digit;
                i++;
                if (i < str.length()) {
                    t = str.charAt(i);
                } else {
                    break;
                }
            }
            sum += tempSum;
        }
        return sum;
    }
}
