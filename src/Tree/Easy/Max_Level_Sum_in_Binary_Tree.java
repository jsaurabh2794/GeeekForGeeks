package Tree.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Max_Level_Sum_in_Binary_Tree {
    static int maxLevelSum = 0;

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
        System.out.println(getSum(root));
    }


    static int getSum(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        maxLevelSum = root.data;// initialize with first data, cant set to zero by default. it can be negative
        while (!levelQueue.isEmpty()) {
            int noOfNodesInCurrentLevel = levelQueue.size();
            int tempSum = 0;
            while (noOfNodesInCurrentLevel-- > 0) {
                Node poppedNode = levelQueue.poll();
                tempSum += poppedNode.data;
                if (poppedNode.left != null) {
                    levelQueue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    levelQueue.add(poppedNode.right);
                }
            }
            maxLevelSum = Math.max(maxLevelSum, tempSum);
        }
        return maxLevelSum;
    }
}
