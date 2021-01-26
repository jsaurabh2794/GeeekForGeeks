package Tree.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minimum_element_in_BST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Reader {
        BufferedReader buffer;
        StringTokenizer st;

        Reader() {
            buffer = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(buffer.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        public static void main(String[] args) {
            Node root = new Node(4);
            root.left = new Node(8);
            root.right = new Node(10, new Node(5), new Node(1));
            root.left.left = new Node(7);
            root.left.left.left = new Node(3);
            int n = getMinimumElementInBST(root);
            System.out.println(n);
        }

        /*Iterative*/
        private static int getMinimumElementInBST(Node root) { // Traverse left subtree of BST un till node's left pointer becomes null. Return node's data finally.
            while (root.left != null) {
                if (root.left != null) {
                    root = root.left;
                }
            }
            return root.data;
        }

        /*Recursive Approach*/
        private static Node getMinimumElementInBSTRecursive(Node root) {
            if (root.left == null) {
                return root;
            }
            return getMinimumElementInBSTRecursive(root.left);
        }
    }
}