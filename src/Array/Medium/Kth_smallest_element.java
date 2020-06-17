package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kth_smallest_element {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int k = input.nextInt();
            int element = kthSmallestElement(arr, k);
            System.out.println(element);
        }
    }

    private static int kthSmallestElement(Integer[] arr, int k) {
        int length = arr.length;
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(Collections.reverseOrder()); //max priority
        for (int i = 0; i < length; i++) {
            if (i < k) {
                integerPriorityQueue.add(arr[i]);
            } else {
                if (arr[i] < integerPriorityQueue.peek()) { // adding which is less than peek, it will arrange automatically
                    integerPriorityQueue.poll();
                    integerPriorityQueue.add(arr[i]);
                }
            }
        }
        return integerPriorityQueue.poll();
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
