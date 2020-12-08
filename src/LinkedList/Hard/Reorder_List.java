package LinkedList.Hard;

public class Reorder_List {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node res = reorderList(head);
        display(res);
    }

    private static Node reorderList(Node head) {
        Node temp = head;
        Node half = getMiddleNode(temp);
        Node l = head, nextHalf = half.next;
        half.next = null;
        Node r = reverse(nextHalf);
        Node newHead = new Node(0);
        Node curr = newHead;

        while (l != null || r != null) {
            if (l != null) {
                curr.next = l;
                l = l.next;
                curr = curr.next;
            }
            if (r != null) {
                curr.next = r;
                r = r.next;
                curr = curr.next;
            }
        }


        return newHead.next;
    }

    private static Node reverse(Node head) {
        Node curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 1 2 3 4
    private static Node getMiddleNode(Node temp) {
        Node slow = temp, fast = temp;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");

    }
}
