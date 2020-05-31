package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Union_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        Pair_with_given_sum_in_a_sorted_array.FastReader input = new Pair_with_given_sum_in_a_sorted_array.FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int m = input.nextInt();
            int n = input.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = input.nextInt();
            }
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = input.nextInt();
            }
            print(unionOfTwoArray(arr, arr1, m, n));
            System.out.println();
        }
    }

    private static void print(ArrayList<Integer> unionOfTwoArray) {
        for (int t : unionOfTwoArray) {
            System.out.print(t + " ");
        }
    }

    private static ArrayList<Integer> unionOfTwoArray(int[] arr, int[] arr1, int m, int n) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> sb = new ArrayList<Integer>();
        int pointerForArr = 0;
        int pointerForArr1 = 0;
        while (pointerForArr < m && pointerForArr1 < n) {
            if (arr[pointerForArr] > arr1[pointerForArr1]) {
                if (set.add(arr1[pointerForArr1])) {
                    sb.add(arr1[pointerForArr1]);
                }
                pointerForArr1++;
            } else {
                if (set.add(arr[pointerForArr])) {
                    sb.add(arr[pointerForArr]);
                }
                pointerForArr++;
            }
        }
        while (pointerForArr < m) {
            if (set.add(arr[pointerForArr])) {
                sb.add(arr[pointerForArr]);
            }
            pointerForArr++;
        }
        while (pointerForArr1 < n) {
            if (set.add(arr1[pointerForArr1])) {
                sb.add(arr1[pointerForArr1]);
            }
            pointerForArr1++;
        }
        return sb;
    }

    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        private String next() {
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
}
