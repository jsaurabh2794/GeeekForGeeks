package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Replace_by_X {
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
            String pattern = input.next();
            String res = doReplaceContinousPatternByX(string, pattern);
            System.out.println(res);
        }
    }

    /*
    * we will start from left and keep matching the chars and will count the matching pattern
    * if count of matching pattern is greater than 0, will add 'X' in StringBuilder
    * if any substring partially matches, will copy all chars till current char to StringBuilder
    * and will reset everything
    * */


    private static String doReplaceContinousPatternByX(String string, String pattern) {
        int patternPointer = 0;
        int stringPointer = 0;
        int indexFromWhereMatchingStarts = 0;
        StringBuilder sb = new StringBuilder("");
        int continousCount = 0;

        while (stringPointer < string.length()) {

            while (stringPointer < string.length() &&
                    patternPointer < pattern.length() &&
                    string.charAt(stringPointer) == pattern.charAt(patternPointer)) {
                stringPointer++;
                patternPointer++;
                if (patternPointer == pattern.length()) { // it matched
                    patternPointer = 0;
                    continousCount++; // setting the count
                    indexFromWhereMatchingStarts = stringPointer; //One Match Done
                }
            }
            if (continousCount > 0) {
                sb.append("X");
            }
            if (patternPointer > 0) { // if pattern partially matches, need to add that chars into list, so we will add all chars after the last point match to till string pointer
                stringPointer = indexFromWhereMatchingStarts;
            }
            putAllCharsFrom(sb, indexFromWhereMatchingStarts, stringPointer + 1, string);
            patternPointer = 0;
            continousCount = 0;
            stringPointer++;
            indexFromWhereMatchingStarts = stringPointer;
        }


        return sb.toString();
    }

    private static void putAllCharsFrom(StringBuilder sb, int k, int stringPointer, String string) {
        for (int i = k; i < stringPointer && i < string.length(); i++) {
            sb.append(string.charAt(i));
        }
    }
}
