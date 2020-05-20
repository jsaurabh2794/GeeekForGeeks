package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Segregate_0s_and_1s {
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
            segregate0And1(intArrA, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void segregate0And1(int[] arr, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            if (arr[l] < arr[r]) {
                l++;
                r--;
            } else if (arr[l] > arr[r]) {
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            } else if (arr[l] == arr[r] && arr[r] == 1) {
                r--;
            } else {
                l++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int temp : arr) {
            sb.append(temp + " ");
        }
        System.out.print(sb.toString());
    }
}
