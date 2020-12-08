package LinkedList.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Binary_Tree_to_CDLL {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
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
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(2);
        Node head = bTreeToClist(node);
        display(head);
    }


    private static void display(Node head) {
        Node itr = head;
        do {
            System.out.print(itr.data + " ");
            itr = itr.right;
        } while (head != itr);
        System.out.println();
        itr = itr.left;
        do {
            System.out.print(itr.data + " ");
            itr = itr.left;
        } while (head != itr);
        System.out.println(itr.data + " ");
    }

    public static Node bTreeToClist(Node root) {
        List<Integer> elements = new ArrayList<>();
        inorder(root, elements);
        Node head = makeCircularDoubleLinkedList(elements);
        return head;
    }

    private static Node makeCircularDoubleLinkedList(List<Integer> elements) {
        Node first = new Node(elements.get(0));
        Node start = first, prev = first;
        for (int i = 1; i < elements.size(); i++) {
            Node newNode = new Node(elements.get(i));
            newNode.left = prev;
            prev.right = newNode;
            prev = newNode;
        }
        prev.right = first;
        first.left = prev;
        return first;
    }

    private static void inorder(Node root, List<Integer> elements) {
        if (root == null) return;
        inorder(root.left, elements);
        elements.add(root.data);
        inorder(root.right, elements);
    }
}
