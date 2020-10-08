package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Good*/ /*DP*/
public class Longest_Palindromic_Subsequence {
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
            getLongestPalindromeSubSequence(str);
            System.out.println();
        }
    }

    private static void getLongestPalindromeSubSequence(String str) {
        /* DP--> Because it will have similar sub-problems
         * 1. If length is two and both character is same then -> 2
         * 2. if length is more than 2, and first and last character is same then-> 2 + L(i+1,j-1)
         * 3. if length is more than 2, and first and last character is not same then, to get Maximum -> Max(L(i+1,j)&&L(i,J-1))
         * */

        int n = str.length();
        int[][] length = new int[n][n];

        // Single length of one Char -> will be always palindrome
        for (int i = 0; i < n; i++) {
            length[i][i] = 1;
        }

        // will do for remaining, will start of length 2
        for (int subLength = 2; subLength <= n; subLength++) {
            //Now for all sub string of size == subLength need to pick
            for (int strt = 0; strt <= n - subLength; strt++) {
                int end = strt + subLength - 1;
                if (str.charAt(strt) == str.charAt(end) && subLength == 2) { //for length exactly 2, if equal will be 2
                    length[strt][end] = 2;
                } else if (str.charAt(strt) == str.charAt(end)) { //more than 2, if equal then 2 + (remaining in between)
                    length[strt][end] = 2 + length[strt + 1][end - 1];
                } else {
                    length[strt][end] = Math.max(length[strt + 1][end], length[strt][end - 1]); //if (not equal then, will check the max
                }
            }
        }
        System.out.print(length[0][n - 1]);

    }
}
