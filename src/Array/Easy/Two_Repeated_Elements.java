package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Two_Repeated_Elements {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n + 2];
            for (int i = 0; i < n + 2; i++) {
                arr[i] = input.nextInt();
            }
            printTwoRepeatedElement(arr, n + 2);
            System.out.println();
        }
    }

    //1 2 1 3 4 3
    private static void printTwoRepeatedElement(int[] arr, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int tempIndex = Math.abs(arr[i]) % n;
            if (arr[tempIndex] < 0) {
                sb.append(Math.abs(arr[i]) + " ");
            } else {
                arr[tempIndex] = -(arr[tempIndex]);
            }
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
