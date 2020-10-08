package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/
public class Wildcard_string_matching {
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
            String pattern = input.next();
            String string = input.next();
            boolean res = isStringMatching(pattern, string);
            System.out.println(res ? "Yes" : "No");
        }
    }

    private static boolean isStringMatching(String pattern, String str) {
        int lengthOfPattern = pattern.length();
        int lengthOfStr = str.length();

        //lookup table top-bottom approach
        boolean[][] lookup = new boolean[lengthOfStr + 1][lengthOfPattern + 1]; // will start from Zero index

        lookup[0][0] = true;

        //empty char can be generated from *, it will depend from prev result. if comes on first row, it will depend on prev result
        for (int j = 1; j <= lengthOfPattern; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];


        // first row and first column will be false, default it is false. because empty char never match with a char

        for (int i = 1; i <= lengthOfStr; i++) {
            char strChar = str.charAt(i - 1);
            for (int j = 1; j <= lengthOfPattern; j++) {
                char patternChar = pattern.charAt(j - 1);
                if (patternChar == '?' || patternChar == strChar) { // it will depend till previous character match result, because one char can be anything
                    lookup[i][j] = lookup[i - 1][j - 1];
                } else if (patternChar == '*') { // it will depend two scenario, one-> if * is at last then, if till prev it matches two-> include last character in string
                    lookup[i][j] = lookup[i - 1][j] || lookup[i][j - 1];
                }
            }

        }
        return lookup[lengthOfStr][lengthOfPattern];
    }
}
