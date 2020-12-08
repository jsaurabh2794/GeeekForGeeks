package LinkedList.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_K_sorted_linked_lists {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //O(nKlogK)
    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(19);

        Node head2 = new Node(1);
        head2.next = new Node(4);
        head2.next.next = new Node(5);

        Node head3 = new Node(1);
        head3.next = new Node(1);
        head3.next.next = new Node(4);

        Node head4 = new Node(10);
        head4.next = new Node(100);
        head4.next.next = new Node(200);

        Node[] a = new Node[]{head1,head2,head3,head4};
        Node res = mergeKList(a);
        display(res);
    }

    static Node mergeKList(Node[] a) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });
        Node temp = null, head = null;
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (temp == null) {
                temp = node;
                head = temp;
            } else {
                temp.next = node;
                temp = temp.next;
            }
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return head;
    }

    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");
    }
}
