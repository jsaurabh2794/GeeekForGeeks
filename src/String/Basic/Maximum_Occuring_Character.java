package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Maximum_Occuring_Character {
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
            getMaximumOccuringCharacter(str);
            System.out.println();
        }
    }

    private static void getMaximumOccuringCharacter(String str) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            characterIntegerMap.put(key, characterIntegerMap.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        char c = 'z' + 1;

        for (char c1 : characterIntegerMap.keySet()) {
            int tempCount = characterIntegerMap.get(c1);
            if (tempCount > count) {
                c = c1;
                count = tempCount;
            } else if (tempCount == count) {
                if (c1 < c) {
                    c = c1;
                }
            }
        }
        System.out.print(c);
    }
}
