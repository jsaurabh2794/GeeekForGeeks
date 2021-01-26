package Tree.Easy;

public class Expression_Tree {
    static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node("-");
        root.left = new Node("7");
        root.right = new Node("3");
        int val = calulateEval(root);
        System.out.println(val);
    }

    private static int calulateEval(Node root) {
        if (root != null && root.left == null && root.right == null) {
            return Integer.parseInt(root.data);
        }
        int l = calulateEval(root.left);
        int r = calulateEval(root.right);
        int val;
        if ("+".equals(root.data)) {
            val = (l + r);
        } else if ("-".equals(root.data)) {
            val = (l - r);
        } else if ("*".equals(root.data)) {
            val = (l * r);
        } else {
            val = (l / r);
        }
        return val;
    }
}
