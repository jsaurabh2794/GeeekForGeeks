package LinkedList.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Intersection_Point_in_Y_Shapped_Linked_Lists {
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
        Node common = new Node(15);
        common.next = new Node(30);
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = common;
        Node head2 = new Node(10);
        head2.next = common;
        int res = getIntersectionPoint(head1, head2);
        System.out.println(res);
    }

    private static int getIntersectionPoint(Node head1, Node head2) {
        int cH1 = nodeCount(head1);
        int cH2 = nodeCount(head2);
        int diff = Math.abs(cH1 - cH2);
        Node shiftedHead;
        if (cH1 > cH2) {
            shiftedHead = shift(head1, diff);
            return commonNode(shiftedHead, head2);
        } else {
            shiftedHead = shift(head2, diff);
            return commonNode(shiftedHead, head1);
        }
    }

    private static int commonNode(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }

    private static Node shift(Node head, int difference) {
        int c = 0;
        while (c < difference) {
            head = head.next;
            c++;
        }
        return head;
    }

    private static int nodeCount(Node head) {
        Node temp = head;
        int c = 0;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }
}
