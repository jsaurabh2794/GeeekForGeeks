package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Count_the_characters {
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
            int n = input.nextInt();
            int res = getCOuntOfCharWhoOccursNTimes(str, n);
            System.out.println(res);
        }
    }

    private static int getCOuntOfCharWhoOccursNTimes(String str, int n) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        charCount.put(str.charAt(0), 1);
        for (int i = 1; i < str.length(); i++) {
            char key = str.charAt(i);
            if (str.charAt(i - 1) == key) {
                continue;
            } else {
                charCount.put(key, charCount.getOrDefault(key, 0) + 1);
            }
        }
        int eligibleCharCount = 0;
        for (char c : charCount.keySet()) {
            Integer count = charCount.get(c);
            if (count == n) {
                eligibleCharCount++;
            }
        }
        return eligibleCharCount;
    }
}
