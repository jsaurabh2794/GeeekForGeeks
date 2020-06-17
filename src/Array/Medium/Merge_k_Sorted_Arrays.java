package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Merge_k_Sorted_Arrays {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int k = input.nextInt();
            Integer[][] arr = new Integer[k][k];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    arr[i][j] = input.nextInt();
                }
            }
            ArrayList<Integer> res = mergerKSortedArray(arr, k);
            System.out.println(res);
        }
    }

    /*Merging K Sorted Array*/ /*Imp*/
    private static ArrayList<Integer> mergerKSortedArray(Integer[][] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Node> minPriorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minPriorityQueue.add(new Node(i, 0, arr[i][0]));
        }
        while (!minPriorityQueue.isEmpty()) {
            Node temp = minPriorityQueue.poll();
            result.add(temp.value);
            int arrayNumber = temp.arrayNumber;
            int indexInThatArray = temp.indexOfThatArray;
            if (indexInThatArray + 1 < arr[arrayNumber].length) {
                minPriorityQueue.add(new Node(arrayNumber, indexInThatArray + 1, arr[arrayNumber][indexInThatArray + 1]));
            }
        }
        return result;
    }

    static class Node implements Comparable<Node> {
        int arrayNumber;
        int indexOfThatArray;
        int value;

        public Node(int arrayNumber, int indexOfThatArray, int value) {
            this.arrayNumber = arrayNumber;
            this.indexOfThatArray = indexOfThatArray;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value == o.value) {
                return 0;
            } else if (this.value > o.value) {
                return 1;
            } else {
                return -1;
            }
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
