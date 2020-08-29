package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Trailing_zeroes_in_factorial {
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
            int trailingZeroesInFactorial = getTrailingZeroesInFactorial(n);
            System.out.println(trailingZeroesInFactorial);
        }
    }

    private static int getTrailingZeroesInFactorial(int n) {
        //No of 5 present  in factorial, same no of trailing zeros will be there
        int of5PresentInNFactorial = getTheNumberOf5PresentInNFactorial(n);
        return of5PresentInNFactorial;
    }

    private static int getTheNumberOf5PresentInNFactorial(int n) {
        int pow = 1;
        int noOfFive = 0;
        double data = Math.pow(5, pow);
        while (n / data >= 1) {
            noOfFive += (n / data);
            pow++;
            data = Math.pow(5, pow);
        }
        return noOfFive;
    }
}
