package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*Imp*/
public class The_Celebrity_Problem {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = input.nextInt();
                }
            }
            int rowId = getCeleberityId(arr, n);
            System.out.println(rowId);
        }
    }

    private static int getCeleberityId(int[][] arr, int n) {
        // Stranger is a person who does not know anyone
        Stack<Integer> integers = new Stack<>();
        for (int i = 0; i < n; i++) {
            integers.push(i); // Push all Celebrity's id into stack
        }
        while (integers.size() > 1) {
            int firstTop = integers.pop();
            int secondTop = integers.pop();
            if (arr[firstTop][secondTop] == 1) {
                // means first top is not a Stranger celebrity, because he knows SecondTop
                integers.push(secondTop);
            } else {
                // first top does not know second top, so he might be Stranger
                integers.push(firstTop);
            }
        }
        //  where only one person is known to everyone.
        //  Such a person may be present in the party,
        //  if yes, (s)he doesn’t know anyone in the party.

        // if he is the stranger, then he should know everyone but all should know him.
        int lastOne = integers.pop();
        for (int i = 0; i < n; i++) {
            if (i != lastOne && (arr[lastOne][i] == 1 || arr[i][lastOne] == 0)) {
                return -1;
            }
        }
        return lastOne;

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
