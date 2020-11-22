package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Longest_Prefix_Suffix {
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
            int n = getLongestPrefixAndSuffix(str);
            System.out.println(n);
        }
    }

    private static int getLongestPrefixAndSuffix(String str) {
        int len = str.length();
        int halfWay = len / 2;

        if (len < 2) {
            return 0;
        }

        for (int i = halfWay; i >= 0; i--) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(len - i, len);

            if ("".equals(prefix) || "".equals(suffix)) {
                return 0;
            }

            if (prefix.equals(suffix)) {
                return prefix.length();
            }
        }
        return 0;
    }
}
