package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Add_two_numbers_represented_by_linked_lists {
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
            Node node = null, head1 = null, head2 = null;
            for (int i = 0; i < n; i++) {
                if (node == null) {
                    node = new Node(input.nextInt());
                    head1 = node;
                } else {
                    node.next = new Node(input.nextInt());
                    node = node.next;
                }
            }
            int n1 = input.nextInt();
            Node node1 = null;
            for (int i = 0; i < n1; i++) {
                if (node1 == null) {
                    node1 = new Node(input.nextInt());
                    head2 = node1;
                } else {
                    node1.next = new Node(input.nextInt());
                    node1 = node1.next;
                }
            }

            Node resultHead = addTwoNumbersRepresentedByLinkedList(head1, head2);
            display(resultHead);
        }
    }

    private static Node addTwoNumbersRepresentedByLinkedList(Node h1, Node h2) {
        int carry = 0;
        Node head1 = reverse(h1);
        Node head2 = reverse(h2);
        Node head3 = null, result = null;
        while (head1 != null && head2 != null) {
            int sum = head1.data + head2.data + carry;
            if (head3 == null) {
                head3 = new Node(sum % 10);
                result = head3;
            } else {
                head3.next = new Node(sum % 10);
                head3 = head3.next;
            }
            carry = sum / 10;
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1 != null) {
            int sum = carry + head1.data;
            head3.next = new Node(sum % 10);
            head3 = head3.next;
            carry = sum / 10;
            head1 = head1.next;
        }

        while (head2 != null) {
            int sum = carry + head2.data;
            head3.next = new Node(sum % 10);
            head3 = head3.next;
            carry = sum / 10;
            head2 = head2.next;
        }

        if (carry > 0) {
            head3.next = new Node(carry);
        }

        return reverse(result);
    }

    private static Node reverse(Node head) {
        Node curr = head, next, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");
    }

}
