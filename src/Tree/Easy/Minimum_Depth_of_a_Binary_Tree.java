package Tree.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Depth_of_a_Binary_Tree {
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

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(4);
        System.out.println(getMinimumDepth(root));
    }

    //Iterative
    private static int getMinimumDepth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int minHeight = 0;
        while (!queue.isEmpty()) {
            int noOfNodes = queue.size();
            minHeight++;
            while (noOfNodes-- > 0) {
                Node tempNode = queue.poll();
                if (tempNode.left == null && tempNode.right == null) {
                    return minHeight;
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return minHeight;
    }
}
