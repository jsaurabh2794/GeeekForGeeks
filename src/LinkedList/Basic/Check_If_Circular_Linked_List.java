package LinkedList.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Check_If_Circular_Linked_List {
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
       /* Integer r1 = new Integer(5);
        Integer r2 = new Integer(5);
        System.out.println(r1 == r2);
        System.out.println(r1.equals(r2));
        System.out.println("sar"=="sar");*/
        while (testCase-- > 0) {
            int n = input.nextInt();
            Node node = null, head = null;
            for (int i = 0; i < n; i++) {
                if (node == null) {
                    node = new Node(input.nextInt());
                    head = node;
                } else {
                    node.next = new Node(input.nextInt());
                    node = node.next;
                }
            }
            boolean res = isLinkedListCircular(head);
            System.out.println(res ? "1" : "0");
        }
    }

    private static boolean isLinkedListCircular(Node head) {

        Node start = head;
        if (head == null) {
            return true;
        }
        head = head.next;
        while (head != null) {
            if (head.equals(start)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
