package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_of_two_numbers_represented_as_arrays {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] arrA = new int[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = input.nextInt();
            }
            int[] arrB = new int[m];
            for (int i = 0; i < m; i++) {
                arrB[i] = input.nextInt();
            }
            printSumOfTwoNumbersRepresentedAsArray(arrA, arrB, n, m);
            System.out.println();
        }
    }

    private static void printSumOfTwoNumbersRepresentedAsArray(int[] arrA, int[] arrB, int n, int m) {
        int pointerOfA = n - 1, pointerOfB = m - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int carry = 0;
        while (pointerOfA >= 0 && pointerOfB >= 0) {
            sum = arrA[pointerOfA--] + arrB[pointerOfB--] + carry;
            sb.append(sum % 10 + " ");
            carry = sum / 10;
        }
        while (pointerOfA >= 0) {
            sum = arrA[pointerOfA--] + carry;
            sb.append(sum % 10 + " ");
            carry = sum / 10;
        }
        while (pointerOfB >= 0) {
            sum = arrB[pointerOfB--] + carry;
            sb.append(sum % 10 + " ");
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.append(carry + " ");
        }

        System.out.print(sb.reverse().toString().trim());

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
