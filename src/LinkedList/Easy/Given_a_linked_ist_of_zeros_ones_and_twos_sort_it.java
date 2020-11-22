package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Given_a_linked_ist_of_zeros_ones_and_twos_sort_it {

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
            Node resultHead = sortLinkedListOfZeroOneTwo(head);
            display(resultHead);
        }
    }

    private static Node sortLinkedListOfZeroOneTwo(Node head) {
        Node zero = null, zeroHead = null, one = null, oneHead = null, two = null, twoHead = null;
        while (head != null) {
            int data = head.data;
            if (data == 0) {
                if (zero == null) {
                    zero = new Node(data);
                    zeroHead = zero;
                } else {
                    zero.next = new Node(data);
                    zero = zero.next;
                }
            } else if (data == 1) {
                if (one == null) {
                    one = new Node(data);
                    oneHead = one;
                } else {
                    one.next = new Node(data);
                    one = one.next;
                }
            } else {
                if (two == null) {
                    two = new Node(data);
                    twoHead = two;
                } else {
                    two.next = new Node(data);
                    two = two.next;
                }
            }
            head = head.next;
        }
        Node toReturn;
        if (zeroHead != null) {
            zero.next = (oneHead != null) ? oneHead : twoHead;
            if (oneHead != null) {
                one.next = twoHead;
            }
            toReturn = zeroHead;
        } else if (oneHead != null) {
            one.next = twoHead != null ? twoHead : null;
            toReturn = oneHead;
        } else {
            toReturn = twoHead;
        }
        return toReturn;
    }

    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");
    }
}
