package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maximum_Difference {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            int maxDifference = getMaxDifference(arr, N);
            System.out.println(maxDifference);
            testCase--;
        }

        input.close();
    }

    private static int getMaxDifference(Integer[] arr, int n) {
        int maxDifference = Integer.MIN_VALUE;
        int minmValue = arr[0];
        for (int i = 1; i < n; i++) {
            if (minmValue < arr[i] && maxDifference < (arr[i] - minmValue)) {
                maxDifference = arr[i] - minmValue;
            }
            minmValue = Math.min(minmValue, arr[i]);
        }


        return maxDifference == Integer.MIN_VALUE ? -1 : maxDifference;
    }

}
