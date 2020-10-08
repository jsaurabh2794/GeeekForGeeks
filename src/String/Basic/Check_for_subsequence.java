package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Check_for_subsequence {
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
            String str1 = input.next();
            String str2 = input.next();
            boolean res = isStr1IsSubsequenceOfStr2(str1, str2);
            System.out.println(res ? "1" : "0");
        }
    }

    private static boolean isStr1IsSubsequenceOfStr2(String str1, String str2) {
        int pForStr1 = 0;
        int pForStr2 = 0;
        while (pForStr2 < str2.length() && pForStr1 < str1.length()) {
            if (str1.charAt(pForStr1) == str2.charAt(pForStr2)) {
                pForStr1++;
                pForStr2++;
            } else {
                pForStr2++;
            }
        }
        if (pForStr1 == str1.length()) {
            return true;
        }
        return false;
    }
}
