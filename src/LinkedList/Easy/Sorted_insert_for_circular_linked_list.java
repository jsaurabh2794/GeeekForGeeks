package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sorted_insert_for_circular_linked_list {
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
            Node node = null, head = null;
            for (int i = 0; i < n; i++) {
                if (node == null) {
                    node = new Node(input.nextInt());
                    head = node;
                } else {
                    node.next = new Node(input.nextInt());
                    if (i < n - 1) {
                        node = node.next;
                    } else {
                        node.next.next = head;
                    }
                }
            }
            int data = input.nextInt();
            Node resultHead = doSortedInsertOfCircularLinkedList(head, data);
            display(resultHead);
        }
    }

    private static Node doSortedInsertOfCircularLinkedList(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node originalHead = head, strt = head, end;
        while (head.next != strt) {
            head = head.next;
        }
        end = head;
        if (data < strt.data) { // First Node is Greater
            Node n = new Node(data);
            n.next = end.next;
            end.next = n;
            originalHead = n;
            return originalHead;
        }
        // From Second Node Ownwards
        while (data > strt.next.data) {
            strt = strt.next;
        }
        Node n = new Node(data);
        n.next = strt.next;
        strt.next = n;

        return originalHead;
    }

    private static void display(Node resultHead) {
        Node b = resultHead;
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
            if (resultHead == b){
                break;
            }
        }
        System.out.println("null");
    }
}
