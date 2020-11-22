package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Longest_Palindrome_in_a_String {
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
            String res = getLongestPalindromeInString(str);
            System.out.println(res);
        }
    }

    private static String getLongestPalindromeInString(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0, strt = 0;
        char[] strArr = str.toCharArray();

        //all substring of length 1 will be palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        //all substring of length 2 will be palindrome
        for (int i = 0; i < n - 1; i++) {
            if (strArr[i] == strArr[i + 1]) {
                dp[i][i + 1] = true;
                if (maxLength < i + 1 && maxLength < 2) { //need to pick first substring
                    strt = i;
                }
                maxLength = 2;
            }
        }

        //all remaining length
        for (int subStrLen = 3; subStrLen <= n; subStrLen++) { //substring selector
            for (int l = 0; l < n - subStrLen + 1; l++) { //String point
                int r = l + subStrLen - 1;
                if (strArr[l] == strArr[r] && dp[l + 1][r - 1]) {
                    dp[l][r] = true;
                    if (subStrLen > maxLength) { //if conflict, pick latest one
                        strt = l;
                        maxLength = subStrLen;
                    }
                }
            }
        }


        return str.substring(strt,strt + maxLength);
    }
}
