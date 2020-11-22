package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Remove_duplicates_from_an_unsorted_linked_list {

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
                    node = node.next;
                }
            }
            Node resultHead = removeDuplicatesFromAnUnsortedLinkedList(head);
            display(resultHead);
        }
    }

    private static Node removeDuplicatesFromAnUnsortedLinkedList(Node head) {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(head.data);
        Node start = head;
        while (start.next != null) {
            int data = start.next.data;
            if (integerSet.contains(data)) {
                start.next = start.next.next;
            } else {
                integerSet.add(data);
                start = start.next;
            }
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
