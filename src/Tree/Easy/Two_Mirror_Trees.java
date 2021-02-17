package Tree.Easy;

public class Two_Mirror_Trees {
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

        Node root1 = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);

        boolean res = areMirror(root, root1);

    }

    private static boolean areMirror(Node root, Node root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }
        return (root.data == root1.data) && (areMirror(root.left, root1.right)) && (areMirror(root.right, root1.left));

    }
}
