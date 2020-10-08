package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Remove_character {
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
            String str1 = input.next();
            String str2 = input.next();
            removeCharacterWhichisInStr2(str1, str2);
            System.out.println();
        }
    }

    private static void removeCharacterWhichisInStr2(String str1, String str2) {
        StringBuilder sb = new StringBuilder("");
        HashSet<Character> characterHashSet = new HashSet<>();
        for (char c : str2.toCharArray()) {
            characterHashSet.add(c);
        }
        char[] str2Array = str1.toCharArray();
        for (int i = 0; i < str2Array.length; i++) {
            if (!characterHashSet.contains(str2Array[i])) {
                sb.append(str2Array[i]);
            }
        }
        System.out.print(sb);
    }
}
