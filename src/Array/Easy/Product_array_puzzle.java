package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Product_array_puzzle {
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
            getProductArray(arr, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void getProductArray(Integer[] arr, int n) {
        long totalProduct = 1l;
        for (int t : arr) {
            totalProduct *= t;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = (int) totalProduct / arr[i];
        }
        StringBuffer sb = new StringBuffer();
        for (int t : arr) {
            sb.append(t + " ");
        }
        System.out.print(sb.toString().trim());
    }
}
