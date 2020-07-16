package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Maximize_The_Array {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arrA = new Integer[n];
            Integer[] arrB = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = input.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arrB[i] = input.nextInt();
            }
            doMaximizeTheArray(arrA, arrB, n);
            System.out.println();
        }
    }

    private static void doMaximizeTheArray(Integer[] arrA, Integer[] arrB, int n) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            ts.add(arrA[i]);
        }
        for (int i = 0; i < n; i++) {
            ts.add(arrB[i]);
        }
        //Make set of size n from 2n
        Set<Integer> newTs = new TreeSet<>(Collections.reverseOrder());

        Iterator<Integer> itr = ts.iterator();
        while (newTs.size() < n && itr.hasNext()) {
            newTs.add(itr.next());
        }

        for (int i = 0; i < n; i++) {
            if (newTs.contains(arrB[i])) {
                sb.append(arrB[i] + " ");
                newTs.remove(arrB[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (newTs.contains(arrA[i])) {
                sb.append(arrA[i] + " ");
                newTs.remove(arrA[i]);
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
