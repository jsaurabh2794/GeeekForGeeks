package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Anagram {
    static class Reader {
        BufferedReader input;
        StringTokenizer stringTokenizer;

        public Reader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        int testCase = reader.nextInt();
        while (testCase-- > 0) {
            String strA = reader.next();
            String strB = reader.next();
            boolean anagram = isAnagram(strA, strB);
            System.out.println(anagram ? "YES" : "NO");
        }
    }

    private static boolean isAnagram(String strA, String strB) {
        char[] charArrayA = strA.toCharArray();
        char[] charArrayB = strB.toCharArray();

        Map<Character, Integer> characterCount = new HashMap<>();
        for (char c : charArrayA) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }
        for (char c : charArrayB) {
            if (characterCount.containsKey(c)) {
                Integer t = characterCount.get(c);
                if (t - 1 == 0) {
                    characterCount.remove(c);
                } else {
                    characterCount.put(c, t - 1);
                }
            } else {
                return false;
            }
        }

        return characterCount.isEmpty() ? true:false;
    }
}
