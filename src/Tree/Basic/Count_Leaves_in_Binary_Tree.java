package Tree.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Count_Leaves_in_Binary_Tree {
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
            int n = countNoOfLeavesInIterativeWay(root);
            System.out.println("No of Leaf Nodes are:" + n);
        }

        /*Recursive*/
        private static int countLeavesNode(Node root) {
            int count = 0;
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            count += countLeavesNode(root.left) + countLeavesNode(root.right);
            return count;
        }

        /*Iterative Way, Level Order Traversal*/
        private static int countNoOfLeavesInIterativeWay(Node node) {
            int count = 0;
            Queue<Node> lotQueue = new LinkedList<>();
            lotQueue.add(node); // add root node

            // do level order traversal;
            while (!lotQueue.isEmpty()) {
                Node tempNode = lotQueue.poll();
                if (tempNode.left != null) {
                    lotQueue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    lotQueue.add(tempNode.right);
                }

                if (tempNode.left == null && tempNode.right == null) {
                    count++;
                }
            }
            return count;
        }
    }
}
