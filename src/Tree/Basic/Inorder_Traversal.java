package Tree.Basic;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder_Traversal {
    public static ArrayList<Integer> inorderList = new ArrayList<>();

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
        System.out.println(printInorderTraversal(root));
        inorderList.clear();
        System.out.println(printInorderTraversalIterative(root));
    }

    /*Recursive Approach*/
    private static ArrayList<Integer> printInorderTraversal(Node root) {
        if (root == null) {
            return inorderList;
        }
        printInorderTraversal(root.left);
        inorderList.add(root.data);
        printInorderTraversal(root.right);
        return inorderList;
    }

    private static ArrayList<Integer> printInorderTraversalIterative(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        Node current = root; // current is pointing to root
        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            Node poppedNode = nodeStack.pop();
            inorderList.add(poppedNode.data);
            current = poppedNode.right;
        }
        return inorderList;
    }
}
