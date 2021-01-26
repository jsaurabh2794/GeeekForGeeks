package Tree.Basic;

import java.util.ArrayList;
import java.util.Stack;

public class Postorder_Traversal {
    public static ArrayList<Integer> postOrderList = new ArrayList<>();

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
        System.out.println(printPostOrderTraversal(root));
        postOrderList.clear();
        System.out.println(printPostOrderTraversalIterative(root));
    }

    /*Recursive Approach*/
    private static ArrayList<Integer> printPostOrderTraversal(Node root) {
        if (root == null) {
            return postOrderList;
        }
        printPostOrderTraversal(root.left);
        printPostOrderTraversal(root.right);
        postOrderList.add(root.data);
        return postOrderList;
    }

    //Using One Stack
    private static ArrayList<Integer> printPostOrderTraversalIterative(Node root) {
        Stack<Node> firstStack = new Stack<>();
        firstStack.push(root);
        Stack<Node> secondStack = new Stack<>();
        while (!firstStack.isEmpty()) {
            Node poppedNode = firstStack.pop();
            if (poppedNode.left != null) {
                firstStack.push(poppedNode.left);
            }
            if (poppedNode.right != null) {
                firstStack.push(poppedNode.right);
            }
            secondStack.push(poppedNode);
        }

        while (!secondStack.isEmpty()) {
            postOrderList.add(secondStack.pop().data);
        }

        return postOrderList;
    }
}


