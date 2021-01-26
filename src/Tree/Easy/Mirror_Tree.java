package Tree.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Mirror_Tree {
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
        doMirrorTreeRecursive(root);
        doMirrorTreeIterative(root);
    }

    private static void doMirrorTreeIterative(Node node) {
        if (node == null) {
            return;
        }
        doMirrorTreeIterative(node.left);
        doMirrorTreeIterative(node.right);
        //swap the node
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private static void doMirrorTreeRecursive(Node root) {
        //Do Level Order Traversal
        Queue<Node> lvlQueue = new LinkedList<>();
        lvlQueue.add(root);
        while (!lvlQueue.isEmpty()) {
            Node poppedNode = lvlQueue.poll();
            if (poppedNode.left != null){
                lvlQueue.add(poppedNode.left);
            }
            if (poppedNode.right != null){
                lvlQueue.add(poppedNode.right);
            }
            Node temp = poppedNode.left;
            poppedNode.left = poppedNode.right;
            poppedNode.right = temp;
        }
    }
}
