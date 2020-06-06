package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ease_the_Array {
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
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] != 0 && arr[i] == arr[i + 1]) {
                arr[i] = 2 * arr[i];
                arr[i + 1] = 0;
            }
            if (arr[i] == 0) {
                zeroCount++;
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
