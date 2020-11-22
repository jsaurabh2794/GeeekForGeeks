package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_formation_from_substring {
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
            int len = str.length();
            int n = getLongestPrefixAndSuffix(str);
            System.out.println((n > 0 && len % (len - n) == 0) ? 1 : 0);
        }
    }

    private static int getLongestPrefixAndSuffix(String str) {
        //Using KMP Algorithm, we will create LPS array
        int[] lps = new int[str.length()];
        lps[0] = 0; //first element will always be zero
        int len = 0, j = 1;
        while (j < str.length()) {
            if (str.charAt(len) == str.charAt(j)) { //if matches
                len++;
                lps[j] = len;
                j++;
            } else { //if not matches
                if (len != 0) {
                    len = lps[len - 1]; // will assign one previous index and will try to match with jth char
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
        return lps[str.length() - 1];
    }
}
