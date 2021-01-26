package Tree.Basic;

import java.util.ArrayList;
import java.util.Stack;

public class Preorder_Traversal {
    public static ArrayList<Integer> preOrderTraversal = new ArrayList<>();

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
        System.out.println(printPreOrderTraversal(root));
        preOrderTraversal.clear();
        System.out.println(printPreOrderTraversalIterative(root));
    }

    /*Recursive Approach*/
    private static ArrayList<Integer> printPreOrderTraversal(Node root) {
        if (root == null) {
            return preOrderTraversal;
        }
        preOrderTraversal.add(root.data);
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
        return preOrderTraversal;
    }

    //Using One Stack
    private static ArrayList<Integer> printPreOrderTraversalIterative(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        Node current = root;
        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                preOrderTraversal.add(current.data);
                current = current.left;
            }
            Node poppedNode = nodeStack.pop();
            current = poppedNode.right;
        }
        return preOrderTraversal;
    }
}
