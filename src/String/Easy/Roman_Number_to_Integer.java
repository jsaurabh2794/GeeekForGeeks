package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Roman_Number_to_Integer {
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
            long l = convertRomanToInteger(str);
            System.out.println(l);
        }
    }

    private static long convertRomanToInteger(String str) {
        char[] charArray = str.toCharArray();
        long res = 0;
        for (int i = 0; i < charArray.length; i++) {
            int t = getInteger(charArray[i]);
            if (i + 1 < charArray.length) {
                int tNext = getInteger(charArray[i + 1]);
                if (t >= tNext) { // VI -> +5
                    res += t;
                } else { // IV --> +5-1, XC--> -10+100
                    res = (res + getInteger(charArray[i + 1])) - t;
                    i++;
                }
            } else {
                res += getInteger(charArray[i]);
            }

        }
        return res;
    }

    private static int getInteger(char c) {
        int res = 0;
        switch (c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
        }
        return res;
    }
}
