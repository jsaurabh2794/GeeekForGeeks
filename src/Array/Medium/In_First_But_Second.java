package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class In_First_But_Second {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextLong();
            }
            HashSet<Long> elementsInSecondArray = new HashSet<>();
            for (int i = 0; i < m; i++) {
                elementsInSecondArray.add(input.nextLong());
            }
            getElementWhichIsInFirstButNotInSecondArray(arr, elementsInSecondArray);
            System.out.println();
        }
    }

    private static void getElementWhichIsInFirstButNotInSecondArray(Long[] arr, HashSet<Long> elementsInSecondArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (!elementsInSecondArray.contains(arr[i])) {
                sb.append(arr[i] + " ");
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
