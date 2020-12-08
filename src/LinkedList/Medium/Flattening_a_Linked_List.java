package LinkedList.Medium;

import java.util.PriorityQueue;

public class Flattening_a_Linked_List {
    static class Node {
        int data;
        Node next;
        Node bottom;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.bottom.bottom.bottom = new Node(30);
        root.next = new Node(10);
        root.next.bottom = new Node(20);
        root.next.next = new Node(19);
        root.next.next.bottom = new Node(22);
        root.next.next.bottom.bottom = new Node(50);
        root.next.next.next = new Node(28);
        root.next.next.next.bottom = new Node(35);
        root.next.next.next.bottom.bottom = new Node(40);
        root.next.next.next.bottom.bottom.bottom = new Node(45);
        /*long strt1 = System.currentTimeMillis();
        Node res1 = doFlatteningALinkedList(root);
        long end1 = System.currentTimeMillis();
        System.out.println("First Execution in ms:" + (end1 - strt1));
        display(res1);*/
        long strt2 = System.currentTimeMillis();
        Node res2 = doFlattenWithoutExtraSpace(root);
        long end2 = System.currentTimeMillis();
        System.out.println("First Execution in ms:" + (end2 - strt2));
        display(res2);
    }

    private static void display(Node res1) {
        Node temp = res1;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.bottom;
        }
        System.out.println("null");
    }

    //Using K-sorted Merging
    private static Node doFlatteningALinkedList(Node root) {
        Node temp = root;
        Node newRoot = null, tempRootPtr = null;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.data - n2.data);
        while (temp != null) {
            pq.add(temp);
            temp = temp.next;
        }
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (tempRootPtr == null) {
                tempRootPtr = n;
                newRoot = tempRootPtr;
            } else {
                tempRootPtr.bottom = n;
                tempRootPtr = tempRootPtr.bottom;
            }
            if (n.bottom != null) {
                pq.add(n.bottom);
            }
        }
        return newRoot;
    }

    private static Node doFlattenWithoutExtraSpace(Node root) {
        if (root.next == null) { // if last node is reached
            return root;
        }
        root.next = doFlattenWithoutExtraSpace(root.next);
        root = doMergeBothList(root, root.next);
        return root;
    }

    private static Node doMergeBothList(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Node result;
        if (a.data > b.data) {
            result = b;
            result.bottom = doMergeBothList(a, b.bottom);
        } else {
            result = a;
            result.bottom = doMergeBothList(a.bottom, b);
        }
        return result;
    }
}
