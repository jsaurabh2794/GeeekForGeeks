package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reverse_words_in_a_given_string {
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
            reverseWordsInGivenString(str);
            System.out.println();
        }
    }

    private static void reverseWordsInGivenString(String str) {
        String[] strings = str.split("\\.");
        StringBuilder builder = new StringBuilder("");
        for (int i = strings.length - 1; i >= 0; i--) {
            builder.append(strings[i]);
            if (i > 0) {
                builder.append(".");
            }
        }
        System.out.print(builder);
    }
}
