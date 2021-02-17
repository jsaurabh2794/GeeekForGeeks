package Tree.Easy;

public class Diameter_of_Binary_Tree {
    static class TreeHeight {
        int height;
    }

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
        TreeHeight height = new TreeHeight();
        System.out.println(getDiaMeterOfBT(root, height));
    }

    private static int getDiaMeterOfBT(Node root, TreeHeight height) {
        //root is null, height will be zero
        if (root == null) {
            height.height = 0;
            return 0; //dia will be zero for null node
        }

        TreeHeight lTreeHeight = new TreeHeight();
        TreeHeight rTreeHeight = new TreeHeight();

        int leftTreeDiameter = getDiaMeterOfBT(root.left, lTreeHeight);
        int rightTreeDiameter = getDiaMeterOfBT(root.right, rTreeHeight);

        height.height = 1 + Math.max(lTreeHeight.height, rTreeHeight.height);

        //Diameter will be max of (left sub tree height +1+right subtree height, Max of (leftTreeDiameter,rightTreeDiameter
        return Math.max(lTreeHeight.height + rTreeHeight.height + 1, Math.max(leftTreeDiameter, rightTreeDiameter));
    }
}
