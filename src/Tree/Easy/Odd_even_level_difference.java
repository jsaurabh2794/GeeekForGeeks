package Tree.Easy;

public class Odd_even_level_difference {
    static int oddLevelSum = 0, evenLevelSum = 0;

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
        System.out.println(getLevelDiff(root));
    }


    static int getLevelDiff(Node root) {
        getSum(root, 1);
        return (oddLevelSum - evenLevelSum);
    }

    static void getSum(Node root, int k) {
        if (root == null) {
            return;
        }

        if (k % 2 == 1) {
            oddLevelSum += root.data;
        } else {
            evenLevelSum += root.data;
        }
        getSum(root.left, k + 1);
        getSum(root.right, k + 1);

    }
}
