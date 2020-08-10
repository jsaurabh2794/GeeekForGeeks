package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Total_number_of_Strings {
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
        Pattern_Jumping.FastReader input = new Pattern_Jumping.FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int a = input.nextInt();
            getTotalNumberOfStrings(a);
            System.out.println();
        }
    }

/**
 * only a's -> 1
 * ------------------------------------------------------------------------
 * (n-1)a's and 1c => n!/(n-1)! => n*(n-1)!/(n-1)! => n
 * ------------------------------------------------------------------------
 * (n-1)a's and 1b => n!/(n-1)! => n*(n-1)!/(n-1)! => n
 * ------------------------------------------------------------------------
 * (n-2)a's and 2c => n!/(n-2)!*2! => n*(n-1)*(n-2)!/(n-2)!*2 => n*(n-1)/2
 * ------------------------------------------------------------------------
 * (n-2)a's and 1b and 1c => n!/(n-2)! => n*(n-1)*(n-2)!/(n-2)! => n*(n-1)
 */
    private static void getTotalNumberOfStrings(int a) {
        //Permutation Question
        System.out.println(((a * a * a) + (3 * a) + 2) / 2);
    }
}
