package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Count_Palindrome_Sub_Strings_of_a_String {
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
            String str = input.next();
            int count = getCountOfPalindromSubstring(str);
            System.out.println(count);
        }
    }

    private static int getCountOfPalindromSubstring(String str) {
        int count = 0;
        StringBuilder stringBuilder;
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 2; j <= str.length(); j++) {
                String subStr = str.substring(i, j);
                System.out.println(subStr);
                stringBuilder = new StringBuilder(subStr);
                if (subStr.equals(stringBuilder.reverse().toString())) {
                    count++;
                }
            }
        }
        return count;
    }
}
