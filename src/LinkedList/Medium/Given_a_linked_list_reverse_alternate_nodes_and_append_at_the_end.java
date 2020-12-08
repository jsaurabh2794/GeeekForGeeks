package LinkedList.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*By Own*/ /*Imp*/
public class Given_a_linked_list_reverse_alternate_nodes_and_append_at_the_end {
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
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.next = new Node(9);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next.next.next = new Node(18);
        display(head);
        reverseAlterNateNodes(head);
        display(head);
    }

    private static void reverseAlterNateNodes(Node head) {
        if (head.next == null || head.next.next == null) { // No Rearrangement can be happen
            return;
        }
        Node even = null, evenHead = null, temp = head;
        while (temp != null && temp.next != null) {
            if (even == null) {
                even = temp.next;
                evenHead = even;
            } else {
                even.next = temp.next;
                even = even.next;
            }
            if (temp.next.next == null) { // if next odd node is not there, set next even node and break
                even.next = temp.next;
                break;
            }
            temp.next = temp.next.next;
            temp = temp.next;
        }
        even.next = null;
        Node newHead = reverse(evenHead);
        temp.next = newHead;
    }

    private static Node reverse(Node head) {
        Node curr = head, prev = null, next = null;
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
