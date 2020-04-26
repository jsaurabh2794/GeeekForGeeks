package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Largest_Fibonacci_Subsequence {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            printFibonacciSubequence(arr, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void printFibonacciSubequence(Integer[] arr, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (isFibonacciNumber(arr[i])) {
                sb.append(arr[i] + " ");
            }
        }
        System.out.print(sb.toString());
    }

    private static boolean isFibonacciNumber(Integer n) {

        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }

    private static boolean isPerfectSquare(int n) {
        int sqr = (int) Math.sqrt(n);
        return sqr * sqr == n;
    }
}
