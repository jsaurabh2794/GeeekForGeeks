package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/*Imp*/
public class Swapping_pairs_make_sum_equal {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        String[] stringArrB;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[0]);
            int m = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            stringArrB = input.readLine().trim().split("\\s+");
            Integer[] arrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(stringArrA[i]);
            }
            Integer[] arrB = new Integer[m];
            for (int i = 0; i < m; i++) {
                arrB[i] = Integer.parseInt(stringArrB[i]);
            }
            int res = isSwappingPairsMakeSumEqualV2(arrA, arrB, n, m);
            System.out.println(res);
            testCase--;
        }

        input.close();
    }

    /*O(nlog(n) + mlog(m))*/
    private static int isSwappingPairsMakeSumEqual(Integer[] arrA, Integer[] arrB, int n, int m) {
        /*sum1 - a + b = sum2 -b +a
         * 2(a-b) = sum1-sum2
         *  a-b = (sum1-sum2)/2
         * If this possible then after swapping sum will be equal*/
        int sum1 = getSum(arrA, n);
        int sum2 = getSum(arrB, m);

        if ((sum1 - sum2) % 2 != 0) {
            return -1;
        }
        int target = (sum1 - sum2) / 2;
        boolean isSwapPossible = false;
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int strtForArrA = 0;
        int strtForArrB = 0;
        while (strtForArrA < n && strtForArrB < m) {
            if (arrA[strtForArrA] - arrB[strtForArrB] > target) {
                strtForArrB++;
            } else if (arrA[strtForArrA] - arrB[strtForArrB] < target) {
                strtForArrA++;
            } else {
                isSwapPossible = true;
                break;
            }
        }
        if (isSwapPossible) {
            return 1;
        }
        return -1;
    }

    /*O(m+n)*/
    private static int isSwappingPairsMakeSumEqualV2(Integer[] arrA, Integer[] arrB, int n, int m) {
        /*sum1 - a + b = sum2 -b +a
         * 2(a-b) = sum1-sum2
         *  a-b = (sum1-sum2)/2
         * If this possible then after swapping sum will be equal*/
        int sum1 = getSum(arrA, n);
        int sum2 = getSum(arrB, m);

        if ((sum1 - sum2) % 2 != 0) {
            return -1;
        }
        int target = Math.abs((sum1 - sum2) / 2);
        boolean isSwapPossible = false;
        HashSet<Integer> arrOneHash = new HashSet<>();
        for (int i = 0; i < m; i++) {
            arrOneHash.add(arrB[i]);
        }

        for (int i = 0; i < n; i++) {
            if (arrOneHash.contains(arrA[i] + target)) {
                isSwapPossible = true;
                break;
            }
        }

        if (isSwapPossible) {
            return 1;
        }
        return -1;
    }

    private static int getSum(Integer[] arr, int totalElements) {
        int sum = 0;
        for (int temp : arr) {
            sum += temp;
        }
        return sum;
    }
}
