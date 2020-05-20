package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wave_Array {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (Integer.parseInt(stringArrA[i]));
            }
            printTheWaveArray(arr, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void printTheWaveArray(Integer[] arr, int n) {
        for (int i = 0; i < n - 1; i += 2) {
            swap(arr, i, i + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int t : arr) {
            sb.append(t + " ");
        }
        System.out.print(sb.toString().trim());
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
