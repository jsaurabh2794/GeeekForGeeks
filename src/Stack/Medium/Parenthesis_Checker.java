package Stack.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Parenthesis_Checker {
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
            boolean res = paranthesisChecker(str);
            System.out.println(res);
        }
    }

    private static boolean paranthesisChecker(String str) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                characterStack.add(c);
            } else {
                if (c == ')' && (characterStack.isEmpty() || characterStack.peek() != '(')) {
                    return false;
                } else if (c == '}' && (characterStack.isEmpty() || characterStack.peek() != '{')) {
                    return false;
                } else if (c == ']' && (characterStack.isEmpty() || characterStack.peek() != '[')) {
                    return false;
                }
                characterStack.pop();
            }
        }
        return true;
    }
}
