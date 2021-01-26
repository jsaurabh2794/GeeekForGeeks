package Tree.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class K_distance_from_root {
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

    /*
        * 4
         / \
        8  10
       /   / \
      7   5   1
     /
    3
    * */
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(8);
        root.right = new Node(10, new Node(5), new Node(1));
        root.left.left = new Node(7);
        root.left.left.left = new Node(3);
        int k = 2;
        ArrayList<Integer> allNodes = calculateAllNodeFromRoot(root, k);
        System.out.println(allNodes);
        ArrayList<Integer> allNodes1 = calculateAllNodeFromRootRecursive(root, k);
        System.out.println(allNodes1);
    }

    private static ArrayList<Integer> calculateAllNodeFromRoot(Node root, int k) {
        Queue<Node> lvlQueue = new LinkedList<>();
        lvlQueue.add(root);
        ArrayList<Integer> nodes = new ArrayList<>();
        if (k == 0) {
            nodes.add(root.data);
            return nodes;
        }
        int height = 0, noOfNodesOnCurrentLevel = 0;
        while (height != k) {
            noOfNodesOnCurrentLevel = lvlQueue.size();
            height++;
            while (noOfNodesOnCurrentLevel-- > 0) {
                Node poppedNode = lvlQueue.poll();
                if (poppedNode.left != null) {
                    if (height == k) {
                        nodes.add(poppedNode.left.data);
                    } else {
                        lvlQueue.add(poppedNode.left);
                    }
                }
                if (poppedNode.right != null) {
                    if (height == k) {
                        nodes.add(poppedNode.right.data);
                    } else {
                        lvlQueue.add(poppedNode.right);
                    }
                }
            }
        }

        return nodes;
    }

    static ArrayList<Integer> nodes = new ArrayList<>();

    private static ArrayList<Integer> calculateAllNodeFromRootRecursive(Node root, int k) {
        if (root == null) {
            return nodes;
        }
        if (k == 0) {
            nodes.add(root.data);
        } else {
            calculateAllNodeFromRootRecursive(root.left, k - 1);
            calculateAllNodeFromRootRecursive(root.right, k - 1);
        }
        return nodes;
    }
}
