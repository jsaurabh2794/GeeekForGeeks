package String.Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Distinct_palindromic_substrings {
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
            int count = getCountOfPalindromSubstring(str);
            System.out.println(count);
        }
    }

    private static int getCountOfPalindromSubstring(String str) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        StringBuilder stringBuilder;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subStr = str.substring(i, j);
                stringBuilder = new StringBuilder(subStr);
                if (subStr.equals(stringBuilder.reverse().toString()) && !set.contains(subStr)) {
                    set.add(subStr);
                    count++;
                }
            }
        }
        System.out.println(set);
        return count;
    }
}
