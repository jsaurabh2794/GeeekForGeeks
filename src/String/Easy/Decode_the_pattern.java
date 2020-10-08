package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Decode_the_pattern {
    static ArrayList<String> strings = new ArrayList<>();

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
        generateThePattern(20);
        while (testCase-- > 0) {
            int n = input.nextInt();
            System.out.println(strings.get(n - 1));
        }
    }

    private static void generateThePattern(int n) {
        String str = "1";
        strings.add(str);
        int count = 1;
        while (count < n) {
            str = getThePattern(str);
            strings.add(str);
            count++;
        }
    }

    private static String getThePattern(String str) {
        int count = 1, i = 1;
        char tempChar = str.charAt(0);
        String res = "";
        for (; i < str.length(); i++) {
            if (str.charAt(i) == tempChar) {
                count++;
            } else {
                res += (count + "" + str.charAt(i - 1));
                count = 1;
                tempChar = str.charAt(i);
            }
        }
        res += (count + "" + str.charAt(i - 1));
        return res;
    }


}
