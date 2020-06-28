package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Row_with_max_1_s {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] arr = new int[n * m];
            for (int i = 0; i < (n * m); i++) {
                arr[i] = input.nextInt();
            }
            int rowNum = getRowWithMaxmOnes(arr, n, m);
            System.out.println(rowNum);
        }
    }

    private static int getRowWithMaxmOnes(int[] arr, int row, int col) {
        int rowNumWithMaxNum = -1;
        int noOfOnes = -1;
        int tempCol = 0, tempNoOfOnes = 0, tempRow = 0;
        for (int i = 0; i < row * col; i++) {
            if (tempCol < col) {
                if (arr[i] == 1) {
                    tempNoOfOnes++;
                }
                tempCol++;
            } else {
                if (tempNoOfOnes > noOfOnes) {
                    noOfOnes = tempNoOfOnes;
                    rowNumWithMaxNum = tempRow;
                }
                tempCol = 1;
                tempNoOfOnes = arr[i] == 0 ? 0 : 1;
                tempRow++;
            }
        }
        // if last row has max one then
        if (tempNoOfOnes > noOfOnes) {
            noOfOnes = tempNoOfOnes;
            rowNumWithMaxNum = tempRow;
        }
        return rowNumWithMaxNum;
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
