package Stack.Easy;

import java.util.ArrayList;
import java.util.Stack;

public class Print_Bracket_Number {

    public static void main(String[] args) {
        ArrayList<Integer> s = printBracketNumber("(((ezj)f())())t(");
        System.out.println(s);
    }

    static class Parenthesis {
        char c;
        int pos;

        public Parenthesis(char c, int pos) {
            this.c = c;
            this.pos = pos;
        }
    }

    private static ArrayList<Integer> printBracketNumber(String S) {
        ArrayList<Integer> list = new ArrayList<>();
        int curr = 0, max = 0;
        Stack<Parenthesis> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '(' && c != ')') {
                continue;
            }
            if (c == '(') {
                stack.push(new Parenthesis(c, ++curr));
                list.add(curr);
            }
            if (c == ')' && stack.peek() != null && stack.peek().c == '(') {
                list.add(stack.peek().pos);
                stack.pop();
            }
        }
        return list;
    }
}
