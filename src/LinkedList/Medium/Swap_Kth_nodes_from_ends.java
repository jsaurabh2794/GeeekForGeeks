package LinkedList.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/
public class Swap_Kth_nodes_from_ends {
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        int num = 4;
        int K = 4;
        Node res = swapKthNodeFromBegAndEnd(head,num,K);
        display(res);
    }

    private static Node swapKthNodeFromBegAndEnd(Node head, int num, int K) {
        int nodeNoFromBeg = K, nodeNoFromBegForEnd = (num - K)+1;
        Node fromBeg = head, prev_fromBeg = null, fromEnd = head, prev_fromEnd = null;
        int c = 0;
        if (K > num){
            return head;
        }
        if (nodeNoFromBeg == nodeNoFromBegForEnd){
            return head;
        }
        while(c < nodeNoFromBeg - 1){
            c++;
            prev_fromBeg = fromBeg;
            fromBeg = fromBeg.next;
        }
        c = 0;
        while(c < nodeNoFromBegForEnd - 1){
            c++;
            prev_fromEnd = fromEnd;
            fromEnd = fromEnd.next;
        }
        //Changing the Next Pointer of Both the prev Nodes
        if (prev_fromBeg != null){
            prev_fromBeg.next = fromEnd;
        }
        if (prev_fromEnd != null){
            prev_fromEnd.next = fromBeg;
        }
        //change the next pointer of it
        Node temp = fromEnd.next;
        fromEnd.next = fromBeg.next;
        fromBeg.next = temp;
        if (K == 1){
            head = fromEnd;
        }
        if (K == num){
            head = fromBeg;
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
