package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Delete_N_nodes_after_M_nodes_of_a_linked_list {
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
            int M = input.nextInt();
            int N = input.nextInt();
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
            Node resultHead = deleteNnodesAfterMnodes(head, M, N);
            display(resultHead);
        }
    }

    private static Node deleteNnodesAfterMnodes(Node head, int M, int N) {
        Node h1 = head;
        while (head != null && N > 0) {
            int countM = 0, countN = 0;
            while (countM < M - 1 && head != null) { // Skips the M node
                head = head.next;
                countM++;
            }
            Node n;
            if (head != null) {
                n = head.next;
            }else {
                break;
            }
            while (countN < N - 1 && n != null) {
                n = n.next;
                countN++;
            }
            if (n != null) {
                head.next = n.next;
            }else {
                head.next = null;
                break;
            }
            if (head != null) {
                head = head.next;
            }
        }
        return h1;
    }

    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");
    }
}
