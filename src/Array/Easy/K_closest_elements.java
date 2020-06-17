package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K_closest_elements {
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
            int x = input.nextInt();
            //findKCloseSetElement(arr, n, k, x); // Will give close set with compare
            findKCloseSetElementWithoutCompare(arr, n, k, x);
            System.out.println();
        }
    }

    // 2 4 5 6 7
    private static void findKCloseSetElementWithoutCompare(Integer[] arr, int n, int k, int x) {
        int crossOverPoint = getPoint(arr, 0, n - 1, x, n);
        int left = crossOverPoint - k / 2;
        int right = crossOverPoint + k / 2;
        int rem = 0;
        if (crossOverPoint == 0) {
            left = 1;
            right = k;
        } else if (crossOverPoint == n - 1) {
            left = n - 1 - k;
            right = n - 2;
        } else if (left < 0) {
            rem = 0 - (left);
            left = 0;
            right = right + rem;
        } else if (right > n - 1) {
            rem = right - (n - 1);
            left = left - rem;
            right = n - 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            if (arr[i] != x) {
                sb.append(arr[i] + " ");
            }
        }
        System.out.print(sb);
    }

    private static void findKCloseSetElement(Integer[] arr, int n, int k, int x) {
        int crossOverPoint = getPoint(arr, 0, n - 1, x, n);
        System.out.println("CrossOver Point:" + crossOverPoint);
        int left = 0, right = 0;
        if (arr[crossOverPoint] == x) {
            left = crossOverPoint - 1; // exact match is there than in close set no need to include that other wise need to include
        } else {
            left = crossOverPoint;
        }
        StringBuilder sb = new StringBuilder();
        right = crossOverPoint + 1;
        while (left >= 0 && right < n && k > 0) {
            if (Math.abs(x - arr[left]) > Math.abs(x - arr[right])) {
                sb.append(arr[right++] + " ");
            } else if (Math.abs(x - arr[left]) < Math.abs(x - arr[right])) {
                sb.append(arr[left--] + " ");
            } else {
                sb.append(arr[left]); // both will be at same distance
                left--;
                right++;
            }
            k--;
        }
        while (k > 0 && left >= 0) {
            sb.append(arr[left--] + " ");
            k--;
        }
        while (k > 0 && right < n) {
            sb.append(arr[right++] + " ");
            k--;
        }
        System.out.print(sb);

    }

    //11 23 24 75 89
    private static int getPoint(Integer[] arr, int l, int r, int val, int total) {
        int mid = 0;
        if (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] == val || (mid + 1 < total && arr[mid] < val && arr[mid + 1] > val) || (mid == l && mid == r)) {
                return mid;
            } else if (arr[mid] > val) {
                return getPoint(arr, l, mid - 1, val, total);
            } else {
                return getPoint(arr, mid + 1, r, val, total);
            }
        }
        return mid;
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
}
