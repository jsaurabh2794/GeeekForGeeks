package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Merge_two_sorted_linked_lists {

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
            int n = input.nextInt();
            Node node = null, headA = null;
            for (int i = 0; i < n; i++) {
                if (node == null) {
                    node = new Node(input.nextInt());
                    headA = node;
                } else {
                    node.next = new Node(input.nextInt());
                    node = node.next;
                }
            }
            Node node1 = null, headB = null;
            int m = input.nextInt();
            for (int i = 0; i < m; i++) {
                if (node1 == null) {
                    node1 = new Node(input.nextInt());
                    headB = node1;
                } else {
                    node1.next = new Node(input.nextInt());
                    node1 = node1.next;
                }
            }
            Node resultHead = doMergeTwoSortedLinkedList(headA, headB);
            display(resultHead);
        }
    }

    private static Node doMergeTwoSortedLinkedList(Node headA, Node headB) {
        Node start = null, head = null;

        while (headA != null && headB != null) {
            if (headA.data > headB.data) {
                if (start == null) {
                    start = headB;
                    head = start;
                } else {
                    start.next = headB;
                    start = start.next;
                }
                headB = headB.next;
            } else {
                if (start == null) {
                    start = headA;
                    head = start;
                } else {
                    start.next = headA;
                    start = start.next;
                }
                headA = headA.next;
            }
        }

        while (headA != null) {
            start.next = headA;
            start = start.next;
            headA = headA.next;
        }

        while (headB != null) {
            start.next = headB;
            start = start.next;
            headB = headB.next;
        }

        return head;
    }

    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");
    }
}
