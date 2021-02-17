package Tree.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Node_Level {
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
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        System.out.println(getMaximumNodeLevel(root));
    }

    private static int getMaximumNodeLevel(Node root) {
        int maxmNodeLevel = -1, maxmNodes = Integer.MIN_VALUE, level = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            int noOfNodesAtLevel = queue.size();
            if (maxmNodes < noOfNodesAtLevel) {
                maxmNodes = noOfNodesAtLevel;
                maxmNodeLevel = level;
            }
            while (noOfNodesAtLevel-- > 0) {
                Node poppedNode = queue.poll();
                if (poppedNode.left != null) {
                    queue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    queue.add(poppedNode.right);
                }
            }
        }
        return maxmNodeLevel;
    }
}
