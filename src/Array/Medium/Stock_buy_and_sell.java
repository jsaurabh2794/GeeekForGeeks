package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stock_buy_and_sell {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            getMaximumProfit(arr, n);
            System.out.println();
        }
    }

    //100 180 260 310 40 535 695 , go until you get higher price stock and pick that go till you get lower price and sell there
    private static void getMaximumProfit(int[] arr, int n) {
        int l = 0, r = 0;
        StringBuffer sb = new StringBuffer();
        for (; r < n; ) {
            while (r + 1 < n && arr[r] > arr[r + 1]) {
                r++;
            }
            l = r;
            while (r + 1 < n && arr[r] < arr[r + 1]) {
                r++;
            }
            sb.append(l != r ? "(" + (l) + " " + (r) + ") " : "");
            r++;
        }
        System.out.print(sb.length() > 0 ? sb : "No Profit");
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
