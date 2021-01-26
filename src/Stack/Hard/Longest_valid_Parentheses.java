package Stack.Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Longest_valid_Parentheses {
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
            int res = getLongestValidParenThesisV2(str);
            System.out.println(res);
        }
    }

    //O(n) && O(n)
    private static int getLongestValidParenThesis(String str) {
        int maxmLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // if first character is ')', one pop Is required
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    maxmLength = Math.max(maxmLength, i - stack.peek());
                } else {
                    stack.push(i);//Will be used to calculate next longest
                }
            }
        }
        return maxmLength;
    }

    //((()
    private static int getLongestValidParenThesisV2(String str) {
        int maxmLength = 0;
        int leftP = 0, rightP = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftP++;
            } else {
                rightP++;
            }
            if (leftP == rightP) {
                maxmLength = Math.max(maxmLength, 2 * leftP);
            }

            if (leftP < rightP) {
                leftP = rightP = 0;
            }
        }
        leftP = rightP = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(') {
                leftP++;
            } else {
                rightP++;
            }
            if (leftP == rightP) {
                maxmLength = Math.max(maxmLength, 2 * leftP);
            }

            if (leftP > rightP) {
                leftP = rightP = 0;
            }
        }
        return maxmLength;
    }
}
