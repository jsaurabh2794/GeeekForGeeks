package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class K_Pangrams {
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
            long n = input.nextLong();
            boolean b = isKPnagrams(str, n);
            System.out.println(b ? "1" : "0");
        }
    }

    private static boolean isKPnagrams(String str, long n) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            hashMap.put(Character.toLowerCase(c), hashMap.getOrDefault(Character.toLowerCase(c), 0) + 1);
        }
        int uniqueCharCount = hashMap.size();
        int remainingCharReq = 26 - uniqueCharCount;
        int remainingLength = str.length() - uniqueCharCount;

        return remainingCharReq <= n && remainingLength >= remainingCharReq; // because k modification is req  so remaining length should be greater than or equal to remaining char
    }
}
