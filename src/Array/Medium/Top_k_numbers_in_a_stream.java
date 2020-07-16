package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*Imp*/
public class Top_k_numbers_in_a_stream {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            printTopKnumbersInAStream(arr, n, k);
            System.out.println();
        }
    }

    private static void printTopKnumbersInAStream(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1); // it will put frequency of element
            //Create one priority Queue to sort key based on value
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    // if freq is difference the print based on highest freq(descending order) else compare based on data (ascending order)
                    return hm.get(o1) != hm.get(o2) ? hm.get(o2) - hm.get(o1) : o1 - o2;
                }
            });
            pq.addAll(hm.keySet()); // added all hashmap data
            for (int j = 0; j < k && !pq.isEmpty(); j++) {
                sb.append(pq.poll() + " ");
            }
        }
        System.out.print(sb);
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
