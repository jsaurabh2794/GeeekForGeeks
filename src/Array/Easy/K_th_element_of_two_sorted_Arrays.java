package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K_th_element_of_two_sorted_Arrays {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        String[] stringArrB;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int m = Integer.parseInt(secondLine[0]);
            int n = Integer.parseInt(secondLine[1]);
            long k = Long.parseLong(secondLine[2]);
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
            int res = getKthElementOfTwoSortedArray(arrA, arrB, m, n, k);
            System.out.println(res);
            testCase--;
        }

        input.close();
    }

    private static int getKthElementOfTwoSortedArray(Integer[] arrA, Integer[] arrB, int m, int n, long k) {
        long count = 0;
        int pointerForArrA = 0;
        int pointerForArrB = 0;
        while (pointerForArrA < m && pointerForArrB < n) {
            if (arrA[pointerForArrA] < arrB[pointerForArrB]) {
                if (isCountEqualToK(++count, k)) {
                    return arrA[pointerForArrA];
                }
                pointerForArrA++;
            } else {
                if (isCountEqualToK(++count, k)) {
                    return arrB[pointerForArrB];
                }
                pointerForArrB++;
            }
        }
        while (pointerForArrB < n) {
            if (isCountEqualToK(++count, k)) {
                return arrB[pointerForArrB];
            }
            pointerForArrB++;
        }


        while (pointerForArrA < m) {
            if (isCountEqualToK(++count, k)) {
                return arrA[pointerForArrA];
            }
            pointerForArrA++;
        }

        return 0;
    }

    private static boolean isCountEqualToK(long count, long k) {
        return count == k;
    }
}
