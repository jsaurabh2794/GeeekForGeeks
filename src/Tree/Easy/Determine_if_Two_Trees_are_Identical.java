package Tree.Easy;

public class Determine_if_Two_Trees_are_Identical {
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
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        System.out.println(isIdentical(root1, root2) ? "Yes" : "No");
    }

    private static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean c = (root1.data == root2.data);
        boolean a = isIdentical(root1.left, root2.left);
        boolean b = isIdentical(root1.right, root2.right);
        return c && a && b;
    }
}
