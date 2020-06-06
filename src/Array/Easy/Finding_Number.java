package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/ /*Lengthy*/
public class Finding_Number {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int k = input.nextInt();
            int index = findTheNumberK(arr, n, k);
            System.out.println(index);
        }
    }

    private static int findTheNumberK(Integer[] arr, int n, int k) {
        return findTheNumberK(arr, 0, n - 1, k, n);
    }

    //50 55 60 2 1
    private static int findTheNumberK(Integer[] arr, int l, int r, int k, int total) {
        int pivotElementIndex = 0;
        if (total == 1)
            pivotElementIndex = 0;
        else if (arr[0] > arr[1])
            pivotElementIndex = 0;
        else if (arr[total - 1] > arr[total - 2])
            pivotElementIndex = total - 1;
        else
            pivotElementIndex = findPivotElement(arr, l, r, total);

        if (arr[pivotElementIndex] == k) {
            return pivotElementIndex;
        }

        int leftSideSearch = findLeftSide(arr, 0, pivotElementIndex - 1, k);
        if (leftSideSearch != -1) {
            return leftSideSearch;
        }
        return findRightSide(arr, pivotElementIndex + 1, r, k);
    }

    private static int findRightSide(Integer[] arr, int l, int r, int k) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                return findLeftSide(arr, l, mid - 1, k);
            } else {
                return findLeftSide(arr, mid + 1, r, k);
            }
        }
        return -1;
    }

    private static int findLeftSide(Integer[] arr, int l, int r, int k) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                return findLeftSide(arr, mid + 1, r, k);
            } else {
                return findLeftSide(arr, l, mid - 1, k);
            }
        }
        return -1;
    }

    private static int findPivotElement(Integer[] arr, int l, int r, int total) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid - 1 >= 0 && mid + 1 < total && arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                return findPivotElement(arr, mid + 1, r, total);
            } else if (mid - 1 >= 0 && mid + 1 < total && arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                return findPivotElement(arr, l, mid - 1, total);
            } else if (mid - 1 >= 0 && mid + 1 < total && arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid == 0) {
                return 0;
            } else if (mid == total - 1) {
                return total - 1;
            }
        }
        return 0;
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
