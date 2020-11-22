package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Linked_List_in_Zig_Zag_fashion {
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
            Node res = convertLinkedListInZigZagFashion(head);
            display(res);
        }
    }

    private static Node convertLinkedListInZigZagFashion(Node head) {
        int count = 0;
        Node start = head;
        while (start != null && start.next != null) {
            int currData = start.data;
            int nextData = start.next.data;
            if (count % 2 == 0) {
                if (currData > nextData) {
                    swapData(start, currData, nextData);
                }
            } else {
                if (currData < nextData) {
                    swapData(start, currData, nextData);
                }
            }
            start = start.next;
            count++;
        }
        return head;
    }

    private static void swapData(Node start, int currData, int nextData) {
        start.data = nextData;
        start.next.data = currData;
    }

    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");
    }
}
