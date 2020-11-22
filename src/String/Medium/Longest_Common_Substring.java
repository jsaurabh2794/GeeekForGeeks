package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Longest_Common_Substring {
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
            int m = input.nextInt();
            int n = input.nextInt();
            String str1 = input.next();
            String str2 = input.next();
            int maxLen = longestCommonSubSequence(str1.toCharArray(), str2.toCharArray(), m, n);
            System.out.println(maxLen);
        }
    }

    /*Algorithm:
     * for any i,j->
     *               if lcs[i][j] = 1 + lcs[i-1][j-1] if strA[i] == strB[j]
     *               else
     *                  lcs[i][j] = 0
     * */

    private static int longestCommonSubSequence(char[] strA, char[] strB, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //in first row and first column, all will be zero
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (strA[i - 1] == strB[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(dp[i][j], result);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }
}
