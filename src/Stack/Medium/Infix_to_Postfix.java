package Stack.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Infix_to_Postfix {
    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String str = input.input.readLine().trim();
            String res = infixToPostFixExpr(str);
            System.out.println(res);
        }
    }

    //"a+b*(c^d-e)^(f+g*h)-i"
    private static String infixToPostFixExpr(String str) {
        Stack<Character> characters = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (char c : str.toCharArray()) {
            //if it lis letter
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            } else if (c == '(') {
                characters.push(c);
            } else if (c == ')') {
                while (!characters.empty() && characters.peek() != '(') {
                    sb.append(characters.pop());
                }
                characters.pop(); // pop for '('
            } else { //Scanned an operator
                while (!characters.isEmpty() && precedence(characters.peek()) >= precedence(c)) {
                    sb.append(characters.pop());
                }
                characters.push(c);
            }
        }
        while (!characters.isEmpty()) {
            sb.append(characters.pop());
        }
        return sb.toString();
    }

    private static int precedence(Character c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
