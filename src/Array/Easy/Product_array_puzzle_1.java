package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Product_array_puzzle_1 {
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
            long[] newArray = getProductArray(arr, n);
            printData(newArray);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void printData(long[] newArray) {
        StringBuffer sb = new StringBuffer();
        for (long t : newArray) {
            sb.append(t + " ");
        }
        System.out.print(sb.toString().trim());
    }

    private static long[] getProductArray(Integer[] arr, int n) {
        long totalProduct = 1l;
        int zeroCount = 0;
        for (int t : arr) {
            if (t != 0) {
                totalProduct *= t;
            } else {
                zeroCount++;
            }
        }
        long[] newArray = new long[n];

        for (int i = 0; i < n; i++) {
            if (zeroCount == 1) {
                if (arr[i] != 0) {
                    newArray[i] = 0L;
                } else {
                    newArray[i] = totalProduct;
                }
            } else if (zeroCount >= 2) {
                newArray[i] = 0L;
            } else {
                newArray[i] = totalProduct / arr[i];
            }

        }
        return newArray;
    }
}
