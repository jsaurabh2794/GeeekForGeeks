package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rectangles_in_N_N_Board {
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
            long n = input.nextLong();
            getNumberOfRectanglesIntoChessOfSize(n);
            System.out.println();
        }
    }

    private static void getNumberOfRectanglesIntoChessOfSize(long n) {
        /*Explanation*/
        /*1->n*n*n
          2->n-1*n-1*n-1
          3->n-2*n-2*n-2
          4
          .
          .
          n->1*1*1    => 1^3+2^3+3^3+....+n^3 = [n^2*(n+2)^2]/4
          */
        long noOfRectangles = ((n) * (n) * (n + 1) * (n + 1)) / 4; //Which is square also
        long noOfSquares = (n * (n + 1) * ((2 * n) + 1)) / 6; //Which is square
        System.out.print(noOfRectangles - noOfSquares); //Will give actual no of ractangle which is not square
    }
}
