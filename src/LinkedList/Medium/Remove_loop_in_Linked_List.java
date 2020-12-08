package LinkedList.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Remove_loop_in_Linked_List {
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

    //7 58 36 34 16
    public static void main(String[] args) {
        MyReader input = new MyReader();
        Node head = new Node(7);
        head.next = new Node(58);
        head.next.next = new Node(36);
        head.next.next.next = new Node(34);
        head.next.next.next.next = new Node(16);
        head.next.next.next.next.next = head.next.next;
        doRemoveTheLoopInLinkedList(head);
        display(head);
    }

    private static void doRemoveTheLoopInLinkedList(Node head) {
        Node slow = head, fast = head;
        boolean flag = false;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (flag == false) {
            return; // No Loop in linkedlist
        }
        int loopSize = 1;
        fast = fast.next;
        while (fast != slow) {
            loopSize++; //Counting the loop size
            fast = fast.next;
        }

        //Now Start from head as slow and fast as Loopsize
        slow = head;
        fast = head;
        int tempCountForFastNode = 0;
        while (tempCountForFastNode < loopSize) {
            fast = fast.next;
            tempCountForFastNode++;
        }
        //Now we will increment the node one by one, and it will meet at starting point of loop
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        // Go to one Node Before the Slow Node
        while (fast.next != slow) {
            fast = fast.next;
        }

        // Loop will break one node before the Starting Node of Loop
        fast.next = null; // marking last node next as null, so loop will be removed
    }

    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");
    }
}
