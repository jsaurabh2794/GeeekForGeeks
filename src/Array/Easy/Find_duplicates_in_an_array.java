package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Find_duplicates_in_an_array {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            ArrayList<Integer> list = findDuplicatesInArray(arr, n);
            printElement(list);
            System.out.println();
        }
    }

    private static void printElement(ArrayList<Integer> list) {
        for (int t : list) {
            System.out.print(t + " ");
        }
    }

    private static ArrayList<Integer> findDuplicatesInArray(Integer[] arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += n; // increasing by n, doing mod to get actual value, because we are doing additin of n
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] / n > 1) {
                res.add(i);
            }
        }
        if (res.size() == 0) {
            res.add(-1);
        }
        return res;
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
