package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Remove_all_duplicates_from_a_given_string_without_util {
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
        Find_largest_word_in_dictionary.MyReader input = new Find_largest_word_in_dictionary.MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String str = input.next();
            String res = removeAllDuplicatesFromAString(str);
            System.out.println(res);
        }
    }

    private static String removeAllDuplicatesFromAString(String str) {
        char[] charArray = str.toCharArray();
        int p = 0;
        int[] hash = new int[256];
        for (int i = 0; i < charArray.length; i++) {
            char c = str.charAt(i);
            if (hash[c] == 1) {
                charArray[i] = '\0';
            } else {
                charArray[p] = c;
                hash[c] = 1;
                if (p < i) {
                    charArray[i] = '\0';
                }
                p++;
            }
        }
        return new String(charArray);
    }
}
