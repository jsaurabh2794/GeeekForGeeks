package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Remove_a_and_bc_from_string {
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
            removeaAndbcFromString(str);
            System.out.println();
        }
    }

    private static void removeaAndbcFromString(String str) {
        int strt = 0, p = 0;
        char[] strArray = str.toCharArray();
        int len = strArray.length;
        while (p < len) {
            if (strArray[p] == 'a' && p + 1 < len && strArray[p + 1] == 'c') {
                strArray[p] = '\0';
                strArray[p + 1] = '\0';
                p += 2;
            } else if (strArray[p] == 'b') {
                strArray[p] = '\0';
                p++;
            } else {
                strArray[strt++] = strArray[p];
                if (strt < p || p == str.length() - 1) {
                    strArray[p] = '\0';
                }
                p++;
            }
        }
        System.out.println(strArray);
    }
}
