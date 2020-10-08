package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Tough*/
public class Count_of_strings_that_can_be_formed_using_a_b_and_c_under_given_constraints {
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
            int n = input.nextInt();
            countNoOfStrings(n);
            System.out.println();
        }
    }

    /*Question:Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
    * nCr meaning: n combination r
        1.No of possible solution with only a -> 1
        2.No of possible solution with 'a' and 1'b' -> nC1 (n ways to put 'b' between all 'a')
        3.No of possible solution with 'a' and 1'c' -> nC1 (n ways to put 'c' between all 'a')
        4.No of possible solution with 'a' and 2'c' -> nC2
        5.No of possible solution with 'a', 1'b' and 1'c' -> nC1 * n-1C1 (n ways to put 'b', once 'b' is fixed, n-1 ways to put 'c')
        6.No of possible solution with 'a', 1'b' and 2'c' -> nC1 * n-1C2 (n ways to put 'b', once 'b' is fixed, n-1C2 ways to put 2'c')

        Add all 6 results above :-
        Answer = 1 + nC1 + nC1 + nC2 + (nC1 * n-1C1) + (nC1 * n-1C2)
        = 1 + n + n + n*(n-1)/2 + (n * (n-1)) + (n*(n-1)*(n-2)/2)
        = 1 + 2n + n*(n-1) * (1/2 + 1 + (n-2)/2)
        = 1 + 2n + n*(n-1) * (n+1)/2
        = 1 + 2n + n*(n^2 -1)/2
    * */
    private static int countNoOfStrings(int n) {
        return 1 + (n * 2) +
                (n * ((n * n) - 1) / 2);
    }
}
