package LinkedList.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/
public class Reverse_a_Linked_List_in_groups_of_given_size {
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        int K = 1;
        Node res = reverseALinkedListInGroup(head, K);
        display(res);
    }

    private static Node reverseALinkedListInGroup(Node head, int k) {
        //Recursive Solution
        Node curr = head, prev = null, next = null;
        int count = 0;
        while (count < k && curr != null) { // it will reverse till kth Node
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        // If Node is still remaining
        if (curr != null) {
            //will append next  reverse list at end of rev list (i.e head)list
            head.next = reverseALinkedListInGroup(curr, k);
        }
        return prev; // will be the starting node
    }

    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");
    }
}
