package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Add_one_to_a_number_represented_as_linked_list {
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
            Node res = addOneNumberAndReturnLinkedList(head);
            printLinkedList(res);
        }
    }

    private static Node addOneNumberAndReturnLinkedList(Node head) {
        //To add one from  right side, need to reverse it
        Node newHead = doReverseSingleLinkedList(head); // reverse the list
        int carry = 1; //add one from left side and move carry ahead
        Node newLinkedList = null, head2 = null;
        while (newHead != null) {
            int sum = newHead.data + carry;
            carry = sum / 10;
            if (newLinkedList == null) {
                Node n = new Node(sum % 10);
                newLinkedList = n;
                head2 = newLinkedList;
            } else {
                newLinkedList.next = new Node(sum % 10);
                newLinkedList = newLinkedList.next;
            }
            newHead = newHead.next;
        }
        if (carry > 0) { // if carry is still there add one extra node
            Node node = new Node(carry);
            newLinkedList.next = node;
        }
        Node head3 = doReverseSingleLinkedList(head2); // finally reverse it again so it will go in original form
        return head3;
    }

    private static Node doReverseSingleLinkedList(Node head) {
        Node curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }

}
