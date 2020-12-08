package LinkedList.Hard;

public class Binary_Tree_to_DLL {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node dllHead = null, prev = null;

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(3);
        head.right = new Node(10);
        head.right.left = new Node(9);
        head.right.left.left = new Node(10);
        head.left.left = new Node(5);
        head.left.right = new Node(7);
        head.left.left.left = new Node(5);
        head.left.left.right = new Node(5);
        head.left.right.left = new Node(9);
        head.left.right.right = new Node(2);
        Node n = doBinaryTreeToDLL(head);
        display(n);
    }

    private static Node doBinaryTreeToDLL(Node head) {
        if (head == null) {
            return null;
        }
        doBinaryTreeToDLL(head.left);
        if (prev == null) {
            dllHead = head;
        } else {
            head.left = prev;
            prev.right = head;
        }
        prev = head;
        doBinaryTreeToDLL(head.right);
        return dllHead;
    }

    private static void display(Node resultHead) {
        Node temp = resultHead, prev = null;
        while (temp != null) {
            System.out.print(temp.data + "->");
            prev = temp;
            temp = temp.right;
        }
        System.out.println("null");
        while (prev != null){
            System.out.print(prev.data + "->");
            prev = prev.left;
        }
        System.out.println("null");
    }
}
