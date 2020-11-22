package LinkedList.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Implement_Stack_using_Linked_List {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

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
            Node top = null;
            int n = input.nextInt();
            while (n-- > 0) {
                int queryType = input.nextInt();
                if (queryType == 1) {
                    top = push(top, input.nextInt());
                } else if (queryType == 2) {
                    top = pop(top);
                }

            }
        }
    }

    private static Node pop(Node top) {
        if (top == null) {
            System.out.print(-1+" ");
        }
        int d = top.data;
        top = top.next;
        System.out.print(d+" ");
        return top;
    }

    private static Node push(Node top, int a) {
        if (top == null) {
            top = new Node(a);
        } else {
            Node newNode = new Node(a);
            newNode.next = top; //Adding first position always
            top = newNode;
        }
        return top;
    }

}

