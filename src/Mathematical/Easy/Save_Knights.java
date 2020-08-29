package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Save_Knights {
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            double n = input.nextDouble();
            double count = noOfKnightCanBePlaceInChessBoard(n);
            System.out.println((int)count);
        }
    }

    private static double noOfKnightCanBePlaceInChessBoard(double n) {
        /*We have to fill the chess board in an alternating pattern starting with a knight at the first place. Then after leaving one place again a knight. Move on until the row ends. Do the same with the columns. In this way you will get the positions of non-attacking knights.
Now if N(apart from 2) is even each row will have N/2 knights. So in Total there will be N*(N/2) positions.
If N is odd then first row will have (N+1)/2 positions.
Second row will have (N-1)/2 Positions.
Third row will again have (N+1)/2 positions.
Move on until the last row following this pattern. Sum this. You will get the Answer (N*N+1)/2.
Overall the answer is ceil(N*N/2).*/
        if (n == 2){
            return 4;
        }
        return Math.ceil(n*n/2);
    }
}
