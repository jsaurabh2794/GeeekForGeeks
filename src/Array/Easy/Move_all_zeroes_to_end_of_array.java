package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Move_all_zeroes_to_end_of_array {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] intArrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            moveAllZerosToEnd(intArrA, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void moveAllZerosToEnd(Integer[] arrA, int n) {
        int countOfNonZero = 0;
        for (int i = 0; i < n; i++) {
            if (arrA[i] > 0) {
                arrA[countOfNonZero++] = arrA[i];
            }
        }
        while (countOfNonZero < n) {
            arrA[countOfNonZero++] = 0;
        }
        StringBuffer sb = new StringBuffer();
        for (int t : arrA) {
            sb.append(t + " ");
        }
        System.out.print(sb.toString().trim());
    }
}
