package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Counting_elements_in_two_arrays {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        String[] stringArrB;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int m = Integer.parseInt(secondLine[0]);
            int n = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            stringArrB = input.readLine().trim().split("\\s+");
            Integer[] arrA = new Integer[m];
            for (int i = 0; i < m; i++) {
                arrA[i] = Integer.parseInt(stringArrA[i]);
            }
            Integer[] arrB = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrB[i] = Integer.parseInt(stringArrB[i]);
            }
            getTheCountFromSecondArrayV2(arrA, arrB, m, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void getTheCountFromSecondArrayV2(Integer[] arrA, Integer[] arrB, int m, int n) {
        int[] hasArray = new int[100000];
        for (int i = 0; i < n; i++) {
            hasArray[arrB[i]] = ++hasArray[arrB[i]]; // set the count of all element
        }
        //update the count of element with equal or less than
        for (int i = 1; i < hasArray.length; i++) {
            hasArray[i] = hasArray[i - 1] + hasArray[i]; // updated the count of all element(which is less or equal to that element) till 10000
        }
        StringBuffer sb = new StringBuffer();
        //now will check for arrA and print the count
        for (int i = 0; i < m; i++) {
            sb.append(hasArray[arrA[i]] + " ");
        }
        System.out.print(sb.toString());
    }

    private static void getTheCountFromSecondArrayV1(Integer[] arrA, Integer[] arrB, int m, int n) {
        Arrays.sort(arrB);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            sb.append(getTheLastIndexOf(arrA[i], 0, n - 1, n, arrB) + " "); /*Adding one because of zero index*/
        }
        System.out.print(sb.toString().trim());
    }

    private static int getTheLastIndexOf(Integer key, int l, int r, int total, Integer[] arrB) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid == total - 1 && arrB[mid] <= key) || (key == arrB[mid] && key < arrB[mid + 1]) || (key > arrB[mid] && key < arrB[mid + 1])) {
                return mid + 1;
            } else if (key < arrB[mid]) {
                return getTheLastIndexOf(key, 0, mid - 1, total, arrB);
            } else {
                return getTheLastIndexOf(key, mid + 1, r, total, arrB);
            }
        }
        return 0;
    }
}
