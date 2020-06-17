package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rotate_a_array_without_using_extra_space {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[][] arr = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = input.nextInt();
                }
            }
            rotateArrayWithoutUsingExtraSpace(arr, n);
            System.out.println();
        }
    }

    private static void rotateArrayWithoutUsingExtraSpace(Integer[][] arr, int n) {
        //Transpose of Matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        // Reverse of Matrix
        int row = 0, l = 0, r = n - 1;
        while (row < n && l < r) {
            int temp = arr[row][l];
            arr[row][l] = arr[row][r];
            arr[row][r] = temp;
            l++;
            r--;
            if (l >= n / 2) {
                row++;
                l = 0;
                r = n - 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j] + " ");
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
