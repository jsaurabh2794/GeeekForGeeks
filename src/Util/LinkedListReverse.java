package Util;

public class LinkedListReverse {
    static class Node {
        int data;
        Node node;

        public Node(int data, Node node) {
            this.data = data;
            this.node = node;
        }
    }

    public static void main(String agrs[]) {
        Node n4 = new Node(4,null);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);

        doreverse(n1);



    }

    private static void doreverse(Node n1) {
        Node curr = n1;
        Node prev = null;
        Node next = n1.node;

        //Before Reverse
        while (n1!= null){
            System.out.print(n1.data+" ");
            n1 = n1.node;
        }
        while (next != null) {
            next = curr.node;
            curr.node = prev;
            prev = curr;
            curr = next;
        }
        System.out.println();
        while (prev!= null){
            System.out.print(prev.data+" ");
            prev = prev.node;
        }
    }
}
