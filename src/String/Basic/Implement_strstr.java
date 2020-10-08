package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Implement_strstr {
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
            String str1 = input.next();
            String str2 = input.next();
            isStr2PresentInStr1(str1, str2);
            System.out.println();
        }
    }

    private static void isStr2PresentInStr1(String str1, String str2) {
        int index = -1;
        int pStr1 = 0;
        int pStr2 = 0;
        while (pStr1 < str1.length() && pStr2 < str2.length()) {
            if (str1.charAt(pStr1) == str2.charAt(pStr2)) {
                if (index == -1) {
                    index = pStr1;
                }
                pStr1++;
                pStr2++;
            } else {
                pStr2 = 0;
                index = -1;
                pStr1++;
            }
        }
        System.out.print(pStr2 == str2.length() ? index : "-1");
    }
}
