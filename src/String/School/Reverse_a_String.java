package String.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reverse_a_String {
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
            String revStr = doReverseAString(str);
            System.out.println(revStr);
        }
    }

    private static String doReverseAString(String str) {
        String revStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revStr = revStr + str.charAt(i);
        }
        return revStr;
    }
}
