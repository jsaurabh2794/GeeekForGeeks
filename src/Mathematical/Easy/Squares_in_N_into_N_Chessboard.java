package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Squares_in_N_into_N_Chessboard {
    static class MyReader {
        BufferedReader input = null;
        StringTokenizer st = null;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        String next() {
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

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            getNumberOfSquaresIntoChessOfSize(n);
            System.out.println();
        }
    }

    private static void getNumberOfSquaresIntoChessOfSize(int n) {
        /*Explanation*/
        /*1->n*n
          2->n-1*n-1
          3->n-2*n-2
          4
          .
          .
          n->1*1    => 1^2+2^2+3^2+....+n^2 = n(n+1)(2n+1)/6
          */
        int noOfSquares = (n * (n + 1) * ((2 * n) + 1)) / 6;
        System.out.print(noOfSquares);
    }
}
