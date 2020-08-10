package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*VVImp*/
public class Dice_throw {
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

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int m = input.nextInt(); //No of faces
            int n = input.nextInt(); //No of throws
            int x = input.nextInt(); //target Sum
            findTheWayToGetSumX(m, n, x);
            System.out.println();
        }
    }

    private static void findTheWayToGetSumX(int m, int n, int x) {
        //Create 2D Array which represents,ith dice with jth Sum
        long[][] arr = new long[n + 1][x + 1];
        //For the first dice all sum will get in one way
        for (int i = 1; i <= x && i <= m; i++) { //less than no of faces and less than target sum
            arr[1][i] = 1;
        }

        //Now, for 2 or more dice throw ways
        for (int i = 2; i <= n; i++) { //No of dices
            for (int j = 1; j <= x; j++) { //target Sum or partial sum till j
                for (int k = 1; k < j && k <= m; k++) {
                    arr[i][j] += arr[i - 1][j - k]; // will add all the ways to get sum j
                }
            }
        }
        System.out.print(arr[n][x]); //last row and column will give excat no of ways
    }
}
