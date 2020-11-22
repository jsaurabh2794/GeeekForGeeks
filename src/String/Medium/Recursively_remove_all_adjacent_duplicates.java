package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursively_remove_all_adjacent_duplicates {
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
            String str1 = removeAllAdjacentRecusively(str, 0, 1);
            System.out.println(str1);
        }
    }

    private static String removeAllAdjacentRecusively(String str, int curr, int next) {
        if (curr < str.length() && next < str.length()) {
            if (str.charAt(curr) == str.charAt(next)) {
                return removeAllAdjacentRecusively(str, curr, next + 1);
            } else {
                String newStr = str.substring(0, curr+1) + str.substring(next);
                return removeAllAdjacentRecusively(newStr, next, next+1);
            }
        }
        return str;
    }
}
