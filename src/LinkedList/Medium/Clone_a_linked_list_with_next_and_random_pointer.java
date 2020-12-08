package LinkedList.Medium;

import java.util.HashMap;
import java.util.Map;

/*Imp*/
public class Clone_a_linked_list_with_next_and_random_pointer {
    static class Node {
        int data;
        Node next, arb;

        Node(int d) {
            data = d;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.arb = head.next.next;
        head.next.arb = head;
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.arb = head.next.next.next.next;
        head.next.next.arb = head.next.next.next.next;
        head.next.next.next.next.arb = head.next;
        System.out.println("Before:");
        display(head);
        //Node nHead = doCloneALinkedAList(head);
        Node nHead = doCloneLinkedListWithConstantSpace(head);
        System.out.println("After:");
        display(nHead);
    }

    private static void display(Node nHead) {
        Node temp = nHead;
        while (temp != null) {
            System.out.println("Data:" + temp.data + " And Random Pointer Data:" + (temp.arb != null ? temp.arb.data : "null"));
            temp = temp.next;
        }
        System.out.println("-----------------------------------------------");
    }

    //O(n) with Space Complexity O(n)
    private static Node doCloneALinkedAList(Node head) {
        Map<Node, Node> origVsCloneMap = new HashMap<>();
        Node temp = head, cloneHead = null, cloneTemp = null;
        while (temp != null) { //Created the Map
            Node newNode = new Node(temp.data);
            origVsCloneMap.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        //Again traverse
        while (temp != null) {
            if (cloneTemp == null) {
                cloneTemp = origVsCloneMap.get(temp);
                cloneTemp.arb = origVsCloneMap.get(temp.arb);
                cloneHead = cloneTemp;
            } else {
                cloneTemp.next = origVsCloneMap.get(temp);
                cloneTemp = cloneTemp.next;
                cloneTemp.arb = origVsCloneMap.get(temp.arb);

            }
            temp = temp.next;
        }
        return cloneHead;
    }


    public static Node doCloneLinkedListWithConstantSpace(Node head) {
        Node tempHead = head, clonedHead = null;
        // create copy node after existing node
        while (tempHead != null) {
            Node newNode = new Node(tempHead.data);
            newNode.next = tempHead.next;
            tempHead.next = newNode;
            tempHead = tempHead.next.next;
        }
        tempHead = head;
        //Now Set All the Arbitrary point as existing node
        while (tempHead != null && tempHead.next != null) {
            tempHead.next.arb = tempHead.arb.next; // it will ne next node of arbitrary node
            tempHead = tempHead.next.next;
        }
        Node original = head, copy = head.next, temp = head.next;
        //now seperate both the list
        while (original != null && copy != null) {
            original.next = (original.next != null) ?
                    original.next.next : null;

            copy.next = (copy.next != null) ? copy.next.next
                    : null;
            original = original.next;
            copy = copy.next;
        }

        return temp;
    }
}
