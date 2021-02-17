package Tree.Easy;

public class Lowest_Common_Ancestor_in_a_BST {
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
        Node node = LCA(root, 7, 8);
        System.out.println(node.data);
    }

    private static Node LCA(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if (node.data > n1 && node.data > n2) { //because it is BST
            return LCA(node.left, n1, n2);
        }
        if (node.data < n1 && node.data < n2) { //because it is BST
            return LCA(node.right, n1, n2);
        }
        return node;
    }
}
