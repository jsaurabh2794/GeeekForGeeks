package Tree.Easy;

public class Check_if_Tree_is_Isomorphic {
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
        Node root1 = new Node(5);
        root1.left = new Node(4);
        root1.left.left = new Node(3);
        root1.right = new Node(6);
        root1.right.right = new Node(7);
        root1.right.right.right = new Node(8);

        Node root2 = new Node(5);
        root2.left = new Node(4);
        root2.left.left = new Node(3);
        root2.right = new Node(6);
        root2.right.right = new Node(7);
        root2.right.right.right = new Node(8);

        boolean res = isTreeIsomorphic(root1, root2);
        System.out.println(res);
    }

    private static boolean isTreeIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null) { //Empty trees are isomorphic
            return true;
        }
        if (root1 == null || root2 == null) { //If anyone is false, its not isomorphic
            return false;
        }
        return (root1.data == root2.data) && (
                (isTreeIsomorphic(root1.left, root2.left) && isTreeIsomorphic(root1.right, root2.right)) ||
                        (isTreeIsomorphic(root1.left, root2.right) && isTreeIsomorphic(root1.right, root2.left))
        );
    }
}
