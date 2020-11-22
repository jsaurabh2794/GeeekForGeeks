package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Check_if_Linked_List_is_Palindrome {

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
            boolean res = checkIfLinkedListIsPalindrome(head);
            System.out.println(res ? "1" : "0");
        }
    }

    private static boolean checkIfLinkedListIsPalindrome(Node head) {
        if (head == null || head.next == null){
            return false;
        }
        Node head1 = head , head2 = null;

        //Get the Middle of LinkedList Node 1 2 1, 1 2 3 4, 1 2 3 4 5
        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow; // Store the Prev Node of Slow Node
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) // no of elements will be odd
        {
          head2 = slow.next;
        }else { // even no will be there
            head2 = prev.next; // 2nd part
        }
        prev.next = null;
        Node newHead2 = doReverse(head2);
        return compare(head1,newHead2);
    }

    private static boolean compare(Node h1, Node h2) {
        while (h1 != null && h2 != null){
            if(h1.data != h2.data){
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    private static Node doReverse(Node head2) {
        Node curr = head2, next, prev = null;
        while (curr != null){
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
