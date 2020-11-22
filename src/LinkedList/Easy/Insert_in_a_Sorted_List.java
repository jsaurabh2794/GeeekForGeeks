package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Insert_in_a_Sorted_List {


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
                int key = input.nextInt();
                Node resultHead = insertKeyInSortedList(head, key);
                display(resultHead);
            }
        }

        //25 50 55 60 75 80 , 65
        private static Node insertKeyInSortedList(Node h, int key) {
            Node head = h;
            if (key <= head.data) {
                Node newNode = new Node(key);
                newNode.next = head;
                return newNode;
            }

            while (head != null && head.next != null && key > head.next.data) {
                head = head.next;
            }
            Node b = head.next;
            head.next = new Node(key);
            head.next.next = b;
            return h;
        }

        private static void display(Node resultHead) {
            while (resultHead != null) {
                System.out.print(resultHead.data + "->");
                resultHead = resultHead.next;
            }
            System.out.println("null");
        }
    }
}
