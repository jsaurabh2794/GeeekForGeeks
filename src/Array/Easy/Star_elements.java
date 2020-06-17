package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Star_elements {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            printStarAndSuperStarElements(arr, n);
            //System.out.println();
        }
    }

    private static void printStarAndSuperStarElements(int[] arr, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        int maxTillHereFromLeft = Integer.MIN_VALUE;
        int maxTillHereFromRight = Integer.MIN_VALUE;
        //Fill Left Array
        for (int i = 0; i < n; i++) {
            if (maxTillHereFromLeft < arr[i]) {
                maxTillHereFromLeft = arr[i];
                left[i] = maxTillHereFromLeft;
            } else {
                left[i] = Integer.MAX_VALUE;
            }

        }
        // Fill the Right Array
        for (int i = n - 1; i >= 0; i--) {
            if (maxTillHereFromRight < arr[i]) {
                maxTillHereFromRight = arr[i];
                right[i] = maxTillHereFromRight;
            } else {
                right[i] = Integer.MAX_VALUE;
            }

        }
        StringBuilder star = new StringBuilder();
        StringBuilder superStar = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (right[i] != Integer.MAX_VALUE && right[i] == arr[i]) {
                star.insert(0, " " + arr[i]);
            }
        }
        System.out.println(star.toString().trim());
        for (int i = 0; i < n; i++) {
            if (i == 0 && right[i] != Integer.MAX_VALUE && right[i] == arr[i]) {
                superStar.append(arr[i] + " ");
            } else if (i == n - 1 && left[i] != Integer.MAX_VALUE && left[i] == arr[i]) {
                superStar.append(arr[i] + " ");
            } else {
                if (left[i] != Integer.MAX_VALUE && right[i] != Integer.MAX_VALUE && left[i] == arr[i] && arr[i] == right[i]) {
                    superStar.append(arr[i] + " ");
                }
            }
        }
        System.out.println(superStar.length() > 0 ? superStar.toString().trim() : "-1");

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
