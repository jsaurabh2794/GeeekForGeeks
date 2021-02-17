package Tree.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Right_View_of_Binary_Tree {
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
        System.out.println(rightView(root));
        getRightViewOfTreeIterative(root);
    }

    static ArrayList<Integer> nodesInRightView;
    static int maxLevel;

    static ArrayList<Integer> rightView(Node node) {
        nodesInRightView = new ArrayList<>();
        maxLevel = -1;
        getRightViewOfTree(node, 0);
        return nodesInRightView;
    }

    //Recursive
    private static void getRightViewOfTree(Node node, int level) {
        if (node == null) {
            return;
        }
        if (maxLevel < level) { // when ever we see level is greater then we will pick right's node data.
            nodesInRightView.add(node.data);
            maxLevel = level; // will update so it will not execute for left subtree if picked data from right subtree.
        }
        getRightViewOfTree(node.right, level + 1);
        getRightViewOfTree(node.left, level + 1);
    }

    //Iterative
    private static void getRightViewOfTreeIterative(Node node) {
        nodesInRightView = new ArrayList<>();
        if (node == null) {
            return;
        }
        Queue<Node> lvlQueue = new LinkedList<>();
        lvlQueue.add(node);
        while (!lvlQueue.isEmpty()) {
            int noOfnodesatCurrentLevel = lvlQueue.size();
            while (noOfnodesatCurrentLevel > 0) { // will pick last node at current level as Right View Nodes
                Node polledNode = lvlQueue.poll();
                if (noOfnodesatCurrentLevel == 1) { // means last node
                    nodesInRightView.add(polledNode.data);
                }
                if (polledNode.left != null) {
                    lvlQueue.add(polledNode.left);
                }
                if (polledNode.right != null) {
                    lvlQueue.add(polledNode.right);
                }
                noOfnodesatCurrentLevel--;
            }
        }
        System.out.println(nodesInRightView);
    }
}
