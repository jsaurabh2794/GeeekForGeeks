package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum_of_Lengths_of_Non_Overlapping_SubArrays {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split(" ");
            int k = Integer.parseInt(input.readLine().trim());
            int[] intArrA = new int[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            long sum = getSumOfLength(intArrA, n, k);
            System.out.println(sum);
            testCase--;
        }

        input.close();
    }

    private static long getSumOfLength(int[] intArrA, int n, int k) {
        long totalLength = 0L;
        boolean flag = false;
        long count = 0l;

        for (int i = 0; i < n; ) {
            count = 0l;
            flag = false;
            while (i < n && intArrA[i] <= k) {
                count++;
                if (intArrA[i] == k) {
                    flag = true;
                }
                i++;
            }
            if (flag) {
                totalLength += count;
            }
            while (i < n && intArrA[i] > k) {
                i++;
            }
        }
        return totalLength;
    }
}
