package Array.Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Merge_Without_Extra_Space {
    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int m = input.nextInt();
            int n = input.nextInt();
            int[] arr1 = new int[m];
            int[] arr2 = new int[n];
            for (int i = 0; i < m; i++) {
                arr1[i] = input.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr2[i] = input.nextInt();
            }
            doMergeWithoutExtraSpace(arr1, arr2, m, n);
            System.out.println();
        }
    }

    public static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    /*Pending*/ /*Did not get the solution*/
    private static void doMergeWithoutExtraSpace(int[] arr1, int[] arr2, int n, int m) {
        int i, j, gap = n + m, tmp;
        for (; gap > 0; gap = nextGap(gap)) {
            for (i = 0; i + gap < n; i++) { //Apply Shell Sort in first Array
                if (arr1[i] > arr1[i + gap]) {
                    tmp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = tmp;
                }
            }

            for (j = 0; i < n && j < m; i++, j++) { //Move all element to second array which is greater than first array
                if (arr1[i] > arr2[j]) {
                    tmp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = tmp;
                }
            }

            if (j < m) {
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        tmp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = tmp;
                    }
                }
            }
        }
        printData(arr1,arr2);
    }


    //O(mn) Complexity //TLE
    private static void doMergeWithoutExtraSpaceV3(int[] arr1, int[] arr2, int m, int n) {
        // Will pick every element from arr1 and check if it is greater than first element of arr2, means it should be in second array
        // then place that element in correct position
        for (int i = 0; i < m; i++) {
            //compare the ith element with first element of Y
            if (arr1[i] > arr2[0]) {
                /*Swap element*/
                int store = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = store;
                /*Swap element*/

                //Now, place arr2[0] element to correct position
                int j;
                for (j = 1; j < n && arr2[j] < store; j++) { //find Correct position
                    arr2[j - 1] = arr2[j];
                }
                arr2[j - 1] = store;
            }
        }
        printData(arr1, arr2);
    }

    private static void printData(int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder("");
        for (int t : arr1) {
            sb.append(t + " ");
        }
        for (int t : arr2) {
            sb.append(t + " ");
        }
        System.out.print(sb);
    }


}
