package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Faltu*/ /*Not Working*/
public class Decode_It {
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
            int k = input.nextInt();
            doDecodeIt(str, k);
            System.out.println();
        }
    }

    private static void doDecodeIt(String str, int k) {
        StringBuilder finalStr = new StringBuilder("");
        StringBuilder temp = new StringBuilder("");
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                int n = Character.getNumericValue(c);
                for (int i = 0; i < n; i++) {
                    finalStr.append(temp);
                }
                temp = new StringBuilder("");
            } else {
                temp.append(c);
            }
        }
        System.out.println(finalStr);
        //System.out.println(finalStr.charAt(k - 1));
    }
}
