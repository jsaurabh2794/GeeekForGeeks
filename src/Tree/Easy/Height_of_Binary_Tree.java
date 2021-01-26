package Tree.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Height_of_Binary_Tree {
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
        Node root = new Node(4);
        root.left = new Node(8);
        root.right = new Node(10, new Node(5), new Node(1));
        root.left.left = new Node(7);
        root.left.left.left = new Node(3);
        int h = getHeightOfTreeRecursive(root);
        System.out.println("Recursive Way Height:" + h);
        int h1 = getHeightOfTreeIterative(root);
        System.out.println("Iterative Way Height:" + h1);
    }

    private static int getHeightOfTreeIterative(Node root) {
        int h = 0, noOfNodes;
        if (root == null) {
            return 0;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (true) {
            if (nodeQueue.size() == 0) {
                return h;
            }
            //increase height
            h++;
            noOfNodes = nodeQueue.size(); // it will give no of nodes at current level, we will consider height as plus
            while (noOfNodes-- > 0) { // it will remove all current node and add all nodes of next level.
                Node poppedNode = nodeQueue.poll();
                if (poppedNode.left != null) {
                    nodeQueue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    nodeQueue.add(poppedNode.right);
                }
            }
        }

    }

    private static int getHeightOfTreeRecursive(Node root) {
        int h = 0;
        if (root == null) {
            return 0;
        }
        int lHeight = getHeightOfTreeRecursive(root.left);
        int rHeight = getHeightOfTreeRecursive(root.right);
        h = 1 + Math.max(lHeight, rHeight);
        return h;
    }

}
