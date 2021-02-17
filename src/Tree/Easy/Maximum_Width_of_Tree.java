package Tree.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width_of_Tree {
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
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.right = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        System.out.println(getMaximumWidthOfTree(root));
    }

    private static int getMaximumWidthOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        int maxWidth = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int nodeAtCurrentLevel = queue.size();
            if (maxWidth < nodeAtCurrentLevel) {
                maxWidth = nodeAtCurrentLevel;
            }
            while (nodeAtCurrentLevel-- > 0) {
                Node poppedNode = queue.poll();
                if (poppedNode.left != null) {
                    queue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    queue.add(poppedNode.right);
                }
            }
        }
        return maxWidth;
    }
}
