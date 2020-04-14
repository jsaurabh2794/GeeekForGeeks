package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary_Search {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] dataArray;
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            dataArray = input.readLine().trim().split(" ");
            int k = Integer.parseInt(input.readLine().trim());
            int[] dataArrayInteger = new int[dataArray.length];
            for (int i = 0; i < dataArray.length; i++) {
                dataArrayInteger[i] = Integer.parseInt(dataArray[i]);
            }
            int res = bin_search(dataArrayInteger, 0, noOfElements - 1, k);
            System.out.println(res);
        }
    }

    private static int bin_search(int[] A, int left, int right, int k) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == k) {
                return mid;
            } else if (A[mid] < k) {
                return bin_search(A, mid + 1, right, k);
            } else {
                return bin_search(A, left, mid - 1, k);
            }
        }
        return -1;
    }
}
