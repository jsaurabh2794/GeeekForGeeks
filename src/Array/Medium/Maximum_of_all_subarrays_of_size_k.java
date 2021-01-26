package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*Imp*/
public class Maximum_of_all_subarrays_of_size_k {
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
            printMaximumOfAllSubArray(arr, n, k);
            System.out.println();
        }
    }

    private static void printMaximumOfAllSubArray(Integer[] arr, int n, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();

        // Added First Window Element to Deque
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = k; i < n; i++) {
            sb.append(arr[deque.peekFirst()] + " ");

            // if all elements are in decreasing order then it will not maintain size of K, because
            // we are removing only when upcoming element is larger.
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            // Add upcoming element
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        sb.append(arr[deque.peekFirst()]);
        System.out.print(sb);
    }

    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> s = new ArrayList<>();
        int c = 0;
        while (c < k){
            q.add(arr[c]);
            c++;
        }
        int r = 0;
        for (int i = k; i< n ; i++){
            s.add(q.peek());
            q.remove(arr[r++]);
            q.add(arr[i]);
        }
        s.add(q.peek());
        return s;
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
