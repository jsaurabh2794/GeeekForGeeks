package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Anagram_Palindrome {
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
            boolean stringPossible = isPalindromStringPossible(str);
            System.out.println(stringPossible ? "Yes" : "No");
        }
    }

    private static boolean isPalindromStringPossible(String str) {
        HashMap<Character, Integer> characterCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }

        int evenCountChar = 0;
        int oddCountChar = 0;

        for (char c : characterCount.keySet()) {
            int temp = characterCount.get(c);
            if (temp % 2 == 0) {
                evenCountChar++;
            } else {
                oddCountChar++;
            }
        }

        if (str.length() % 2 == 0 && oddCountChar == 0) {
            return true;
        } else if (str.length() % 2 != 0 && oddCountChar == 1) {
            return true;
        } else {
            return false;
        }

    }
}
