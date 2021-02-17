package Tree.Easy;

import java.util.ArrayList;
import java.util.Collections;

public class Binary_Tree_to_BST {
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
        root.left.left = new Node(4);
        root.right = new Node(3);
        Node node = convertBinaryTreeToBST(root);
        System.out.println();
    }

    private static Node convertBinaryTreeToBST(Node root) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        getNodesData(root, nodeList);
        Collections.sort(nodeList);
        System.out.println(nodeList);
        return convertArrayListToBST(nodeList, 0, nodeList.size()-1);
    }

    private static Node convertArrayListToBST(ArrayList<Integer> nodeList, int l, int r) {
        Node node = null;
        if (l <= r) {
            int index = l + (r - l) / 2;
            node = new Node(nodeList.get(index));
            node.left = convertArrayListToBST(nodeList, l, index - 1);
            node.right = convertArrayListToBST(nodeList, index + 1, r);
        }
        return node;
    }

    private static void getNodesData(Node root, ArrayList<Integer> nodeList) {
        if (root == null) {
            return;
        }
        nodeList.add(root.data);
        getNodesData(root.left, nodeList);
        getNodesData(root.right, nodeList);
    }
}
