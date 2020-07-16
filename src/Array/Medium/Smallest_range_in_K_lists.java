package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*Imp*/
public class Smallest_range_in_K_lists {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[][] arr = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = input.nextInt();
                }
            }
            findSmallestRange(arr, n, k);
            System.out.println();
        }
    }

    private static void findSmallestRange(int[][] arr, int noOfCol, int noOfRow) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minRange = Integer.MAX_VALUE;
        int strt = -1;
        int end = -1;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < noOfRow; i++) {
            priorityQueue.add(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        while (true) {
            Node tempNode = priorityQueue.poll();
            min = tempNode.node;
            if (minRange > (max - min + 1)) {
                minRange = ((max - min + 1));
                strt = min;
                end = max;
            }

            if (tempNode.colNo + 1 < noOfCol) {
                priorityQueue.add(new Node(arr[tempNode.rowNo][tempNode.colNo + 1], tempNode.rowNo, tempNode.colNo + 1));
                max = Math.max(max, arr[tempNode.rowNo][tempNode.colNo + 1]);
            } else {
                break;
            }
        }
        System.out.print(strt + " " + end);
    }

    static class Node implements Comparable<Node> {
        int node;
        int rowNo;
        int colNo;

        public Node(int node, int rowNo, int colNo) {
            this.node = node;
            this.rowNo = rowNo;
            this.colNo = colNo;
        }

        @Override
        public int compareTo(Node node) {
            return this.node - node.node;
        }
    }

    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
