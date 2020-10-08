package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Reverse_each_word_in_a_given_string {
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
            reverseEachWord(str1);
            System.out.println();
        }
    }

    private static void reverseEachWord(String str1) {
        StringBuilder sb = new StringBuilder("");
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '.') {
                characterStack.push(str1.charAt(i));
            } else {
                while (!characterStack.isEmpty()) {
                    sb.append(characterStack.pop());
                }
                sb.append('.');
            }
        }
        while (!characterStack.isEmpty()) {
            sb.append(characterStack.pop());
        }
        System.out.print(sb);
    }
}
