package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Transform_The_Array {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arrA = new int[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = input.nextInt();
            }
            easeTheArray(arrA, n);
            System.out.println();
        }
    }

    private static void easeTheArray(int[] arr, int n) {
        int zeroCount = 0;
        int strt = 0, end = 0;
        int p = 0;
        // Set Strt and End
        while (p < n) {
            if (arr[p] == 0) {
                p++;
            } else {
                strt = p;
                end = strt + 1;
                break;
            }
        }
        while (end < n && strt < n) {
            if (arr[end] == 0) {
                end++;
            } else if (arr[strt] == arr[end]) {
                arr[strt] = 2 * arr[strt];
                arr[end++] = 0;
            } else if (arr[strt] != arr[end]) {
                strt = end;
                end++;
            }

        }

        int l = 0, pointer = 0;
        while (pointer < n) {
            if (arr[pointer] != 0) {
                arr[l++] = arr[pointer];
            }
            pointer++;
        }
        for (int i = l; i < n; i++) {
            arr[l++] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int t : arr) {
            sb.append(t + " ");
        }
        System.out.print(sb.toString().trim());

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