package Queue.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Minimum_Cost_of_ropes {
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

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCase = reader.nextInt();
        while (testCase-- > 0) {
            int n = reader.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextLong();
            }
            long minCost = minCost(arr, arr.length);
            System.out.println(minCost);
        }
    }

    private static long minCost(long[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        long minCost = 0;
        long firstMin = 0l, secondMin = 0l;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long t : arr) {
            minHeap.add(t);
        }
        firstMin = minHeap.poll();
        secondMin = minHeap.poll();
        minCost += (firstMin + secondMin);
        minHeap.add(firstMin + secondMin);
        while (!minHeap.isEmpty() && minHeap.size() > 1) {
            firstMin = minHeap.poll();
            secondMin = minHeap.poll();
            minCost += (firstMin + secondMin);
            minHeap.add(firstMin + secondMin);
        }
        return minCost;
    }
}
