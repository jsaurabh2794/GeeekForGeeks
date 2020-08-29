package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Thief_trying_to_escape {
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

    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int x = input.nextInt();
            int y = input.nextInt();
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            getTotalJump(x, y, arr, n);
            System.out.println();
        }
    }

    private static void getTotalJump(int x, int y, int[] height, int totalHeights) {
        int jumps = 0;

        for (int i = 0; i < totalHeights; i++) {
            if (height[i] <= x) {
                jumps++;
                continue;
            }

            /* If height of wall is greater than
               up move */
            int h = height[i];
            while (h > x) {
                jumps++;
                h = h - (x - y);
            }
            jumps++; //this is required when some length is remaining less than x
        }
        System.out.print(jumps);
    }
}
