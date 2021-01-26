package Stack.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sort_a_stack {
    static class Reader {
        BufferedReader buffer;
        StringTokenizer st;

        Reader() {
            buffer = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(buffer.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        public static void main(String[] args) {
            Reader reader = new Reader();
            int testCase = reader.nextInt();
            while (testCase-- > 0) {
                int n = reader.nextInt();
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < n; i++) {
                    stack.push(reader.nextInt());
                }
                Stack<Integer> ns = sortTheStack(stack);
                display(ns);
            }
        }

        private static Stack<Integer> sortTheStack(Stack<Integer> stack) {
            if (!stack.isEmpty()) {
                int temp = stack.pop();
                sortTheStack(stack);
                insertInto(stack, temp);
            }
            return stack;
        }

        private static void insertInto(Stack<Integer> stack, int element) {
            if (stack.isEmpty() || stack.peek() < element) {
                stack.push(element);
            } else {
                int temp = stack.pop();
                insertInto(stack, element);
                stack.push(temp);
            }
        }
        private static void display(Stack<Integer> ns) {
            while (!ns.isEmpty()) {
                System.out.print(ns.pop() + " ");
            }
        }
    }
}
