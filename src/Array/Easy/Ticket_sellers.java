package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ticket_sellers {
    static int RANGE = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int maxmAmount = getMaxmAmountEarned(arr, n, k);
            System.out.println(maxmAmount);
        }
    }

    //2 3 4 4 6
    private static int getMaxmAmountEarned(Integer[] arr, int n, int k) {
        int maxmSum = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int t : arr) {
            priorityQueue.add(t);
        }
        while (k-- > 0) {
            int temp = priorityQueue.poll();
            maxmSum += temp;
            if (temp - 1 > 0) {
                priorityQueue.add(temp - 1);
            }
        }
        return maxmSum % RANGE;
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

        private String next() {
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
