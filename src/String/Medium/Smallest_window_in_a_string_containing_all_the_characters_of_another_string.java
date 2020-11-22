package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/ /*Good*/
public class Smallest_window_in_a_string_containing_all_the_characters_of_another_string {
    final static int MAX = 256;

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
            String string = input.next();
            String text = input.next();
            String str = getSmallestStringWhichContainsAllChars(string, text);
            System.out.println(str);
        }
    }

    //Note: Need to present all character of second str not distinct
    private static String getSmallestStringWhichContainsAllChars(String str, String pat) {
        int[] patternHash = new int[MAX];
        int[] stringHash = new int[MAX];
        int start = 0, count = 0, actualLength = Integer.MAX_VALUE, startStringIndex = -1;

        if (pat.length() > str.length()) {
            return "-1";
        }

        //create hash for pattern
        for (char c : pat.toCharArray()) {
            patternHash[c]++;
        }

        //traverse for all string
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            //add string hash
            stringHash[c]++;

            // need to found window which contains all chars of pattern
            if (patternHash[c] != 0 && stringHash[c] <= patternHash[c]) {
                count++;
            }
            // means window found which contains all chars of pattern
            if (count == pat.length()) {

                while (stringHash[str.charAt(start)] > patternHash[str.charAt(start)] || patternHash[str.charAt(start)] == 0) {
                    if (stringHash[str.charAt(start)] > patternHash[str.charAt(start)]) {
                        stringHash[str.charAt(start)]--;
                    }
                    start++;
                }

                int minLength = i - start + 1;
                if (actualLength > minLength) {
                    actualLength = minLength;
                    startStringIndex = start;
                }
            }
        }
        if (startStringIndex == -1) {
            return "-1";
        }
        return str.substring(startStringIndex, startStringIndex + actualLength);
    }
}
