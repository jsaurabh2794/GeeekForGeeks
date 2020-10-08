package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Good_or_Bad_string {
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
            int res = isGoodOrBad(str);
            System.out.println(res);
        }
    }

    private static int isGoodOrBad(String str) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int vowelsCount = 0;
        int consonentCount = 0;

        //aeioup??
        for (char c : str.toCharArray()) {
            if (vowels.contains(c)) {
                vowelsCount++;
                consonentCount = 0;
            } else if (c == '?') { // if its ?, it can appear for both consonent and vowel
                vowelsCount++;
                consonentCount++;
            } else {
                consonentCount++;
                vowelsCount = 0;
            }

            if (vowelsCount > 5 || consonentCount > 3) {
                return 0;
            }
        }

        return 1;
    }
}
