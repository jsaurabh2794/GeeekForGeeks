package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Max_sum_in_the_configuration {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] A = new Integer[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(stringArrA[i]);
            }
            int sum = getMaxSum(A, N);
            System.out.println(sum);
            testCase--;
        }

        input.close();
    }

    private static int getMaxSum(Integer[] A, int n) {
        int maxSum = 0;
        int totalElementSum = 0;
        for (int i = 0; i < n; i++) {
            totalElementSum += A[i];
        }
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += i * A[i]; // Initial Config Sum
        }
        maxSum = currentSum;
        for (int i = 1; i < n; i++) {
            int temp = currentSum - (totalElementSum) + (n * A[i - 1]); // getting second Rotaion sum from first...got
            currentSum = temp;                                        // the formula by manually derived.
            maxSum = Math.max(maxSum, temp);
        }
        return maxSum;
    }
}
