package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maximum_Sub_Array {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (input.nextInt());
            }
            printMaximumSubarray(arr, n);
            System.out.println();
        }
    }

    private static void printMaximumSubarray(int[] arr, int n) {
        int sum = -1, currSum = -1, strt = -1, end = -1, currStart = 0, currEnd = 0, i = 0;
        for (; i < n; ) {
            if (currSum > sum || (currSum == sum && (end - strt + 1) < (currEnd - currStart + 1))) {
                strt = currStart;
                end = currEnd;
                sum = currSum;
            }
            while (i < n && arr[i] < 0) {
                i++;
            }
            currStart = i;
            currSum = 0;
            while (i < n && arr[i] >= 0) {
                currSum += arr[i];
                i++;
            }
            currEnd = i - 1;
        }
        if (currSum > sum || (currSum == sum && (end - strt + 1) < (currEnd - currStart + 1))) {
            strt = currStart;
            end = currEnd;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = strt; j <= end; j++) {
            sb.append(arr[j] + " ");
        }
        System.out.print(sb);
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
