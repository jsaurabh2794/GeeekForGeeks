package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Amount_of_Water {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split(" ");
            int[] intArrA = new int[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            int amount = getAmountOfWaterCollected(intArrA, n);
            System.out.println(amount);
            testCase--;
        }

        input.close();
    }

    //1 5 3 7 4 2
    private static int getAmountOfWaterCollected(int[] arr, int n) {
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int l = 0, r = n - 1;
        while (l < r) {
            if (arr[l] < arr[r]) { // will choose whose length is smaller
                if (arr[l] >= left_max) {
                    left_max = arr[l];
                } else {
                    result += left_max - arr[l];
                }
                l++;
            } else {
                if (arr[r] >= right_max) {
                    right_max = arr[r];
                } else {
                    result += right_max - arr[r];
                }
                r--;
            }
        }
        return result;
    }
}
