package Stack.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*Imp*/
public class Max_rectangle {
    static class MyReader {
        BufferedReader input;
        StringTokenizer stringTokenizer;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }
    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int row = input.nextInt();
            int col = input.nextInt();
            int[][] arr = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    arr[i][j] = input.nextInt();
                }
            }
            int maxRect = getMaxRectangle(arr, row, col);
            System.out.println(maxRect);
        }
    }

    private static int getMaxRectangle(int[][] arr, int row, int col) {

        int[] res = new int[col]; //Initialize First Row
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    res[j] = 0;
                } else {
                    res[j] += 1;
                }
            }
            max = Math.max(max, getMaximunAreaInHistogram(res));
        }
        return max;
    }

    private static int getMaximunAreaInHistogram(int[] res) {
        int max = 0;
        Stack<Integer> heightStack = new Stack<>();
        heightStack.push(0); //insert index into stack
        for (int i = 1; i < res.length; i++) {
            int curr = res[i];
            if (heightStack.isEmpty() || res[heightStack.peek()] <= curr) {
                heightStack.push(i); //Un till we get higher height, we will keep pushing
            } else {
                while (!heightStack.isEmpty() && res[heightStack.peek()] > curr) {
                    int topHeight = res[heightStack.pop()];
                    if (heightStack.isEmpty()) {
                        max = Math.max(max, topHeight * i); // if it last index then, from there till 'i', area can be maximum
                    } else {
                        max = Math.max(max, topHeight * (i - heightStack.peek() - 1)); // get Area till peek Index
                    }
                }
                heightStack.push(i);
            }
        }

        // if all push was happen or stack is still not empty
        while (!heightStack.isEmpty()) {
            int i = res.length;
            int topHeight = res[heightStack.pop()];
            if (heightStack.isEmpty()) {
                max = Math.max(max, topHeight * i); // if it last index then, from there till 'i', area can be maxm
            } else {
                max = Math.max(max, topHeight * (i - heightStack.peek() - 1));
            }
        }

        return max;
    }
}
