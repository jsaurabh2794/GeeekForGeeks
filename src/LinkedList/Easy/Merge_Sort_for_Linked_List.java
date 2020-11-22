package LinkedList.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Merge_Sort_for_Linked_List {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class MyReader {
        BufferedReader input;
        StringTokenizer stringTokenizer;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Node node = null, head = null;
            for (int i = 0; i < n; i++) {
                if (node == null) {
                    node = new Node(input.nextInt());
                    head = node;
                } else {
                    node.next = new Node(input.nextInt());
                    node = node.next;
                }
            }
            Node resultHead = doMergeSortInLinkedList(head);
            display(resultHead);
        }
    }

    private static void display(Node resultHead) {
        while (resultHead != null) {
            System.out.print(resultHead.data + "->");
            resultHead = resultHead.next;
        }
        System.out.println("null");
    }

    private static Node doMergeSortInLinkedList(Node head) {
        if (head == null || head.next == null) { //if no or one element is there
            return head;
        }

        //Get the Middle Node of the Linked List
        Node middleElement = getMiddleElementInALinkedList(head);
        Node nextToMiddle = middleElement.next;

        //detach main linked list in two part
        middleElement.next = null;

        //Apply merge sort in left part
        Node left = doMergeSortInLinkedList(head);

        //Apply merge sort in right part
        Node right = doMergeSortInLinkedList(nextToMiddle);

        //sort both the part
        Node sortedList = doMerging(left, right);

        return sortedList;
    }

    private static Node doMerging(Node left, Node right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        Node result = null, head = null;
        while (left != null && right != null) {
            Node tempNode = null;
            if (left.data > right.data) {
                tempNode = new Node(right.data);
                right = right.next;
            } else {
                tempNode = new Node(left.data);
                left = left.next;
            }
            result = addNodeToResultLinkedList(result, tempNode);
            if (head == null) // always, there will be at-least 2 data present. So here it will give head node
            {
                head = result;
            }
        }

        while (left != null) {
            result = addNodeToResultLinkedList(result, new Node(left.data));
            left = left.next;
        }

        while (right != null) {
            result = addNodeToResultLinkedList(result, new Node(right.data));
            right = right.next;
        }

        return head;
    }

    private static Node addNodeToResultLinkedList(Node result, Node tempNode) {
        if (result == null) {
            result = tempNode;
        } else {
            result.next = tempNode;
            result = result.next;
        }
        return result;
    }

    private static Node getMiddleElementInALinkedList(Node head) {
        Node slowPtr = head, fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPtr = slowPtr.next; //Increase 1
            fastPointer = fastPointer.next.next; //Increase by 2
        }
        return slowPtr;
    }
}
