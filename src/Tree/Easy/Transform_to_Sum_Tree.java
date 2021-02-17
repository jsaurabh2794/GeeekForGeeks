package Tree.Easy;

public class Transform_to_Sum_Tree {
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
        root.left.left = new Node(4);
    }
    public static void toSumTree(Node root){
       toSumTreeNew(root);
    }

    public static int toSumTreeNew(Node node){
        if (node == null){
            return 0;
        }
        int lSum = toSumTreeNew(node.left);
        int rSum = toSumTreeNew(node.right);
        int orgSum = (node.data + lSum + rSum);
        node.data = lSum + rSum;
        return orgSum;
    }
}
